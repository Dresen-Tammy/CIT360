/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acpexample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Dresen_HP
 */
public class HandleInput implements Handler {

    public HandleInput() {
    }

    @Override
    public void handleShape(HashMap<String, Integer> data) {
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        String shape = "";
        int number = 0;
        System.out.println("\nEnter a shape"
                                +"\nC - Circle"
                                +"\nS - Square"
                                +"\nT - Triangle");
        while (!shape.equals("C") && !shape.equals("S") && !shape.equals("T")) {
            
            try {
                shape = systemIn.readLine();
                shape = shape.trim().toUpperCase();
                if (!shape.equals("C") && !shape.equals("S") && !shape.equals("T")) {
                    System.out.println("Error. Please enter C, S. or T");
                }
            } catch (Exception e) {
                System.out.println("Error. Please enter C, S, or T");
            }
        }
        System.out.println("Enter a number");
        while (number <= 0) {
            try {
                number = Integer.parseInt(systemIn.readLine());
                if (number <= 0) {
                    System.out.println("Error. please enter a positive whole number.");
                }
            }
            catch (Exception e) {
                System.out.println("Error. Please enter positive whole number.");
            }
                
        }
        HashMap<String, Integer> info = new HashMap<>();
        info.put("length", number);
        ShapeHandler shapeHandler = new ShapeHandler();
        shapeHandler.handleShape(shape, info);

    }
    
}
