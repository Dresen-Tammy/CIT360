/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import mvcexample2.MVCExample2;

/**
 *
 * @author Dresen_HP
 */
public class View implements ViewInterface {
    protected String message;
    protected BufferedReader keyboard = MVCExample2.getInFile();
    protected PrintWriter console = MVCExample2.getOutFile();

    @Override
    public void display() {

        //String value = getInput();
    }

    @Override
    public String getInput() {
        String value = "";
        boolean valid = false;
        try {
            while (!valid) {
                console.println(message);
                value = keyboard.readLine().trim().toUpperCase();
                if (value.equals("S") || value.equals("R")) {
                    return value;
                }
            }
        } catch (IOException ex) {
            console.println("Error. Please enter valid choice");
        }
        return value;
    }
    
    @Override
    public Integer getInputNumber() {
        Integer value = 0;
        boolean valid = false;
        try {
            while (!valid) {
                console.println(message);
                value = Integer.parseInt(keyboard.readLine());
                if (value > 0) {
                    return value;
                }
            }
        } catch (IOException ex) {
            console.println("Error. Please enter valid choice");
        }
        return value;
    }
}
