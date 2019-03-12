package library.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import library.model.LibraryDAO;
import library.model.Review;
import library.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class AddReviewHandler implements Handler {
    @Override
    public void handleIt(HashMap<String, Object> data) throws IOException {
        // get model from data
        LibraryDAO model = (LibraryDAO) data.get("model");
        // get mapper from data
        ObjectMapper mapper = (ObjectMapper) data.get("mapper");
        // get out from data
        PrintWriter out = (PrintWriter) data.get("toClient");
        // create responseMap
        HashMap<String, Object> responseMape = new HashMap<>();
        // get sessionId from data
        String sessionId = (String) data.get("id");
        // get user by sessionId
        User user = model.getUserBySessionID(sessionId);
        // if user not null
        if (user != null) {
            // get review from data through mapper
            String jsonReview = (String) data.get("review");
            Review newReview = mapper.readValue(jsonReview, Review.class);
            // add review to model
            //model.addReview(newReview);
            // add review to response map
            // add responseMap to out with mapper

        }
        // else
            // error message
            // add error message to mapper
        // add responseMap to out with mapper
    }
}
