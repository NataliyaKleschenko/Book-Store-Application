package api.model.user;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor @NoArgsConstructor
public class UserRequest {
    private String userName;
    private String password;
}
