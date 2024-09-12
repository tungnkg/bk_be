package tony.nguyen.bookingcarebe.service.auth.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tony.nguyen.bookingcarebe.domain.adapter.UserAdapter;
import tony.nguyen.bookingcarebe.domain.adapter.UserRefreshTokenAdapter;
import tony.nguyen.bookingcarebe.domain.entity.UserRoleEntity;
import tony.nguyen.bookingcarebe.domain.model.Role;
import tony.nguyen.bookingcarebe.domain.model.User;
import tony.nguyen.bookingcarebe.domain.model.UserRefreshToken;
import tony.nguyen.bookingcarebe.domain.model.UserRole;
import tony.nguyen.bookingcarebe.repository.UserRoleRepository;
import tony.nguyen.bookingcarebe.security.JwtTokenProvider;
import tony.nguyen.bookingcarebe.service.UserService;
import tony.nguyen.bookingcarebe.service.auth.IAuthUseCase;
import tony.nguyen.bookingcarebe.service.auth.request.LoginRequest;
import tony.nguyen.bookingcarebe.service.auth.request.RegisterRequest;
import tony.nguyen.bookingcarebe.service.auth.response.LoginResponse;
import tony.nguyen.bookingcarebe.shared.constant.ExceptionMessage;
import tony.nguyen.bookingcarebe.shared.exceptions.InputNotValidException;
import tony.nguyen.bookingcarebe.shared.exceptions.NotAuthorizedException;
import tony.nguyen.bookingcarebe.shared.utils.ModelMapperUtils;
import tony.nguyen.bookingcarebe.shared.utils.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static tony.nguyen.bookingcarebe.shared.constant.ExceptionMessage.INVALID_PASSWORD;


@Component
@RequiredArgsConstructor
@Log4j2
public class AuthUseCaseImpl implements IAuthUseCase {

  private final UserAdapter userAdapter;

  private final JwtTokenProvider jwtTokenProvider;

  private final PasswordEncoder passwordEncoder;

  private final UserRefreshTokenAdapter userRefreshTokenAdapter;
  private final UserService userService;

  private final UserRoleRepository userRoleRepository;

  @Value("${vn.booking_care.secret.jwt_expiration_ms}")
  private int jwtExpirationMs;

  private static final String PASSWORD_REGEX =
      "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";

  @Override
  @Transactional
  public LoginResponse login(LoginRequest request) throws IllegalAccessException {
    User user = userAdapter.getUserByUsername(request.getUsername());
    userService.enrichRole(user);
    if (Objects.isNull(user)) {
      throw new NotAuthorizedException(ExceptionMessage.LOGIN_FAIL);
    }

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new NotAuthorizedException(ExceptionMessage.LOGIN_FAIL);
    }

    String token =
        jwtTokenProvider.generateJwtToken(user, ObjectUtils.convertUsingReflection(user));
    String refreshToken =
        jwtTokenProvider.generateRefreshToken(user, ObjectUtils.convertUsingReflection(user));
    processRefreshToken(user, refreshToken);

    if (Objects.isNull(user.getRoles()) || user.getRoles().isEmpty()) {
      user.setRoles(List.of(Role.builder().id(2L).name("USER_ROLE").build()));
    }

    return LoginResponse.builder()
        .accessToken(token)
        .refreshToken(refreshToken)
        .expiresIn(LocalDateTime.now().plusSeconds(jwtExpirationMs / 1000))
        .userInfo(user)
        .build();
  }

  @Override
  @Transactional
  public User register(RegisterRequest request) {
    User user = ModelMapperUtils.mapper(request, User.class);

    Pattern pattern = Pattern.compile(PASSWORD_REGEX);
    if (!pattern.matcher(request.getPassword()).matches()) {
      throw new InputNotValidException(INVALID_PASSWORD);
    }

    user.setPassword(passwordEncoder.encode(request.getPassword()));

    User savedUser = userAdapter.save(user);

    userRoleRepository.save(
        ModelMapperUtils.mapper(
            UserRole.builder().userId(savedUser.getId()).roleId(4).build(), UserRoleEntity.class));
    return savedUser;
  }

  private void processRefreshToken(User user, String refreshToken) {
    List<UserRefreshToken> oldToken =
        userRefreshTokenAdapter.findAllByUserIdAndInvoke(user.getId(), false);
    oldToken.forEach(e -> e.setInvoke(true));
    userRefreshTokenAdapter.saveAll(oldToken);

    UserRefreshToken userRefreshToken =
        UserRefreshToken.builder()
            .userId(user.getId())
            .invoke(false)
            .refreshToken(passwordEncoder.encode(refreshToken))
            .build();

    userRefreshTokenAdapter.save(userRefreshToken);
  }
}
