package library.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import library.model.Book;
import library.model.LibraryDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
* Getting list of all books to populate MainActivity
* TODO figure out getting only part of the books for pagination
 */

public class BooksHandler implements Handler {
    @Override
    public void runHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LibraryDAO model = LibraryDAO.getInstance();
        // Request is Get Request
        ObjectMapper mapper = new ObjectMapper();

        // call getAllBooks method from model
        ArrayList<Book> booksList = model.getAllBooks();
        // serialize


            PrintWriter out = response.getWriter();
            String jsonList = mapper.writeValueAsString(booksList);
            // add to body
            out.print(jsonList);


    }

}
