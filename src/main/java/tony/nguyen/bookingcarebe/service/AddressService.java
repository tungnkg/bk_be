package tony.nguyen.bookingcarebe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tony.nguyen.bookingcarebe.domain.adapter.DistrictAdapter;
import tony.nguyen.bookingcarebe.domain.adapter.ProvinceAdapter;
import tony.nguyen.bookingcarebe.domain.adapter.WardAdapter;
import tony.nguyen.bookingcarebe.domain.model.Clinic;
import tony.nguyen.bookingcarebe.domain.model.District;
import tony.nguyen.bookingcarebe.domain.model.Province;
import tony.nguyen.bookingcarebe.domain.model.Ward;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final ProvinceAdapter provinceAdapter;
    private final DistrictAdapter districtAdapter;
    private final WardAdapter wardAdapter;

    public List<Province> getAllProvinces() {
        return provinceAdapter.getAll();
    }

    public List<District> getAllDistrictByProvinceId(Integer provinceId) {
        return districtAdapter.getDistrictByProvinceId(provinceId);
    }

    public List<Ward> getAllWardByDistrictId(Integer districtId) {
        return wardAdapter.getWardByDistrictId(districtId);
    }
}
