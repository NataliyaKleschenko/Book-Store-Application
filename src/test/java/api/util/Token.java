package api.util;
import api.model.token.TokenResponse;
import api.model.user.UserRequest;
import ui.entity.User;
import ui.util.UserCreator;

import static api.spec.TokenSpecification.tokenRequestSpec;
import static api.spec.TokenSpecification.tokenResponseSpec;
import static io.restassured.RestAssured.given;
public class Token {
    public static String getToken() {
        User user = UserCreator.createCorrectUser();
        String name = user.getUserName();
        String password = user.getPassword();
        UserRequest request = new UserRequest(name,password);
        TokenResponse response = given()
                .spec(tokenRequestSpec)
                .body(request)
                .when()
                .post()
                .then()
                .spec(tokenResponseSpec)
                .extract()
                .as(TokenResponse.class);
        return response.getToken();
    }
}

