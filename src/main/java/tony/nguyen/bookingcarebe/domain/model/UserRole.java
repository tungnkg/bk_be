package tony.nguyen.bookingcarebe.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole {
  private Integer id;
  private Integer userId;
  private Integer roleId;
}
