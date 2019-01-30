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
public class HandleSquare implements Handler {

    public HandleSquare() {
    }

    @Override
    public void handleShape(HashMap<String, Integer> info) {
        Integer perimeter = info.get("length") * 4;
        System.out.println("\nA square with a side length of " 
                + info.get("length") 
                + "\nhas a perimeter of " + perimeter + "."
                );
        ShapeHandler shapeHandler = new ShapeHandler();
        shapeHandler.handleShape("choice", info);
        
    }
    
}
