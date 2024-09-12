package tony.nguyen.bookingcarebe.domain.adapter;

import org.springframework.data.domain.Page;
import tony.nguyen.bookingcarebe.domain.model.Clinic;

public interface ClinicAdapter {
    void save(Clinic clinic);
    Clinic getClinicById(Integer id);
    Page<Clinic> getAllByCondition();
    void delete(Integer id);
}
