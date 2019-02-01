/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.jacksonexample;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dresen_HP
 */
public class Dog {
    
    private String name;
    private Integer age;
    private List<String> tricks = new ArrayList<>();
    private Boolean adopted;

    public Dog() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getTricks() {
        return tricks;
    }

    public void setTricks(List<String> tricks) {
        this.tricks = tricks;
    }

    public Boolean getAdopted() {
        return adopted;
    }

    public void setAdopted(Boolean adopted) {
        this.adopted = adopted;
    }
    
    @Override
    public String toString() {
        return "Dog{" + "name=" + name + ", age=" + age + ", tricks=" + tricks + ", adopted=" + adopted + '}';
    }
}