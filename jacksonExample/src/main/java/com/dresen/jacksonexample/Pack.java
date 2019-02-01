/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.jacksonexample;

import java.util.HashMap;

/**
 *
 * @author Dresen_HP
 */
public class Pack {
    protected HashMap<String,Dog> pack;

    public Pack() {
        pack = new HashMap<>();
    }

    public HashMap<String, Dog> getPack() {
        return pack;
    }

    public void setPack(HashMap<String, Dog> pack) {
        this.pack = pack;
    }
    
    public void addDog(Dog dog) {
        if (dog != null && dog.getName() != null && dog.getAge() != null) {
            String key = dog.getName();
            pack.put(key, dog);
        }
    }
    public Dog getDog(String dogName) {
        return pack.get(dogName);
    }
    
}
