package tony.nguyen.bookingcarebe.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class District {
    private Integer id;
    private Integer provinceId;
    private String name;
}
