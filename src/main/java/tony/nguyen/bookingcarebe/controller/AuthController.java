package tony.nguyen.bookingcarebe.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tony.nguyen.bookingcarebe.domain.model.User;
import tony.nguyen.bookingcarebe.service.auth.IAuthUseCase;
import tony.nguyen.bookingcarebe.service.auth.ILoginRefreshTokenUseCase;
import tony.nguyen.bookingcarebe.service.auth.request.LoginRefreshTokenRequest;
import tony.nguyen.bookingcarebe.service.auth.request.LoginRequest;
import tony.nguyen.bookingcarebe.service.auth.request.RegisterRequest;
import tony.nguyen.bookingcarebe.service.auth.response.LoginResponse;
import tony.nguyen.bookingcarebe.service.dto.BaseResponse;
import tony.nguyen.bookingcarebe.shared.factory.ResponseFactory;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthUseCase iAuthUseCase;
    private final ILoginRefreshTokenUseCase iLoginRefreshTokenUseCase;

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody @Valid LoginRequest request)
            throws IllegalAccessException {
        return ResponseFactory.success(iAuthUseCase.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<User>> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseFactory.success(iAuthUseCase.register(request));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<BaseResponse<LoginResponse>> refreshTokenLogin(
            @RequestBody @Valid
            LoginRefreshTokenRequest request) throws IllegalAccessException {
        return ResponseFactory.success(iLoginRefreshTokenUseCase.login(request));
    }
}
