package store.control;

import store.model.DAOFile;
//import store.model.StoreModel;
import store.model.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class LogoutHandler implements Handler {

    @Override
    public void handleIt(HashMap<String, Object> dataMap) {
        String sessionID = (String)dataMap.get("id");
        DAOFile theModel = (DAOFile) dataMap.get("model");
        User foundUser = theModel.getUserBySessionID(sessionID);
        if(foundUser != null) {
            foundUser.setSession("");
            theModel.updateUser(foundUser);
        }
        HashMap<String,Object> responseMap = new HashMap<>();
        responseMap.put("id", "");
        ObjectMapper mapper = new ObjectMapper();
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
