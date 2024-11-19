package tony.nguyen.bookingcarebe.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_clinics")
public class UserClinicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id")
    private Integer user;

    @Column(name = "clinic_id")
    private Integer clinic;

    @Size(max = 10)
    @Column(name = "member_code", length = 10)
    private String memberCode;

}