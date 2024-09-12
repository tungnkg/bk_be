package tony.nguyen.bookingcarebe.domain.adapter.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tony.nguyen.bookingcarebe.domain.adapter.WardAdapter;
import tony.nguyen.bookingcarebe.domain.model.Ward;
import tony.nguyen.bookingcarebe.repository.WardRepository;
import tony.nguyen.bookingcarebe.shared.utils.ModelMapperUtils;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WardAdapterImpl implements WardAdapter {
    private final WardRepository wardRepository;

    @Override
    public List<Ward> getAll() {
        return ModelMapperUtils.mapList(wardRepository.findAll(), Ward.class);
    }

    @Override
    public List<Ward> getWardByDistrictId(Integer districtId) {
        return ModelMapperUtils.mapList(wardRepository.findByDistrictId(districtId), Ward.class);
    }

    @Override
    public Ward getWardById(Integer id)
    {
        return ModelMapperUtils.mapper(wardRepository.findById(id).orElse(null), Ward.class);
    }

}
