package ui.step;

import ui.entity.User;
import ui.page.LoginPage;

public class LoginPageStep extends LoginPage {
    public void login(User user) {
        typeUserName(user.getUserName())
                .typeUserPassword(user.getPassword())
                .clickOnButtonLogin();
        logger.info("Trying to login...");
    }
}
