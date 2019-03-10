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
    public void handleIt(HashMap<String, Object> dataMap) {
        String sessionID = (String)dataMap.get("id");
        LibraryDAO theModel = (LibraryDAO) dataMap.get("model");
        User foundUser = theModel.getUserBySessionID(sessionID);
        if(foundUser != null) {
            foundUser.setSession("");
            theModel.updateUser(foundUser);
        }
        HashMap<String,Object> responseMap = new HashMap<>();
        responseMap.put("id", "");
        ObjectMapper mapper = (ObjectMapper)dataMap.get("mapper");
        PrintWriter out = (PrintWriter) dataMap.get("toClient");
        try {
            mapper.writeValue(out, responseMap);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
