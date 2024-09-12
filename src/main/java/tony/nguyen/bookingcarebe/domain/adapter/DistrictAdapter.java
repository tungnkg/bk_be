package tony.nguyen.bookingcarebe.domain.adapter;

import tony.nguyen.bookingcarebe.domain.model.District;
import tony.nguyen.bookingcarebe.domain.model.Province;

import java.util.List;

public interface DistrictAdapter {
    List<District> getAll();
    District getDistrictById(Integer id);
    List<District> getDistrictByProvinceId(Integer provinceId);
}
