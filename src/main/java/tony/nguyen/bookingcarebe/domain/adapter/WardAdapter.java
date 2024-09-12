package tony.nguyen.bookingcarebe.domain.adapter;

import tony.nguyen.bookingcarebe.domain.model.District;
import tony.nguyen.bookingcarebe.domain.model.Ward;

import java.util.List;

public interface WardAdapter {
    List<Ward> getAll();
    Ward getWardById(Integer id);
    List<Ward> getWardByDistrictId(Integer districtId);
}
