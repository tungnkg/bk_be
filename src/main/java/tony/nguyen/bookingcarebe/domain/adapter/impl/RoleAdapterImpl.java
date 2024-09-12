package tony.nguyen.bookingcarebe.domain.adapter.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tony.nguyen.bookingcarebe.domain.adapter.RoleAdapter;
import tony.nguyen.bookingcarebe.domain.entity.RoleEntity;
import tony.nguyen.bookingcarebe.domain.model.Role;
import tony.nguyen.bookingcarebe.domain.model.UserRole;
import tony.nguyen.bookingcarebe.repository.RoleRepository;
import tony.nguyen.bookingcarebe.repository.UserRoleRepository;
import tony.nguyen.bookingcarebe.shared.utils.ModelMapperUtils;


import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleAdapterImpl implements RoleAdapter {
  private final RoleRepository roleRepository;
  private final UserRoleRepository userRoleRepository;

  @Override
  public List<Role> findAllByIdIn(List<Integer> ids) {
    return ModelMapperUtils.mapList(roleRepository.findAllByIdIn(ids), Role.class);
  }

  @Override
  public List<UserRole> findAllByUserIdIn(List<Integer> userIds) {
    return ModelMapperUtils.mapList(userRoleRepository.findAllByUserIdIn(userIds), UserRole.class);
  }

  @Override
  public List<Role> getAll() {
    return ModelMapperUtils.mapList(roleRepository.findAll(), Role.class);
  }

  @Override
  public void saveAll(List<Role> roles) {
    roleRepository.saveAll(ModelMapperUtils.mapList(roles , RoleEntity.class));
  }

}
