package tony.nguyen.bookingcarebe.domain.adapter;

import org.springframework.data.domain.Page;
import tony.nguyen.bookingcarebe.domain.model.Specialty;

public interface SpecialtyAdapter {
    void save(Specialty specialty);
    Specialty getSpecialtyById(Integer id);
    void delete(Integer id);
    Page<Specialty> getAllByCondition();
}
