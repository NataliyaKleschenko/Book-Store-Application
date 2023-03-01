package ui.page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private final By inputUserName = By.id("userName");
    private final By inputUserPassword = By.id("password");
    private final By buttonLogin = By.id("login");
    public LoginPage typeUserName(String userName) {
        fillForm(inputUserName,userName);
        return this;
    }
    public LoginPage typeUserPassword(String password) {
        fillForm(inputUserPassword,password);
        return this;
    }
    public LoginPage clickOnButtonLogin() {
        clickOnElement(buttonLogin);
        return this;
    }
}
