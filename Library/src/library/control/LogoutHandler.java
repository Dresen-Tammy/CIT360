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

public class LogoutHandler implements Handler {

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

}
