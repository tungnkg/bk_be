package tony.nguyen.bookingcarebe.shared.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import tony.nguyen.bookingcarebe.service.dto.CustomUserDetails;

public class AuthUtils {
  public static CustomUserDetails getAuthUserDetails() {
    try {
      return (CustomUserDetails)
          SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    } catch (Exception e) {
      return null;
    }
  }
}
