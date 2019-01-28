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
public class InputView extends View{

    
    public InputView() {
    
}
    public void display() {
        super.message = "\n***************"
                + "\n     Menu"
                + "\n***************"
                + "\nS - Square"
                + "\nR - Rectangle"
                + "\n\nEnter your choice";
        String choice = this.getInput();
        mvc.control.ShapeController.shapeChoice(choice);
    }

    
}
