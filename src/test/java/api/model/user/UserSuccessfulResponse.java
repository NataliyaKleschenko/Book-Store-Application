package api.model.user;

import api.model.book.BookResponse;
import lombok.Data;

import java.util.ArrayList;
@Data
public class UserSuccessfulResponse {
    private String userID;
    private String username;
    private ArrayList<BookResponse> books;
}
