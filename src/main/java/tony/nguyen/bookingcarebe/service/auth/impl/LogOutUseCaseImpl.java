package tony.nguyen.bookingcarebe.service.auth.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tony.nguyen.bookingcarebe.domain.adapter.UserRefreshTokenAdapter;
import tony.nguyen.bookingcarebe.domain.model.User;
import tony.nguyen.bookingcarebe.domain.model.UserRefreshToken;
import tony.nguyen.bookingcarebe.service.auth.ILogOutUseCase;
import tony.nguyen.bookingcarebe.service.dto.CustomUserDetails;
import tony.nguyen.bookingcarebe.shared.utils.AuthUtils;


import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class LogOutUseCaseImpl implements ILogOutUseCase {
  private final UserRefreshTokenAdapter userRefreshTokenAdapter;

  @Override
  @Transactional
  public void logout() {
    CustomUserDetails userDetails = AuthUtils.getAuthUserDetails();

    if (Objects.isNull(userDetails) || Objects.isNull(userDetails.getUser())) {
      return;
    }

    User user = userDetails.getUser();

    List<UserRefreshToken> oldToken =
        userRefreshTokenAdapter.findAllByUserIdAndInvoke(user.getId(), false);
    oldToken.forEach(e -> e.setInvoke(true));
    userRefreshTokenAdapter.saveAll(oldToken);
  }
}
