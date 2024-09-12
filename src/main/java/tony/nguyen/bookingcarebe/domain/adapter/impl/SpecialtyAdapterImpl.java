package tony.nguyen.bookingcarebe.domain.adapter.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import tony.nguyen.bookingcarebe.domain.adapter.ClinicAdapter;
import tony.nguyen.bookingcarebe.domain.adapter.SpecialtyAdapter;
import tony.nguyen.bookingcarebe.domain.entity.ClinicEntity;
import tony.nguyen.bookingcarebe.domain.entity.SpecialtyEntity;
import tony.nguyen.bookingcarebe.domain.model.Clinic;
import tony.nguyen.bookingcarebe.domain.model.Specialty;
import tony.nguyen.bookingcarebe.repository.ClinicRepository;
import tony.nguyen.bookingcarebe.repository.SpecialtyRepository;
import tony.nguyen.bookingcarebe.shared.utils.ModelMapperUtils;

@Component
@RequiredArgsConstructor
public class SpecialtyAdapterImpl implements SpecialtyAdapter {
    private final SpecialtyRepository specialtyRepository;
    @Override
    public void save(Specialty specialty) {
        specialtyRepository.save(ModelMapperUtils.mapper(specialty, SpecialtyEntity.class));
    }

    @Override
    public Specialty getSpecialtyById(Integer id) {
        return  ModelMapperUtils.mapper(specialtyRepository.findById(id).orElse(null), Specialty.class);
    }

    @Override
    public Page<Specialty> getAllByCondition() {
        return  ModelMapperUtils.mapPage(specialtyRepository.findAll(PageRequest.of(1, 10)), Specialty.class);
    }

    @Override
    public void delete(Integer id) {
        Specialty specialty = getSpecialtyById(id);
        if(specialty != null) {
            specialty.setIsDeleted(true);
            save(specialty);
        }
    }
}
