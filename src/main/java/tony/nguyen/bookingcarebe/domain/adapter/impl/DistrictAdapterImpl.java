package tony.nguyen.bookingcarebe.domain.adapter.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tony.nguyen.bookingcarebe.domain.adapter.DistrictAdapter;
import tony.nguyen.bookingcarebe.domain.model.District;
import tony.nguyen.bookingcarebe.repository.DistrictRepository;
import tony.nguyen.bookingcarebe.shared.utils.ModelMapperUtils;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DistrictAdapterImpl implements DistrictAdapter {
    private final DistrictRepository districtRepository;

    @Override
    public List<District> getAll() {
        return ModelMapperUtils.mapList(districtRepository.findAll(), District.class);
    }

    @Override
    public District getDistrictById(Integer id) {
        return ModelMapperUtils.mapper(districtRepository.findById(id).orElse(null), District.class);
    }

    @Override
    public List<District> getDistrictByProvinceId(Integer provinceId) {
        return  ModelMapperUtils.mapList(districtRepository.findByProvinceId(provinceId), District.class);
    }
}
