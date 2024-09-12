package tony.nguyen.bookingcarebe.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "user_refresh_token")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRefreshTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "invoke")
    private Boolean invoke;

    @Column(name = "created_date" , insertable = false, updatable = false)
    private Instant createdDate;

    @Column(name = "update_date", insertable = false, updatable = false)
    private Instant updateDate;

}