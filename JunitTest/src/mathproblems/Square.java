/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathproblems;

/**
 *
 * @author Dresen_HP
 */
public class Square {
        int side;
    public Square(int x) {
        side = x;
    }
    
    public int getSide(){
        return side;
    }
            
    public void setSide(int x) {
        if (x > 0) {
        side = x;
        }
    }
    
    public int perimeter() {
        return 4 * side;
    }
    public int area() {
        return side * side;
    }
    public int cubeVolume() {
        return side * side * side;
    }
    public int cubeSurface() {
        return side * side * 6;
    }
}
