/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcexample2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import mvc.view.InputView;

/**
 *
 * @author Dresen_HP
 */
public class MVCExample2 {
    private static PrintWriter outFile;
    private static BufferedReader inFile;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //open character stream files for end user iput and output
            MVCExample2.inFile = 
                    new BufferedReader(new InputStreamReader(System.in));
            
            MVCExample2.outFile = new PrintWriter(System.out, true);
            
            
        } catch (Exception e) {
                    System.out.println("Exception: " + e.toString() +
                                    "\nCause: " + e.getCause() +
                                    "\nMessage: " + e.getMessage());
        }
        
        InputView inputView = new InputView(); 
        inputView.display();
        
    }
    public static BufferedReader getInFile() {
        return inFile;
    }
    public static PrintWriter getOutFile() {
        return outFile;
    }
}
    
