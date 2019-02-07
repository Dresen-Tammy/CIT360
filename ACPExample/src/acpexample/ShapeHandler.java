/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acpexample;

import java.util.HashMap;

/**
 *
 * @author Dresen_HP
 */
public class ShapeHandler {
    private HashMap<String,Handler> handlerMap = new HashMap<>();
    
    public void handleShape(HashMap<String, Object> data) {

        Handler handler = handlerMap.get(data.get("command"));
        if (handler != null) {
            handler.handleShape(data);
        }
    }
    public void addHandler(String request, Handler handler) {
        handlerMap.put(request, handler);
    }
}
