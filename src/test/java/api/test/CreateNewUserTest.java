package api.test;

import api.model.token.TokenResponse;
import api.model.user.UserErrorResponse;
import api.model.user.UserSuccessfulResponse;
import api.step.CreateNewUserStep;
import api.step.GenerateTokenStep;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import static api.step.AuthorizationUserStep.authorizeUser;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateNewUserTest {
    String name = "Randomick";
    String password = "Second!123";
    @Test
    public void createNewUserTest() {
        UserSuccessfulResponse response = CreateNewUserStep.createNewUser(name,password);

        assertThat(response.getUsername()).isEqualTo(name);
    }
    @Test(dependsOnMethods = "createNewUserTest")
    public void createExistingUserTest() {
        UserErrorResponse response = CreateNewUserStep.createExistingUser(name,password);

        assertThat(response.getCode()).isEqualTo("1204");
        assertThat(response.getMessage()).isEqualTo("User exists!");
    }
    @Test
    public void createUserWithWeakPasswordTest() {
        String name = "dfsef";
        String password = " 1";
        UserErrorResponse response = CreateNewUserStep.createUserWithInvalidData(name,password);

         assertThat(response.getCode()).isEqualTo("1300");
         assertThat(response.getMessage()).isEqualTo("Passwords must have at least one non alphanumeric character, one digit ('0'-'9')," +
                 " one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.");
    }
    @Test
    public void createUserWithEmptyDataTest() {
        String name = "";
        String password = "";
        UserErrorResponse response = CreateNewUserStep.createUserWithInvalidData(name,password);

        assertThat(response.getCode()).isEqualTo("1200");
        assertThat(response.getMessage()).isEqualTo("UserName and Password required.");
    }
    @Test
    public void createTokenTest() {
        TokenResponse response = GenerateTokenStep.createTokenUser(name,password);

        assertThat(response.getStatus()).isEqualTo("Success");
        assertThat(response.getResult()).isEqualTo("User authorized successfully.");
    }
    @Test
    public void authorizeNewUserTest() {
        authorizeUser(name,password);


    }
    @AfterSuite
    public void deleteUser() {

    }
}