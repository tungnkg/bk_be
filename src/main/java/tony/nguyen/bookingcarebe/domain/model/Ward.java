package tony.nguyen.bookingcarebe.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ward {
    private Integer id;
    private Integer districtId;
    private String name;
}
