package library.control;

import java.io.IOException;
import java.util.HashMap;

public interface Handler {
    public void runHandler(HashMap<String, Object> data) throws IOException;
}
