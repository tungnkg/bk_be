package tony.nguyen.bookingcarebe.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {
    private String message;
    private boolean success;

    public boolean getSuccess() {
        return success;
    }
}
