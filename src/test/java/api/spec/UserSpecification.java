package api.spec;

import api.util.Token;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.with;

public class UserSpecification {
    public static RequestSpecification userRequestSpec = with()
            .baseUri("https://demoqa.com/Account/v1")
            .basePath("/User")
            .header("Accept","application/json")
            .header("Content-Type","application/json")
            .log().uri()
            .log().body();
    public static ResponseSpecification userResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
    public static ResponseSpecification userErrorResponseSpec400 = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
    public static ResponseSpecification userErrorResponseSpec406 = new ResponseSpecBuilder()
            .expectStatusCode(406)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
}
