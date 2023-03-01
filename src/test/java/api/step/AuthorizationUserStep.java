package api.step;
import api.model.user.UserRequest;
import static api.spec.AuthorizationSpecification.authorizationRequestSpec;
import static io.restassured.RestAssured.given;
public class AuthorizationUserStep {
    public static void authorizeUser(String name, String password) {
        UserRequest request = new UserRequest();
        request.setUserName(name);
        request.setPassword(password);
    }
    public static void authorizeUser(UserRequest request) {
         given()
                .spec(authorizationRequestSpec)
                .body(request)
                .when()
                .post()
                .then()
                .statusCode(200);
    }
}
