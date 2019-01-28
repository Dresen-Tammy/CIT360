/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.io.IOException;
import mvc.control.ShapeController;

/**
 *
 * @author Dresen_HP
 */
public class SquareView extends View{
    public SquareView() {
    
}
    public void display() {
        super.message = "\nEnter side length in inches:";
        
        Integer choice = getInputNumber();
        ShapeController.handleSquare(choice);
    }

    
    
}
