/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMapDemo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dresen_HP
 */
public class HashMapDemo {
    public static void main(String[] args)
    {
        Map members = new HashMap();
        // put instead of set to add objects
        // not ordered by insertion
        members.put("Tom", "801-225-4123");
        members.put("Jerry", "208-354-2122");
        members.put("Quacker", "949-295-4321");
        // duplicate keys not allowed and new value replaces old.
        members.put("Quacker", "801-360-5432");
        // duplicate values are allowed
        members.put("Butch", "801-360-5432");
        
        // get returns value
        System.out.println("Tom: " + members.get("Tom"));
        // keyset returns set of keys
        System.out.println(members.keySet());
        // entrySet returns set of key/value pairs
        System.out.println(members.entrySet());
        // containsKey returns boolean of whether key is in map
        System.out.println(members.containsKey("Quacker"));
        // returns null if not in map
        System.out.println(members.get("Toodles"));
        for (Object key : members.keySet())
        {
            System.out.println(key + " = " + members.get(key));
        }
    }
}
