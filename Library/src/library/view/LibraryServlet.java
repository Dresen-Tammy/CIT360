package library.view;

import library.control.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "LibraryServlet", urlPatterns = {"/LibraryServlet"})
public class LibraryServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // variables
        String command = "", page, inputLine;
        StringBuffer buffer = null;
        BufferedReader in;
        HashMap<String, Object> info = null;
        ApplicationController appController = null;

        try {
            command = (String) request.getParameter("command");
            appController = new ApplicationController();
            initializePost(appController);
            appController.handleRequest(command, request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ExceptionInInitializerError, IOException {

        // variables

        String command, id;


        // instantiate and initialize appController
        ApplicationController appController = new ApplicationController();
        initializeGet(appController);


            // this gets singleton instance of LibraryDAO or starts a new factorySession and instantiates LibraryDAO if it doesn't exist.


            System.out.println("Servlet Created");

            // get command parameter from request to decide which handler to call
            command = request.getParameter("command");

            // call handler
            appController.handleRequest(command, request, response);

    }

    // initialize appController
    public void initializePost(ApplicationController appController) {
        System.out.print("Initializing");
        appController.mapCommand("register", new RegistrationHandler());
        appController.mapCommand("login", new LoginHandler());
        appController.mapCommand("logout", new LogoutHandler());
        appController.mapCommand("book", new AddBookHandler());
    }
    public void initializeGet(ApplicationController appController) {
        appController.mapCommand("authors", new AuthorsHandler());
        appController.mapCommand("books", new BooksHandler());
    }
}
