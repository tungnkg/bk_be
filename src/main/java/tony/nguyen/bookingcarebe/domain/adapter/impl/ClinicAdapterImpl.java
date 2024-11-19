package tony.nguyen.bookingcarebe.domain.adapter.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import tony.nguyen.bookingcarebe.domain.adapter.ClinicAdapter;
import tony.nguyen.bookingcarebe.domain.entity.ClinicEntity;
import tony.nguyen.bookingcarebe.domain.entity_elastic.ClinicElasticEntityRepository;
import tony.nguyen.bookingcarebe.domain.model.Clinic;
import tony.nguyen.bookingcarebe.repository.ClinicRepository;
import tony.nguyen.bookingcarebe.repository.elasticsearch.ClinicElasticSearchRepository;
import tony.nguyen.bookingcarebe.shared.utils.ModelMapperUtils;

@Component
@RequiredArgsConstructor
public class ClinicAdapterImpl implements ClinicAdapter {
    private final ClinicRepository clinicRepository;
    private final ClinicElasticSearchRepository clinicElasticSearchRepository;
        @Override
    public void save(Clinic clinic) {
        clinicRepository.save(ModelMapperUtils.mapper(clinic, ClinicEntity.class));
        clinicElasticSearchRepository.save(ModelMapperUtils.mapper(clinic, ClinicElasticEntityRepository.class));
    }

    @Override
    public Clinic getClinicById(Integer id) {
        return  ModelMapperUtils.mapper(clinicElasticSearchRepository.findById(id).orElse(null), Clinic.class);
    }

    @Override
    public Page<Clinic> getAllByCondition() {
        return  ModelMapperUtils.mapPage(clinicElasticSearchRepository.findAll(PageRequest.of(1, 10)), Clinic.class);
    }

    @Override
    public void delete(Integer id) {
        this.clinicRepository.deleteById(id);
        this.clinicElasticSearchRepository.deleteById(id);
    }
}
