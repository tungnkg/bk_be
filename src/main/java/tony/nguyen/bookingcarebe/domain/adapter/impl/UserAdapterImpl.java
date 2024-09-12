package tony.nguyen.bookingcarebe.domain.adapter.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import tony.nguyen.bookingcarebe.domain.adapter.UserAdapter;
import tony.nguyen.bookingcarebe.domain.entity.UserEntity;
import tony.nguyen.bookingcarebe.domain.model.User;
import tony.nguyen.bookingcarebe.repository.UserRepository;
import tony.nguyen.bookingcarebe.shared.utils.ModelMapperUtils;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserAdapterImpl implements UserAdapter {
  private final UserRepository userRepository;

  @Override
  public User getUserByUsername(String username) {
    Optional<UserEntity> optionalUser = userRepository.findByUsername(username);
    return optionalUser
        .map(userEntity -> ModelMapperUtils.mapper(userEntity, User.class))
        .orElse(null);
  }

  @Override
  public User save(User user) {
    return ModelMapperUtils.mapper(
        userRepository.save(ModelMapperUtils.mapper(user, UserEntity.class)), User.class);
  }

  @Override
  public List<User> getUserByIdIn(List<Integer> ids) {
    return ModelMapperUtils.mapList(userRepository.findAllByIdIn(ids), User.class);
  }

  @Override
  public void deleteUserById(Integer id) {
    userRepository.deleteById(id);
  }
}
