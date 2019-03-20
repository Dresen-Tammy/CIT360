package library.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import library.model.Book;
import library.model.LibraryDAO;
import library.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class AddBookHandler implements PostHandler {

    public void runHandler(HashMap<String, Object> data) throws IOException {
        // uuid from data
        String sessionId = (String) data.get("id");
        // get model from data
        LibraryDAO model = (LibraryDAO) data.get("model");
        ObjectMapper mapper = (ObjectMapper) data.get("mapper");
        // get out from data
        PrintWriter out = (PrintWriter) data.get("toClient");
        // create response map
        HashMap<String, Object> responseMap = new HashMap<>();
        Book book = null;
        // **** get user by uuid
        User foundUser = model.getUserBySessionID(sessionId);
        // if foundUser != null
        if (foundUser != null) {
            // get book from data and parse with mapper
            String jsonBook = (String) data.get("book");
            book = mapper.readValue(jsonBook, Book.class);
            // **** add book to database
            model.addObject(book);
            // put book into responseMap
            responseMap.put("info", "book");
            responseMap.put("response", book);
        } else {
            // if user not logged in, add error message to responseMap
            responseMap.put("info", "error");
            String error = "Please login to add book.";
            responseMap.put("response", error);
        }
        // use mapper to put responseMap into out.
        mapper.writeValue(out, responseMap);
    }

    @Override
    public void runHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LibraryDAO model = LibraryDAO.getInstance();
    }

}

