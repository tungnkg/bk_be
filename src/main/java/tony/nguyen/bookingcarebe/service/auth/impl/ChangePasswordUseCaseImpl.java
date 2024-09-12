package tony.nguyen.bookingcarebe.service.auth.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tony.nguyen.bookingcarebe.domain.adapter.UserAdapter;
import tony.nguyen.bookingcarebe.domain.model.User;
import tony.nguyen.bookingcarebe.service.auth.IChangePasswordUseCase;
import tony.nguyen.bookingcarebe.service.auth.request.ChangePasswordRequest;
import tony.nguyen.bookingcarebe.service.dto.CustomUserDetails;
import tony.nguyen.bookingcarebe.shared.exceptions.NotAuthorizedException;
import tony.nguyen.bookingcarebe.shared.utils.AuthUtils;

import java.util.Objects;

import static tony.nguyen.bookingcarebe.shared.constant.ExceptionMessage.NOT_VALID_USER_DETAILS;
import static tony.nguyen.bookingcarebe.shared.constant.ExceptionMessage.OLD_PASSWORD_NOT_TRUE;


@Component
@RequiredArgsConstructor
public class ChangePasswordUseCaseImpl implements IChangePasswordUseCase {
  private final PasswordEncoder passwordEncoder;
  private final UserAdapter userAdapter;

  @Override
  public void changePassword(ChangePasswordRequest request) {
    CustomUserDetails userDetails = AuthUtils.getAuthUserDetails();

    if (Objects.isNull(userDetails) || Objects.isNull(userDetails.getUser())) {
      throw new NotAuthorizedException(NOT_VALID_USER_DETAILS);
    }

    User user = userDetails.getUser();
    String currentPassword = user.getPassword();

    if (!passwordEncoder.matches(request.getOldPassword(), currentPassword)) {
      throw new NotAuthorizedException(OLD_PASSWORD_NOT_TRUE);
    }

    String hashPassword = passwordEncoder.encode(request.getNewPassword());
    user.setPassword(hashPassword);

    userAdapter.save(user);
  }
}
