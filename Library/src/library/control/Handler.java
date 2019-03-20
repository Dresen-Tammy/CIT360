package library.control;

import library.model.LibraryDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Handler {
    public void runHandler(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
