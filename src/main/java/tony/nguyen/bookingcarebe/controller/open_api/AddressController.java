package tony.nguyen.bookingcarebe.controller.open_api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tony.nguyen.bookingcarebe.domain.model.District;
import tony.nguyen.bookingcarebe.domain.model.Province;
import tony.nguyen.bookingcarebe.domain.model.Ward;
import tony.nguyen.bookingcarebe.service.AddressService;
import tony.nguyen.bookingcarebe.service.auth.request.LoginRequest;
import tony.nguyen.bookingcarebe.service.auth.response.LoginResponse;
import tony.nguyen.bookingcarebe.service.dto.BaseResponse;
import tony.nguyen.bookingcarebe.shared.factory.ResponseFactory;

import java.util.List;

@RestController
@RequestMapping("open-api/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("province")
    public ResponseEntity<BaseResponse<List<Province>>> getAllProvince()
            throws IllegalAccessException {
        return ResponseFactory.success(addressService.getAllProvinces());
    }

    @GetMapping("district/{provinceId}")
    public ResponseEntity<BaseResponse<List<District>>> getAllDistrictByProvinceId(@PathVariable @Valid Integer provinceId)
            throws IllegalAccessException {
        return ResponseFactory.success(addressService.getAllDistrictByProvinceId(provinceId));
    }

    @GetMapping("ward/{districtId}")
    public ResponseEntity<BaseResponse<List<Ward>>> getAllWardByDistrictId(@PathVariable @Valid Integer districtId)
            throws IllegalAccessException {
        return ResponseFactory.success(addressService.getAllWardByDistrictId(districtId));
    }
}
