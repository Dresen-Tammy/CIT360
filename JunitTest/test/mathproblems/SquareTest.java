/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathproblems;

import java.util.HashMap;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dresen_HP
 */
public class SquareTest {
    Square square1;
    Square square2;
    Square nullSquare;
    Square square4;
    Square squareNeg;

    HashMap<String, Square> squares;
    
    public SquareTest() {
    }
    
    @Before
    public void setUp() {
         square1 = new Square(4);
         square2 = new Square(5);
         nullSquare = null;
         square4 = square1;
         
         
    }
    
    @After
    public void tearDown() {
    }
    //XassertArrayEquals, XassertEquals, XassertFalse, 
    //XassertNotNull, assertNotSame, XassertNull, XassertSame, XassertThat, XassertTrue

    @Test
    public void setSide() {
        square1.setSide(-4);
        int expected = -4;
        assertFalse(square1.getSide() == expected);
       // AssertNotNull
       assertNotNull(square4);
       assertNull(nullSquare);
    }
    @Test
    public void getSide() {
        // test assertArrayEquals
        int[] sides1 = {square1.getSide(), square2.getSide()};
        int[] sides2 = {square4.getSide(), square2.getSide()};

        assertArrayEquals(sides1, sides2);
    }
    
    @Test
    public void perimeter(){
        // assertNull
        assertNull(nullSquare);
        int expected = 20;
        // assertThat
        assertThat(square2.perimeter(), is(expected));
        
    }
    @Test
    public void area(){
        // assertEquals
        assertEquals(square2.area(), 25);
    }
    @Test
    public void cubeVolume(){
        // assertFalse
        assertFalse(square1.cubeVolume() == square2.cubeVolume());
        assertTrue(square1.cubeVolume() == square4.cubeVolume());
        // assertTrue
    }
    @Test
    public void cubeSurface(){
        // assert not same
        assertNotSame(square1, square2);
        // assert same
        assertSame(square1, square4);
        int expected = 96;
        assertEquals(square1.cubeSurface(), expected);
    }
    
}
//assertArrayEquals, assertEquals, assertFalse, 
//assertNotNull, assertNotSame, assertNull, assertSame, assertThat, assertTrue