package library.control;

import com.sun.deploy.net.HttpResponse;
import library.model.LibraryDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GenresHandler implements Handler {
/*@Override
    public void runHandler(HashMap<String, Object> data) throws IOException {
// get info out of dataMap
        LibraryDAO theModel = (LibraryDAO) data.get("model");
        // create responseMap for response
        HashMap<String, Object> responseMap = new HashMap<>();
        ArrayList genres = theModel.getAllGenres();
        responseMap.put("info", "genres");
        responseMap.put("response", genres);
        ObjectMapper mapper = (ObjectMapper) data.get("mapper");
        PrintWriter out = (PrintWriter) data.get("toClient");
        mapper.writeValue(out, responseMap);
    }*/

    @Override
    public void runHandler(HttpServletRequest request, HttpServletResponse response) {

    }
}
