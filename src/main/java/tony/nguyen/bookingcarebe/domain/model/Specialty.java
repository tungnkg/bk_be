package tony.nguyen.bookingcarebe.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Specialty {
    private Integer id;
    private String name;
    private String description;
    private String imagePath;
    private Instant createdDate;
    private Boolean isDeleted;
    private Instant updatedDate;
}
