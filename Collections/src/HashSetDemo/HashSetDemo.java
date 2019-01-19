/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashSetDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Dresen_HP
 */
public class HashSetDemo {
      public static void main(String[] args) {
        Set<String> books = new HashSet<>();
        // add() adds the value not in any order.
        books.add("Call of the Wild");
        books.add("To Kill a Mockingbird");
        books.add("The Chemist");
        // Duplicates not allowed
        books.add("The Chemist");
        // set is not ordered
        System.out.println(books);
        
        List<String> tomes = new ArrayList<>();
        tomes.add("The Chemist");
        tomes.add("To Kill a Mockingbird");
        tomes.add("Call of the Wild");
        tomes.add("The Chemist");
        System.out.println(tomes);
        
        // to remove duplicates, change to HashSet
        Collection<String> noDupTomes = new HashSet<String>(tomes);
        System.out.println(noDupTomes);
        
        // equal if same contents. Order doesn't matter.
        System.out.println(("Are books and noDupeTomes equal? " + books.equals(noDupTomes)));
        

        String bookName = "Host";
        // contains() returns boolean of whether set contains the value
        System.out.println("Is "+ bookName + " in books? " + books.contains(bookName));
        
        tomes.add("Ender's Game");
        // containsAll() returns boolean if invoking collection contains all the elements passed in.
        System.out.println(books.containsAll(tomes));
        // addAll() only adds items that aren't already in collection.
        books.addAll(tomes);
        for(String x : books)
        {
            System.out.println(x);
        }
        
        
                
       
    }
}
