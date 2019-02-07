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
public class HandleTriangle implements Handler {

    public HandleTriangle() {
    }

    @Override
    public void handleShape(HashMap<String, Object> info) {
        Integer perimeter = (Integer) info.get("length") * 3;
        System.out.println("\nA regular triangle with a side length of " 
                + info.get("length") 
                + "\nhas a perimeter of " + perimeter + "."
                );

        //shapeHandler.handleShape("choice", info);
    }

    
    
}
