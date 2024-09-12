package tony.nguyen.bookingcarebe.service.auth.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tony.nguyen.bookingcarebe.domain.adapter.UserAdapter;
import tony.nguyen.bookingcarebe.domain.adapter.UserRefreshTokenAdapter;
import tony.nguyen.bookingcarebe.domain.model.User;
import tony.nguyen.bookingcarebe.domain.model.UserRefreshToken;
import tony.nguyen.bookingcarebe.security.JwtTokenProvider;
import tony.nguyen.bookingcarebe.service.auth.ILoginRefreshTokenUseCase;
import tony.nguyen.bookingcarebe.service.auth.request.LoginRefreshTokenRequest;
import tony.nguyen.bookingcarebe.service.auth.response.LoginResponse;
import tony.nguyen.bookingcarebe.shared.exceptions.NotAuthorizedException;
import tony.nguyen.bookingcarebe.shared.utils.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static tony.nguyen.bookingcarebe.shared.constant.ExceptionMessage.LOGIN_FAIL;
import static tony.nguyen.bookingcarebe.shared.constant.ExceptionMessage.REFRESH_TOKEN_NOT_VALID;


@Component
@RequiredArgsConstructor
@Log4j2
public class LoginRefreshTokenUseCaseImpl implements ILoginRefreshTokenUseCase {
  private final JwtTokenProvider jwtTokenProvider;
  private final UserAdapter userAdapter;
  private final UserRefreshTokenAdapter userRefreshTokenAdapter;
  private final PasswordEncoder passwordEncoder;

  @Value("${vn.booking_care.secret.jwt_expiration_ms}")
  private int jwtExpirationMs;

  @Override
  @Transactional
  public LoginResponse login(LoginRefreshTokenRequest request) throws IllegalAccessException {
    boolean isValidToken = jwtTokenProvider.validateJwtToken(request.getToken());
    if (!isValidToken) {
      throw new NotAuthorizedException(REFRESH_TOKEN_NOT_VALID);
    }

    User tokenUser =
        userAdapter.getUserByUsername(jwtTokenProvider.getUsernameByToken(request.getToken()));

    if (Objects.isNull(tokenUser)) {
      throw new NotAuthorizedException(LOGIN_FAIL);
    }

    List<UserRefreshToken> userRefreshTokenList =
        userRefreshTokenAdapter.findAllByUserIdAndInvoke(tokenUser.getId(), false);

    if (userRefreshTokenList.isEmpty()) {
      throw new NotAuthorizedException(REFRESH_TOKEN_NOT_VALID);
    }

    UserRefreshToken currentRefreshToken = userRefreshTokenList.get(0);

    if (!passwordEncoder.matches(request.getToken(), currentRefreshToken.getRefreshToken())) {
      throw new NotAuthorizedException(REFRESH_TOKEN_NOT_VALID);
    }

    return LoginResponse.builder()
        .accessToken(
            jwtTokenProvider.generateJwtToken(
                tokenUser, ObjectUtils.convertUsingReflection(tokenUser)))
        .refreshToken(request.getToken())
        .expiresIn(LocalDateTime.now().plusSeconds(jwtExpirationMs / 1000))
        .userInfo(tokenUser)
        .build();
  }
}
