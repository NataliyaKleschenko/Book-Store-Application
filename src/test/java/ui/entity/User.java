package ui.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class User {
    private final String userName;
    private final String password;
}
