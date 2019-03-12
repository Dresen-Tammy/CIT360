package library.control;

import library.model.LibraryDAO;
import library.model.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;

public class LoginHandler implements Handler {
    @Override
    public void handleIt(HashMap<String, Object> dataMap) throws IOException {
        String userName = (String) dataMap.get("uname");
        String password = (String) dataMap.get("pword");
        LibraryDAO model = (LibraryDAO) dataMap.get("model");

        User foundUser = model.getUser(userName, password);
        HashMap<String, Object> responseMap = new HashMap<>();
        String sessionId = "";
        if (foundUser != null) {
            UUID sessionUUID = UUID.randomUUID();
            sessionId = sessionUUID.toString();
            foundUser.setSession(sessionId);
            model.updateUser(foundUser);
            responseMap.put("id", sessionId);
        }
        responseMap.put("id", sessionId);
        ObjectMapper mapper = (ObjectMapper) dataMap.get("mapper");
        PrintWriter out = (PrintWriter) dataMap.get("toClient");
        mapper.writeValue(out, responseMap);

    }
}
