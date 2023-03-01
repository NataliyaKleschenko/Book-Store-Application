package api.spec;

import api.model.token.TokenResponse;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class AuthorizationSpecification {
    static TokenResponse response = new TokenResponse();
    public static RequestSpecification authorizationRequestSpec = with()
            .baseUri("https://demoqa.com/Account/v1")
            .basePath("/Authorized")
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer " + response.getToken())
            .log().uri()
            .log().body();
    public static ResponseSpecification authorizationResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();

}
