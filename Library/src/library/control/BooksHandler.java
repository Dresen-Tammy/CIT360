package library.control;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import library.model.Book;
import library.model.LibraryDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class BooksHandler implements Handler {
    @Override
    public void runHandler(HashMap<String, Object> data) throws IOException {
// get info out of dataMap
        LibraryDAO theModel = (LibraryDAO) data.get("model");
        // create responseMap for response
        HashMap<String, Object> responseMap = new HashMap<>();
        ArrayList<Book> books = theModel.getAllBooks();
        ArrayList<String> jbooks = new ArrayList<>();
        ObjectMapper mapper = (ObjectMapper) data.get("mapper");
        responseMap.put("info", "books");
        responseMap.put("response", books);

        PrintWriter out = (PrintWriter) data.get("toClient");
        mapper.writeValue(out, responseMap);
    }
}
