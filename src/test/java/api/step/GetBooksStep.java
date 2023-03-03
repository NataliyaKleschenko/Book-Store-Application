package api.step;
import api.model.book.BookResponse;
import java.util.List;
import java.util.stream.Collectors;
import static api.spec.BooksSpecification.bookRequestSpec;
import static api.spec.BooksSpecification.bookResponseSpec;
import static io.restassured.RestAssured.given;
public class GetBooksStep {
    public List<String> getListOfTitlesAPI() {
        List<BookResponse> books = given()
                .spec(bookRequestSpec)
                .when()
                .get()
                .then()
                .spec(bookResponseSpec)
                .extract()
                .body().jsonPath().getList("books", BookResponse.class);
        return books.stream()
                .map(BookResponse::getTitle)
                .collect(Collectors.toList());
    }
}
