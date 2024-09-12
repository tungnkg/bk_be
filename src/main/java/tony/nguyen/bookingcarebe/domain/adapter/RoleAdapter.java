package tony.nguyen.bookingcarebe.domain.adapter;

import tony.nguyen.bookingcarebe.domain.entity.RoleEntity;
import tony.nguyen.bookingcarebe.domain.model.Role;
import tony.nguyen.bookingcarebe.domain.model.UserRole;

import java.util.List;

public interface RoleAdapter {
  List<Role> findAllByIdIn(List<Integer> ids);

  List<UserRole> findAllByUserIdIn(List<Integer> userIds);

  List<Role> getAll();

  void saveAll(List<Role> roleEntities);
}
