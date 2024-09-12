package tony.nguyen.bookingcarebe.domain.adapter;


import tony.nguyen.bookingcarebe.domain.model.UserRefreshToken;

import java.util.List;

public interface UserRefreshTokenAdapter {
  List<UserRefreshToken> findAllByUserIdAndInvoke(Integer userId, Boolean invoke);

  UserRefreshToken save(UserRefreshToken userRefreshToken);

  void saveAll(List<UserRefreshToken> userRefreshTokens);
}
