package tony.nguyen.bookingcarebe.domain.adapter.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tony.nguyen.bookingcarebe.domain.adapter.ProvinceAdapter;
import tony.nguyen.bookingcarebe.domain.model.Province;
import tony.nguyen.bookingcarebe.repository.ProvinceRepository;
import tony.nguyen.bookingcarebe.shared.utils.ModelMapperUtils;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProvinceAdapterImpl implements ProvinceAdapter {
    private final ProvinceRepository provinceRepository;

    @Override
    public List<Province> getAll() {
        return ModelMapperUtils.mapList(provinceRepository.findAll(), Province.class);
    }

    @Override
    public Province getProvinceById(Integer id) {
        return ModelMapperUtils.mapper(provinceRepository.findById(id).orElse(null), Province.class);
    }
}
