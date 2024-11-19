package tony.nguyen.bookingcarebe.domain.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserClinic {
    private Integer id;
    private Integer user;
    private Integer clinic;
    private String memberCode;
}
