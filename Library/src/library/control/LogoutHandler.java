package library.control;

import com.sun.deploy.net.HttpResponse;
import library.model.LibraryDAO;
//import library.model.StoreModel;
import library.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class LogoutHandler implements PostHandler {

    @Override
    public void runHandler(HttpServletRequest request, HttpServletResponse response) {

        Cookie loginCookie = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("user")) {
                    loginCookie = cookie;
                    break;
                }
            }
        }
        if (loginCookie != null) {
            loginCookie.setMaxAge(0);
            response.addCookie(loginCookie);
        }



    }
    public void runHandler(HashMap<String, Object> data) throws IOException {
        String sessionID = (String)data.get("id");
        LibraryDAO model = LibraryDAO.getInstance();
        User foundUser = model.getUserBySessionID(sessionID);
        HashMap<String,Object> responseMap = new HashMap<>();
        if(foundUser != null) {
            foundUser.setSession("");
            model.updateUser(foundUser);
        }

        responseMap.put("info", "id");
        responseMap.put("response", "");
        ObjectMapper mapper = (ObjectMapper)data.get("mapper");
        PrintWriter out = (PrintWriter) data.get("toClient");
            mapper.writeValue(out, responseMap);
    }
}
