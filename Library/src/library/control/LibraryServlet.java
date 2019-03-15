package library.control;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import library.model.LibraryDAO;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "LibraryServlet", urlPatterns = {"/LibraryServlet"})
public class LibraryServlet extends HttpServlet {
    private ApplicationController appController = new ApplicationController();
    private LibraryDAO libraryModel = null;
    private ObjectMapper mapper = null;

    public void init() {
        System.out.print("Initializing");
        appController.mapCommand("register", new RegistrationHandler());
        appController.mapCommand( "login", new LoginHandler());
        appController.mapCommand("logout", new LogoutHandler());
        appController.mapCommand("authors", new AuthorsHandler());
        appController.mapCommand("genres", new GenresHandler());
        appController.mapCommand("books", new BooksHandler());
        appController.mapCommand("bookAuthor", new BookAuthorHandler());
        appController.mapCommand("bookGenre", new BookGenreHandler());
        appController.mapCommand("book", new AddBookHandler());
        appController.mapCommand("review", new AddReviewHandler());
        appController.mapCommand("editReview", new EditReviewHandler());
        appController.mapCommand("delete", new DeleteReviewHandler());
        appController.mapCommand("userReviews", new UserReviewsHandler());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Jackson object mapper to easily turn request Json into HashMap
            libraryModel = LibraryDAO.getInstance();
            mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            // get inputStream from request and use mapper to turn into HashMap
            HashMap<String, Object> dataMap = mapper.readValue(request.getInputStream(), HashMap.class);
            PrintWriter out = response.getWriter();
            dataMap.put("toClient", out);
            dataMap.put("mapper", mapper);
            dataMap.put("model", this.libraryModel);
            String command = (String) dataMap.get("command");
            appController.handleRequest(command, dataMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // this starts a new factorySession and instantiates one copy of LibraryDAO.
            libraryModel = LibraryDAO.getInstance();
            mapper = new ObjectMapper();
        System.out.println("Servlet Created");
        String command = request.getParameter("command");
        String uname = request.getParameter("uname");
        String pword = request.getParameter("pword");
        String word = request.getParameter("word");
        String search = request.getParameter("search");
        String id = request.getParameter("id");
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("uname", uname);
        dataMap.put("pword", pword);
        PrintWriter out = response.getWriter();
        dataMap.put("toClient", out);
        dataMap.put("model", this.libraryModel);
        dataMap.put("id", id);
        dataMap.put("mapper", mapper);
        System.out.print(dataMap);
        appController.handleRequest(command, dataMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
