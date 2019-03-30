package library.control;

import library.model.LibraryDAO;
import library.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;

public class RegistrationHandler implements Handler {
    @Override
    public void runHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User foundUser = null;
        PrintWriter out = null;
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> data = new HashMap<>();
        LibraryDAO model = LibraryDAO.getInstance();
        String uname = (String) request.getParameter("username");
        String pword = (String) request.getParameter("password");

        try {
            foundUser = model.getUser(uname);


            if (foundUser == null) {
                User user = new User();
                user.setUname(uname);
                user.setPword(pword);
                model.addUser(user);
                data.put("message", "success");
                user.setPword("");
                String jsonuser = mapper.writeValueAsString(user);
                data.put("user", jsonuser);
            } else {
                data.put("message", "retry");
            }


        } catch (Exception e) {
            e.printStackTrace();
            data.put("message", "error");
        } finally {
            out = response.getWriter();
            mapper.writeValue(out, data);
        }

    }



}
