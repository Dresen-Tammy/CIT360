package library.control;

import com.sun.deploy.net.HttpResponse;
import library.model.LibraryDAO;
import library.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;

public class LoginHandler implements PostHandler {
    @Override
    public void runHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // get parameters from string
        LibraryDAO model = LibraryDAO.getInstance();
        String userName = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        // check if user in db
        User foundUser = model.getUser(userName, password);
        // if user found, start session, return success message
        if (foundUser != null) {
            // get session gets session, and if there isn't one, gets and returns new session
            HttpSession session = request.getSession();
            session.setAttribute("user", foundUser.getUname());
            session.setMaxInactiveInterval(30*60);
            Cookie name = new Cookie("user", foundUser.getUname());
            name.setMaxAge(30*60);
            response.addCookie(name);
            PrintWriter out = response.getWriter();
        }
        // else return error message


    }




    public void runHandler(HashMap<String, Object> dataMap) throws IOException {
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
            responseMap.put("info", sessionId);
        }
        responseMap.put("response", sessionId);
        responseMap.put("info","id");
        ObjectMapper mapper = (ObjectMapper) dataMap.get("mapper");
        PrintWriter out = (PrintWriter) dataMap.get("toClient");
        mapper.writeValue(out, responseMap);

    }
}
