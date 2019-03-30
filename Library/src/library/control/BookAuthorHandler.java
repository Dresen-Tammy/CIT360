package library.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import library.model.Author;
import library.model.LibraryDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class BookAuthorHandler implements Handler {
    @Override
    public void runHandler(HttpServletRequest request, HttpServletResponse response) {

    }

}
