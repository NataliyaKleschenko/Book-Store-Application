package api.spec;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.with;
public class BooksSpecification {
    public static RequestSpecification bookRequestSpec = with()
            .baseUri("https://demoqa.com/BookStore/v1")
            .basePath("/Books")
            .contentType(ContentType.JSON);
    public static ResponseSpecification bookResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
}
