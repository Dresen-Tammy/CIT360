package library.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import library.model.LibraryDAO;

import java.util.ArrayList;
import java.util.HashMap;

public class AuthorsHandler implements Handler {
    @Override
    public void handleIt(HashMap<String, Object> dataMap) {
        // get info out of dataMap
        LibraryDAO theModel = (LibraryDAO) dataMap.get("model");
        // create responseMap for response
        HashMap<String, Object> responseMap = new HashMap<>();
        ArrayList authors = theModel.getAllAuthors();
        ObjectMapper mapper = new ObjectMapper();

    }
}
