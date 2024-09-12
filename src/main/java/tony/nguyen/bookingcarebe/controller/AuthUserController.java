package tony.nguyen.bookingcarebe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tony.nguyen.bookingcarebe.service.auth.IChangePasswordUseCase;
import tony.nguyen.bookingcarebe.service.auth.ILogOutUseCase;
import tony.nguyen.bookingcarebe.service.auth.request.ChangePasswordRequest;
import tony.nguyen.bookingcarebe.service.dto.BaseResponse;
import tony.nguyen.bookingcarebe.shared.factory.ResponseFactory;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class AuthUserController {
    private final IChangePasswordUseCase iChangePasswordUseCase;
    private final ILogOutUseCase iLogOutUseCase;

    @PostMapping("/change-password")
    public ResponseEntity<BaseResponse> changePassword(ChangePasswordRequest request) {
        iChangePasswordUseCase.changePassword(request);
        return ResponseFactory.success();
    }

    @PostMapping("/logout")
    public ResponseEntity<BaseResponse> logout() {
        iLogOutUseCase.logout();
        return ResponseFactory.success();
    }
}
