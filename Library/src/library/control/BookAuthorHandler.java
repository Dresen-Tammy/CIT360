package library.control;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import library.model.Author;
import library.model.LibraryDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class BookAuthorHandler implements Handler {
    @Override
    public void handleIt(HashMap<String, Object> dataMap) throws IOException {
        // get model and mapper from dataMap
        LibraryDAO model = (LibraryDAO) dataMap.get("model");
        ObjectMapper mapper = (ObjectMapper) dataMap.get("mapper");

        // create response HashMap
        HashMap<String, Object> responseMap = new HashMap();
        // get list of authors from db
        ArrayList<Author> authors = model.getAllAuthors();
        // add to responseMap
        responseMap.put("authors", authors);
        // turn responseMap to Json and write to response
        PrintWriter out = (PrintWriter) dataMap.get("toClient");
        mapper.writeValue(out, responseMap);


    }
}
