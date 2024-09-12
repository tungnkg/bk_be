package tony.nguyen.bookingcarebe.service.auth;

import tony.nguyen.bookingcarebe.service.auth.request.LoginRefreshTokenRequest;
import tony.nguyen.bookingcarebe.service.auth.response.LoginResponse;

public interface ILoginRefreshTokenUseCase {
  LoginResponse login(LoginRefreshTokenRequest request) throws IllegalAccessException;
}
