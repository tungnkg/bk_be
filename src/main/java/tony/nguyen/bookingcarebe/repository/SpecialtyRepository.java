package tony.nguyen.bookingcarebe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tony.nguyen.bookingcarebe.domain.entity.SpecialtyEntity;

public interface SpecialtyRepository extends JpaRepository<SpecialtyEntity, Integer> {
}