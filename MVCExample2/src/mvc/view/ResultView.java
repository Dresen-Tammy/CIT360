/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.io.IOException;

/**
 *
 * @author Dresen_HP
 */
public class ResultView extends View {

    public void display(String name, Integer perimeter, Integer area) {
        super.message = "\n********************"
                 +"\n   "+ name
                 +"\n********************"
                +"\n\nPerimeter: " + perimeter + " in."
                +"\nArea: " + area + " in. sq."
                +"\n********************";
        console.println(message);
        String choice = getInput();
        mvc.control.ShapeController.anotherShape(choice);
    }
 
    @Override
    public String getInput() {
        String value = "";
        boolean valid = false;
        try {
            while (!valid) {
                super.message = "\n\nChoose another shape? Y/N";
                console.println(message);
                value = keyboard.readLine();
                value = value.trim().toUpperCase();
                if (value.equals("Y") || value.equals("N")) {
                    return value;
                } else {
                    
                }
            }
        } catch (IOException ex) {
            console.println("Error. Please enter valid choice");
        }
        return value;
    }
}
