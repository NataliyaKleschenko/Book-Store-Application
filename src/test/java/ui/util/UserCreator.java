package ui.util;
import org.apache.commons.lang3.RandomStringUtils;
import ui.entity.User;
public class UserCreator {
    public static final String USER_NAME = RandomStringUtils.randomAlphanumeric(7);
    public static final String PASSWORD = RandomStringUtils.randomAlphanumeric(7) + "*/";
    public static User createCorrectUser() {
        return new User(USER_NAME,PASSWORD);
    }
    public static User createEmptyUser() {
        return new User("","");
    }
    public static User createRandomUser(){
        return new User(RandomStringUtils.randomAlphanumeric(8),RandomStringUtils.randomAlphabetic(8));
    }
}
