/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayListDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Dresen_HP
 */
public class ArrayListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // create new list of strings
        List<String> students = new ArrayList<>();
        // add() adds to end of list
        students.add("Billy");
        students.add("Josh");
        students.add("Gary");
        
        List<String> girls = new ArrayList<>();
        girls.add("Jill");
        // add(index, object) adds to index
        girls.add(1, "Becky");
        // add(index, object) pushes rest list up one index.
        // duplicates allowed
        girls.add(1, "Jill");
        // addAll() a collection
        students.addAll(girls);
        System.out.println(students);
        // set() sets to index, and replaces and returns previous value.
        students.set(2, "Troy");
        // sublist(index, index) makes sublist including first index, but not last index
        List<String> boys = students.subList(0, 3);
        // size() returns number of elements in list
        System.out.println(boys + "There are " + boys.size() + " boys.");
        // contains() returns boolean if object is in list
        System.out.println("Susan is in the class: " + students.contains("Susan"));
        // containsAll() returns boolean if contains whole collection
        System.out.println("Are all the girls still in the class? " + students.containsAll(girls));
        // remove() removes and returns object at index.
        String removed = students.remove(2);
        System.out.println(removed + " was removed from class. " + students);
        // get() returns object at index but doesn't remove it
        String gotten = students.get(3);
        System.out.println(gotten + " was not removed from class. " + students);
        // forEach() iterates through list
        System.out.println("Students:");
        students.forEach(x -> System.out.println(x));
        // Iterator iterates through list
        Iterator<String> girlsIterator = girls.iterator();
        System.out.println("Girls:" );
        while(girlsIterator.hasNext()) 
        {
            System.out.println(girlsIterator.next());
        }
        // clear() removes all items from list
        girls.clear();
        System.out.println(girls.size());


        
        
        
    }
    
}
