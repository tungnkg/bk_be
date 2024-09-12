package tony.nguyen.bookingcarebe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tony.nguyen.bookingcarebe.domain.entity.DistrictEntity;

import java.util.List;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Integer> {
    List<DistrictEntity> findByProvinceId(Integer provinceId);
}