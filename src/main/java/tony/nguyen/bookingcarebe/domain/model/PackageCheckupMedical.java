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
public class PackageCheckupMedical {
    private Integer id;
    private String name;
    private String description;
    private Integer clinic;
    private Integer specialty;
}
