package main.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import library.model.LibraryDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class GenresHandler implements Handler {
    @Override
    public void handleIt(HashMap<String, Object> data) throws IOException {
// get info out of dataMap
        LibraryDAO theModel = (LibraryDAO) data.get("model");
        // create responseMap for response
        HashMap<String, Object> responseMap = new HashMap<>();
        ArrayList genres = theModel.getAllGenres();
        responseMap.put("genres", genres);
        ObjectMapper mapper = (ObjectMapper) data.get("mapper");
        PrintWriter out = (PrintWriter) data.get("toClient");
        mapper.writeValue(out, responseMap);
    }
}
