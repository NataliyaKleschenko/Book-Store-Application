package ui.test;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.step.AuthorizedUserStep;
import ui.step.HomePageStep;
import ui.step.LoginPageStep;
import ui.util.UserCreator;
import static ui.util.UserCreator.USER_NAME;

public class LoginPageTest extends BaseTest {
    @BeforeMethod
    public void openPageAndClickToLogin() {
        HomePageStep homePageStep = new HomePageStep();
        homePageStep.openPageAndClickOnLoginButton();
    }
    @Test
    @Description("login with valid data")
    public void testLogin() {
        LoginPageStep loginPageStep = new LoginPageStep();
        AuthorizedUserStep authorizedUserStep = new AuthorizedUserStep();
        loginPageStep.login(UserCreator.createCorrectUser());
        String actual = authorizedUserStep.getAuthorizedUserName();

        Assert.assertEquals(actual, USER_NAME);
    }
    @Test
    public void testLoginWithEmptyField() {
        LoginPageStep loginPageStep = new LoginPageStep();
        loginPageStep.login(UserCreator.createEmptyUser());

        Assert.assertTrue(loginPageStep.checkLocation());
        Assert.assertEquals(loginPageStep.getCssValueFromPasswordInput(),"rgba(73, 80, 87, 1)");
    }
    @Test
    public void testLoginWithInvalidNameAndPassword() {
        LoginPageStep loginPageStep = new LoginPageStep();
        loginPageStep.login(UserCreator.createRandomUser());
        String actual = loginPageStep.getTextFromInvalidUserNameOrPasswordMessage();
        String expected = "Invalid username or password!";

        Assert.assertEquals(actual,expected);
    }
}
