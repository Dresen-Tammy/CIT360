package library.control;

import library.model.LibraryDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class ApplicationController {
    private HashMap<String, Handler> handlerMap = new HashMap<>();

    public void handleRequest(String command, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Handler aCommandHandler = handlerMap.get(command);
        if(aCommandHandler != null) {
            aCommandHandler.runHandler(request, response);
        }
    }

    public void mapCommand(String aCommand, Handler acHandler) {
        handlerMap.put(aCommand, acHandler);
    }

}
