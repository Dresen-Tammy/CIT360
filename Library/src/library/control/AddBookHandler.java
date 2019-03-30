package library.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import library.model.Author;
import library.model.Book;
import library.model.LibraryDAO;
import library.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class AddBookHandler implements Handler {



    @Override
    public void runHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LibraryDAO model = LibraryDAO.getInstance();
        // get parameters from request
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String authorFirst = request.getParameter("authorFirst");
        String authorLast = request.getParameter("authorLast");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        Object result = null;
        // check if book is in db
        try {
            result = model.getBooksByTitleAuthor(title, authorLast);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // if not check if author is in db
        if (result == null) {
            Author foundAuthor = model.getAuthor(authorFirst, authorLast);
            if (foundAuthor == null) {
                foundAuthor = new Author();
                foundAuthor.setFirstName(authorFirst);
                foundAuthor.setLastName(authorLast);
                model.addAuthor(foundAuthor);
            }
            Book newBook = new Book();
            newBook.setTitle(title);
            newBook.setDescription(description);

            model.addBook(newBook, foundAuthor);
            mapper.writeValue(out, newBook);
        }

    }

}

