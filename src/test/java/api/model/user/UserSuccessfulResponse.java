package api.model.user;
import api.model.book.BookResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor @NoArgsConstructor
public class UserSuccessfulResponse {
    private String userID;
    private String username;
    private ArrayList<BookResponse> books;
}
