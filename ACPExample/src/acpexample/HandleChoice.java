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
public class HandleChoice implements Handler {

    public HandleChoice() {
    }

    @Override
    public void handleShape(HashMap<String, Integer> info) {
        
        Scanner systemIn = new Scanner(System.in);
        String answer = "";
        while (!answer.equals("Y") && !answer.equals("N")) {
            System.out.println("\n\nEnter another shape? Y/N");
            try {
            answer = systemIn.nextLine();
            answer = answer.trim().toUpperCase();
            } catch (Exception e) {
                System.out.println("Error. Enter Y/N");
            }    
        }
        ShapeHandler shapeHandler = new ShapeHandler();
        shapeHandler.handleShape(answer, info);
    }
    
}
