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
public class GetInput {

    public GetInput() {
    }


    public HashMap<String, Object> getInput() {
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        String shape = "";
        int number = 0;
        HashMap<String, Object> data = new HashMap();
        System.out.println("\n\nEnter a shape"
                                +"\nC - Circle"
                                +"\nS - Square"
                                +"\nT - Triangle"
                                +"\nX - Exit");
        while (!shape.equals("C") && !shape.equals("S") && !shape.equals("T") && !shape.equals("X")) {
            
            try {
                shape = systemIn.readLine();
                shape = shape.trim().toUpperCase();
                if (shape.equals("X")) {
                    data.put("command", shape);
                    return data;
                }
                if (!shape.equals("C") && !shape.equals("S") && !shape.equals("T")) {
                    System.out.println("Error. Please enter C, S, T or X");
                } 
            } catch (Exception e) {
                System.out.println("Error. Please enter C, S, T or X");
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
        data.put("command", shape);
        data.put("length", number);
        return data;

    }
    
}
