package library.control;

import library.model.LibraryDAO;
//import library.model.StoreModel;
import library.model.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class LogoutHandler implements Handler {

    @Override
    public void runHandler(HashMap<String, Object> data) throws IOException {
        String sessionID = (String)data.get("id");
        LibraryDAO theModel = (LibraryDAO) data.get("model");
        User foundUser = theModel.getUserBySessionID(sessionID);
        HashMap<String,Object> responseMap = new HashMap<>();
        if(foundUser != null) {
            foundUser.setSession("");
            theModel.updateUser(foundUser);
        }

        responseMap.put("info", "id");
        responseMap.put("response", "");
        ObjectMapper mapper = (ObjectMapper)data.get("mapper");
        PrintWriter out = (PrintWriter) data.get("toClient");
            mapper.writeValue(out, responseMap);
    }
}
