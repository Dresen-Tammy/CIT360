package library.control;

import com.sun.deploy.net.HttpResponse;
import library.model.LibraryDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class DeleteReviewHandler implements Handler {
    @Override
    public void runHandler(HttpServletRequest request, HttpServletResponse response) {

    }
    public void runHandler(HashMap<String, Object> data) throws IOException {
        //TODO: Write delete Review handler

    }
}
