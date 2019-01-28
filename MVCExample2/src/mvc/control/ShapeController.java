/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.control;

import mvc.model.Rectangle;
import mvc.model.Square;
import mvc.view.InputView;
import mvc.view.RectangleView;
import mvc.view.ResultView;
import mvc.view.SquareView;

/**
 *
 * @author Dresen_HP
 */
public class ShapeController {
    
    public static void shapeChoice(String choice) {
        if (choice.equals("S")) {
            mvc.view.SquareView squareView = new SquareView();
            squareView.display();
        } else if (choice.equals("R")) {
            mvc.view.RectangleView rectangleView = new RectangleView();
            rectangleView.display();
        }
        
    }

    public static void handleSquare(Integer choice) {
        Square square = new Square(choice);
        Integer perimeter = ShapeController.getSPerimeter(square);
        Integer area = ShapeController.getSArea(square);
        mvc.view.ResultView shapeView = new ResultView();
        shapeView.display("Square", perimeter, area);
    }
    
    public static void handleRectangle(Integer side1, Integer side2) {
        Rectangle rect = new Rectangle(side1, side2);
        Integer perimeter = ShapeController.getRPerimeter(rect);
        Integer area = ShapeController.getRArea(rect);
        mvc.view.ResultView shapeView = new ResultView();
        shapeView.display("Rectangle", perimeter, area);
    }

    private static Integer getSPerimeter(Square square) {
        return square.getSide() * 4;
        
    }

    private static Integer getSArea(Square square) {
       Integer side = square.getSide();
       return side * side;
    }
    
    private static Integer getRPerimeter(Rectangle rectangle) {
        return rectangle.getSide1() * 2 + rectangle.getSide2() * 2;
        
    }

    private static Integer getRArea(Rectangle rectangle) {
      
       return rectangle.getSide1() * rectangle.getSide2();
    }

    public static void anotherShape(String choice) {
        if (choice.equals("Y")) {
            InputView inputView = new InputView();
            inputView.display();
        } else {
            return;
        }
    }
}
