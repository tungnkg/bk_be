package tony.nguyen.bookingcarebe.service.auth;


import tony.nguyen.bookingcarebe.domain.model.User;
import tony.nguyen.bookingcarebe.service.auth.request.LoginRequest;
import tony.nguyen.bookingcarebe.service.auth.request.RegisterRequest;
import tony.nguyen.bookingcarebe.service.auth.response.LoginResponse;

public interface IAuthUseCase {
  LoginResponse login(LoginRequest request) throws IllegalAccessException;

  User register(RegisterRequest request);
}
