package main.control;

import java.io.IOException;
import java.util.HashMap;

public interface Handler {
    public void handleIt(HashMap<String, Object> data) throws IOException;
}
