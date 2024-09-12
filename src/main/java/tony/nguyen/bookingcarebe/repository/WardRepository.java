package tony.nguyen.bookingcarebe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tony.nguyen.bookingcarebe.domain.entity.WardEntity;

import java.util.List;

public interface WardRepository extends JpaRepository<WardEntity, Integer> {
    List<WardEntity> findByDistrictId(Integer districtId);
}