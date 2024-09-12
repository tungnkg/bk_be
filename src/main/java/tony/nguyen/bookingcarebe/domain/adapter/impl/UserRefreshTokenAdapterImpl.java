package tony.nguyen.bookingcarebe.domain.adapter.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tony.nguyen.bookingcarebe.domain.adapter.UserRefreshTokenAdapter;
import tony.nguyen.bookingcarebe.domain.entity.UserRefreshTokenEntity;
import tony.nguyen.bookingcarebe.domain.model.UserRefreshToken;
import tony.nguyen.bookingcarebe.repository.UserRefreshTokenRepository;
import tony.nguyen.bookingcarebe.shared.utils.ModelMapperUtils;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserRefreshTokenAdapterImpl implements UserRefreshTokenAdapter {
  private final UserRefreshTokenRepository userRefreshTokenRepository;

  @Override
  public List<UserRefreshToken> findAllByUserIdAndInvoke(Integer userId, Boolean invoke) {
    return ModelMapperUtils.mapList(
        userRefreshTokenRepository.findAllByUserIdAndInvoke(userId, invoke),
        UserRefreshToken.class);
  }

  @Override
  public UserRefreshToken save(UserRefreshToken userRefreshToken) {
    return ModelMapperUtils.mapper(
        userRefreshTokenRepository.save(
            ModelMapperUtils.mapper(userRefreshToken, UserRefreshTokenEntity.class)),
        UserRefreshToken.class);
  }

  @Override
  public void saveAll(List<UserRefreshToken> userRefreshTokens) {
    userRefreshTokenRepository.saveAll(
        ModelMapperUtils.mapList(userRefreshTokens, UserRefreshTokenEntity.class));
  }
}
