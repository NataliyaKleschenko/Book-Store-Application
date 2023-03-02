package ui.page;
import org.openqa.selenium.By;
public class LoginPage extends BasePage{
    private final By inputUserName = By.id("userName");
    private final By inputUserPassword = By.id("password");
    private final By buttonLogin = By.id("login");
    private final By invalidUserNameOrPasswordMessage = By.xpath("//p[@id='name']");
    public LoginPage typeUserName(String userName) {
        fillForm(inputUserName,userName);
        logger.info("Entered username " + userName);
        return this;
    }
    public LoginPage typeUserPassword(String password) {
        logger.info("Entered password " + password);
        fillForm(inputUserPassword,password);
        return this;
    }
    public AuthorizedUserPage clickOnButtonLogin() {
        clickOnElement(buttonLogin);
        return new AuthorizedUserPage();
    }
    public String getTextFromInvalidUserNameOrPasswordMessage() {
        return getTextFromElement(invalidUserNameOrPasswordMessage);
    }
    public boolean checkLocation() {
        logger.info(driver.getCurrentUrl());
        return driver.getCurrentUrl().equals("https://demoqa.com/login");
    }
    public String getCssValueFromPasswordInput() {
        return driver.findElement(inputUserName).getCssValue("color");
    }
}
