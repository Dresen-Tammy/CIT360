package library.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import library.model.Book;
import library.model.LibraryDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class BookGenreHandler implements Handler {
    @Override
    public void runHandler(HttpServletRequest request, HttpServletResponse response) {

    }
    public void runHandler(HashMap<String, Object> data) throws IOException {
        // get model
        LibraryDAO model = (LibraryDAO)data.get("model");
        // create responseMap
        HashMap<String, Object> responseMap = new HashMap<>();
        // get genre from data
        Integer genre_id = (Integer) data.get("genre");
        // query database for book
        ArrayList<Book> books = model.getBooksByGenre(genre_id);
        // put book into response map
        responseMap.put("info", "books");
        responseMap.put("response", books);
        // get PrintWriter out file
        PrintWriter out = (PrintWriter) data.get("toClient");
        // get mapper
        ObjectMapper mapper = (ObjectMapper) data.get("mapper");
        // save responseMap to out using mapper

            mapper.writeValue(out, responseMap);

    }
}
