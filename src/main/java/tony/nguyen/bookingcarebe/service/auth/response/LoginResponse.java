package tony.nguyen.bookingcarebe.service.auth.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tony.nguyen.bookingcarebe.domain.model.User;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class LoginResponse {
    private String accessToken;
    private LocalDateTime expiresIn;
    private String refreshToken;
    private User userInfo;
}
