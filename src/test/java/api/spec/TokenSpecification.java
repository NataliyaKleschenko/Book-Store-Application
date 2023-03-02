package api.spec;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.with;
public class TokenSpecification {
    public static RequestSpecification tokenRequestSpec = with()
            .baseUri("https://demoqa.com/Account/v1")
            .basePath("/GenerateToken")
            .header("Accept","application/json")
            .header("Content-Type","application/json")
            .log().uri()
            .log().body();
    public static ResponseSpecification tokenResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
    public static ResponseSpecification tokenErrorResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
}
