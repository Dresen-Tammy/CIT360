package main.control;

import java.io.IOException;
import java.util.HashMap;

public class ApplicationController {
    private HashMap<String, Handler> handlerMap = new HashMap<>();

    public void handleRequest(String command, HashMap<String, Object> data) throws IOException {
        Handler aCommandHandler = handlerMap.get(command);
        if(aCommandHandler != null) {
            aCommandHandler.handleIt(data);
        }
    }

    public void mapCommand(String aCommand, Handler acHandler) {
        handlerMap.put(aCommand, acHandler);
    }
}
