package api.model.user;

import lombok.Data;

@Data
public class UserErrorResponse {
    private String code;
    private String message;
}
