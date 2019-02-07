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
public class HandleCircle implements Handler{

    public void handleCircle() {
    }

    @Override
    public void handleShape(HashMap<String, Object> info) {
        int length = (int) info.get("length");
        double circ = (double) length * 2 * Math.PI;
        
        System.out.printf("\nA circle with a radius of " 
                + info.get("length") 
                + "\nhas a cicumference of %.2f.", circ 
                );
        
        }
                
    }
    

