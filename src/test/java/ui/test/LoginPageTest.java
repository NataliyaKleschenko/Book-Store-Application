package ui.test;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.step.AuthorizedUserStep;
import ui.step.HomePageStep;
import ui.step.LoginPageStep;
import ui.util.DataProperties;
import ui.util.UserCreator;

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
        String expected = DataProperties.getDataProperties("userName");

        Assert.assertEquals(actual,expected);
    }
}
