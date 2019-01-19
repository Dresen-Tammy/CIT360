/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeSetDemo;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Dresen_HP
 */
public class TreeSetDemo {
    public static void main(String[] args)
    {
        
   
    Set<Integer> numberSet = new TreeSet<>();
    Integer[] numbers = {426, 23, 8932, 425, 643, 500};
    for(Integer x : numbers)
    {
        numberSet.add(x);
    }
    // duplicates not allowed.
    numberSet.add(425);
    // numbers ordered by value, ascending
    System.out.println(numberSet);
    // null values throw exception
    try 
    {
        numberSet.add(null);
    }
    catch (NullPointerException e)
    {
        System.out.println(e);
    }
    // removeIf removes items that meet condition
    numberSet.removeIf(x -> x < 500);
    System.out.println(numberSet);
    
    }
}
