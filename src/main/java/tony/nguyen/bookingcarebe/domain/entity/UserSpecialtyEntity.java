package tony.nguyen.bookingcarebe.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_specialties")
public class UserSpecialtyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "specialty_id")
    private Integer specialty;

    @Column(name = "user_id")
    private Integer user;

}