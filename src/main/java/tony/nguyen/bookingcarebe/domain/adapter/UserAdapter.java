package tony.nguyen.bookingcarebe.domain.adapter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tony.nguyen.bookingcarebe.domain.model.User;

import java.util.List;

public interface UserAdapter {
  User getUserByUsername(String username);

  User save(User user);

  List<User> getUserByIdIn(List<Integer> ids);

  void deleteUserById(Integer id);
}
