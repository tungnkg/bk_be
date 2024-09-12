package tony.nguyen.bookingcarebe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tony.nguyen.bookingcarebe.domain.entity.RoleEntity;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    List<Object> findAllByIdIn(List<Integer> ids);
}