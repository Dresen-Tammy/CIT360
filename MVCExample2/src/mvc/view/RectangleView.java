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
public class RectangleView extends View{

    public RectangleView() {
    
}
    public void display() {
        super.message = "\nEnter width in inches"; 
        Integer side1 = getInputNumber();
        super.message = "\nEnter length in inches";
        Integer side2 = getInputNumber();
        ShapeController.handleRectangle(side1, side2);
    }

    
}
