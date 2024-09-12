package tony.nguyen.bookingcarebe.domain.adapter;

import tony.nguyen.bookingcarebe.domain.model.Province;

import java.util.List;

public interface ProvinceAdapter {
    List<Province> getAll();
    Province getProvinceById(Integer id);
}
