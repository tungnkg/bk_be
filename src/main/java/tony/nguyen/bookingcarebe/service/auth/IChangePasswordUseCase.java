package tony.nguyen.bookingcarebe.service.auth;


import tony.nguyen.bookingcarebe.service.auth.request.ChangePasswordRequest;

public interface IChangePasswordUseCase {
  void changePassword(ChangePasswordRequest request);
}
