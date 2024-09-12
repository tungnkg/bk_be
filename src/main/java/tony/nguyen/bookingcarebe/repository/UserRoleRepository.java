package tony.nguyen.bookingcarebe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tony.nguyen.bookingcarebe.domain.entity.UserRoleEntity;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {
    List<Object> findAllByUserIdIn(List<Integer> userIds);
}