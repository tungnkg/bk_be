package tony.nguyen.bookingcarebe.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "schedules")
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "current_number")
    private Integer currentNumber;

    @Column(name = "max_number")
    private Integer maxNumber;

    @Column(name = "date")
    private Instant date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "user_id")
    private Integer user;

}