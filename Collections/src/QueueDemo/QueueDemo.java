/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueDemo;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Dresen_HP
 */
public class QueueDemo 
{
    public static void main(String[] args)
    {
        Queue<String> queue = new LinkedList<>();
        String[] people = {"Ender", "Petra", "Bean", "Valentine", "Mazer"};
        for(String x : people)
        {
            queue.add(x);
        }
        System.out.println(queue);
        System.out.println("Next in line: " + queue.peek());
        String next = queue.poll();
        System.out.println("Being helped: " + next);
        System.out.println("Next in line: " + queue.peek());
        System.out.println(queue);
        while (!queue.isEmpty())
        {
            System.out.println(queue.poll());
        }
        
        
        
        
        
    }
}
