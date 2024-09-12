package tony.nguyen.bookingcarebe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tony.nguyen.bookingcarebe.domain.entity.ClinicEntity;

public interface ClinicRepository extends JpaRepository<ClinicEntity, Integer> {
}