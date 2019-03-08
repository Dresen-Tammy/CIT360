package store.control;

import store.model.DAOFile;
import store.model.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;

public class LoginHandler implements Handler {
    @Override
    public void handleIt(HashMap<String, Object> dataMap) {
        String userName = (String) dataMap.get("uname");
        String password = (String) dataMap.get("pword");
        DAOFile theModel = (DAOFile) dataMap.get("model");

        User foundUser = theModel.getUser(userName, password);
        HashMap<String, Object> responseMap = new HashMap<>();
        String sessionId = "";
        if (foundUser != null) {
            UUID sessionUUID = UUID.randomUUID();
            sessionId = sessionUUID.toString();
            foundUser.setSession(sessionId);
            theModel.updateUser(foundUser);
            responseMap.put("id", sessionId);
        }
        responseMap.put("id", sessionId);
        ObjectMapper mapper = new ObjectMapper();
        try {
            PrintWriter out = (PrintWriter) dataMap.get("toClient");
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
