package api.step;

import api.model.user.UserErrorResponse;
import api.model.user.UserRequest;
import api.model.user.UserSuccessfulResponse;

import static api.spec.UserSpecification.*;
import static io.restassured.RestAssured.given;

public class CreateNewUserStep {
    public static UserSuccessfulResponse createNewUser(String name, String password) {
        UserRequest request = new UserRequest();
        request.setUserName(name);
        request.setPassword(password);

        return createNewUser(request);
    }
    public static UserSuccessfulResponse createNewUser(UserRequest request) {
        return given()
                .spec(userRequestSpec)
                .body(request)
                .when()
                .post()
                .then()
                .spec(userResponseSpec)
                .extract()
                .as(UserSuccessfulResponse.class);
    }
    public static UserErrorResponse createUserWithInvalidData(String name,String password){
        UserRequest request = new UserRequest();
        request.setUserName(name);
        request.setPassword(password);
        return given()
                .spec(userRequestSpec)
                .body(request)
                .when()
                .post()
                .then()
                .spec(userErrorResponseSpec400)
                .extract()
                .as(UserErrorResponse.class);
    }
    public static UserErrorResponse createExistingUser(String name,String password){
        UserRequest request = new UserRequest();
        request.setUserName(name);
        request.setPassword(password);
        return given()
                .spec(userRequestSpec)
                .body(request)
                .when()
                .post()
                .then()
                .spec(userErrorResponseSpec406)
                .extract()
                .as(UserErrorResponse.class);
    }
}
