package tony.nguyen.bookingcarebe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tony.nguyen.bookingcarebe.domain.entity.ProvinceEntity;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Integer> {
}