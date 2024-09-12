package tony.nguyen.bookingcarebe.shared.exceptions;

public class InputNotValidException extends RuntimeException {
  public InputNotValidException(String errorMsg) {
    super(errorMsg);
  }
}
