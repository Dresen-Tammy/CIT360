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
public class HandleEnd implements Handler {

    public HandleEnd() {
    }

    @Override
    public void handleShape(HashMap<String, Object> info) {
        System.out.println("\nGoodbye");
    }
    
}
