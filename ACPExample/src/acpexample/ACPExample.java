/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acpexample;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Dresen_HP
 */
public class ACPExample {
    public static ShapeHandler shapeHandler = new ShapeHandler();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // instantiate and initialize Shape Handler with handlerMap

        shapeHandler.addHandler("C", new HandleCircle());
        shapeHandler.addHandler("S", new HandleSquare());
        shapeHandler.addHandler("T", new HandleTriangle());
        shapeHandler.addHandler("X", new HandleEnd());

        
        // get input from user
        HashMap<String, Object> data = new HashMap();
        data.put("command", "");
        
        while (!data.get("command").toString().equals("X")) {
            GetInput getInput = new GetInput();
            data = getInput.getInput();
            shapeHandler.handleShape(data);
        }
        
    }

   
        

    
}
