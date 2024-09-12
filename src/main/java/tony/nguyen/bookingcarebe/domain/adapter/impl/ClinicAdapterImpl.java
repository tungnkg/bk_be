package tony.nguyen.bookingcarebe.domain.adapter.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import tony.nguyen.bookingcarebe.domain.adapter.ClinicAdapter;
import tony.nguyen.bookingcarebe.domain.entity.ClinicEntity;
import tony.nguyen.bookingcarebe.domain.model.Clinic;
import tony.nguyen.bookingcarebe.repository.ClinicRepository;
import tony.nguyen.bookingcarebe.shared.utils.ModelMapperUtils;

@Component
@RequiredArgsConstructor
public class ClinicAdapterImpl implements ClinicAdapter {
    private final ClinicRepository clinicRepository;
    @Override
    public void save(Clinic clinic) {
        clinicRepository.save(ModelMapperUtils.mapper(clinic, ClinicEntity.class));
    }

    @Override
    public Clinic getClinicById(Integer id) {
        return  ModelMapperUtils.mapper(clinicRepository.findById(id).orElse(null), Clinic.class);
    }

    @Override
    public Page<Clinic> getAllByCondition() {
        return  ModelMapperUtils.mapPage(clinicRepository.findAll(PageRequest.of(1, 10)), Clinic.class);
    }

    @Override
    public void delete(Integer id) {
        Clinic clinic = getClinicById(id);
        if(clinic != null) {
            clinic.setIsDeleted(true);
            save(clinic);
        }
    }
}
