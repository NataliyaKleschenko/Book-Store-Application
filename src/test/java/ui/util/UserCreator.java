package ui.util;
import ui.entity.User;
public class UserCreator {
    public static final String USER_NAME = DataProperties.getDataProperties("userName");
    public static final String PASSWORD = DataProperties.getDataProperties("password");
    public static User createCorrectUser() {
        return new User(USER_NAME,PASSWORD);
    }
}
