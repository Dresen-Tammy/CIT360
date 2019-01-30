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
    private HashMap<String,Handler> handleMap = new HashMap<>();
    
    public void handleShape(String command, HashMap<String, Integer> data) {
        this.addHandlers();
        Handler handler = handleMap.get(command);
        if (handler != null) {
            handler.handleShape(data);
        }
    }

    private void addHandlers() {
        handleMap.put("C", new HandleCircle());
        handleMap.put("S", new HandleSquare());
        handleMap.put("T", new HandleTriangle());
        handleMap.put("choice", new HandleChoice());
        handleMap.put("Y", new HandleInput());
        handleMap.put("N", new HandleEnd());
    }
}
