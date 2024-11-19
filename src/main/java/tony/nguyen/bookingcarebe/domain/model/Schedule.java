package tony.nguyen.bookingcarebe.domain.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule {
    private Integer id;
    private Integer currentNumber;
    private Integer maxNumber;
    private Instant date;
    private LocalTime time;
    private Integer user;
}
