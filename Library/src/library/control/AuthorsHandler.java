package library.control;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import library.model.LibraryDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class AuthorsHandler implements Handler {
    @Override
    public void runHandler(HashMap<String, Object> dataMap) throws IOException {
        // get info out of dataMap
        LibraryDAO theModel = (LibraryDAO) dataMap.get("model");
        // create responseMap for response
        HashMap<String, Object> responseMap = new HashMap<>();
        ArrayList authors = theModel.getAllAuthors();
        responseMap.put("response", authors);
        responseMap.put("info", "authors");
        ObjectMapper mapper = (ObjectMapper) dataMap.get("mapper");
        PrintWriter out = (PrintWriter) dataMap.get("toClient");
            mapper.writeValue(out, responseMap);
    }
}
