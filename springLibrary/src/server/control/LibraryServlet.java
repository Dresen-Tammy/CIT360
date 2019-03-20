package server.control;
import library.model.LibraryDAO;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

@WebServlet(name = "LibraryServlet", urlPatterns = {"/LibraryServlet"})
public class LibraryServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // variables
        LibraryDAO libraryModel = null;
        String command, page;
        // create and initialize appController for ACP
        ApplicationController appController = new ApplicationController();
        initialize(appController);
        try {
            // get the libraryModel instance, which creates session factory
            libraryModel = LibraryDAO.getInstance();
            // get command from request to determine which handler to use
            command = request.getParameter("command");
            // use ACP to handle request, passing in the request and response so I can have access to them.
            appController.handleRequest(command, request, response, libraryModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        page = (String) request.getAttribute("page");
        request.getRequestDispatcher(page).forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
