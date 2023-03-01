package api.step;

import api.model.book.BookResponse;
import api.model.token.TokenResponse;
import api.model.user.UserRequest;
import api.model.user.UserSuccessfulResponse;

import static api.spec.BooksSpecifications.bookRequestSpec;
import static api.spec.BooksSpecifications.bookResponseSpec;
import static api.spec.TokenSpecification.tokenRequestSpec;
import static api.spec.TokenSpecification.tokenResponseSpec;
import static io.restassured.RestAssured.given;

public class GenerateTokenStep {
    public static TokenResponse createTokenUser(String name, String password) {
        UserRequest request = new UserRequest();
        request.setUserName(name);
        request.setPassword(password);

        return createTokenUser(request);
    }
    public static TokenResponse createTokenUser(UserRequest request) {
        return given()
                .spec(tokenRequestSpec)
                .body(request)
                .when()
                .post()
                .then()
                .spec(tokenResponseSpec)
                .extract()
                .as(TokenResponse.class);
    }
}
