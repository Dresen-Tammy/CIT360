/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.jacksonexample;

import java.util.ArrayList;
import java.util.List;
// create maven project.
// add jackson dependency to pom file, compile
// import jackson
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author Dresen_HP
 */
public class JacksonExample {
    public static void main(String[] args) {
        
    /* ********* Set Up Dog Objects and Json String **********/
        // create dog object
        Dog fido = new Dog();
        fido.setName("Fido");
        fido.setAge(3);
        List<String> tricks = new ArrayList<>();
        tricks.add("sit");
        tricks.add("stay");
        fido.setTricks(tricks);
        fido.setAdopted(true);
        System.out.println("\nFido dog object: " + fido);
        
        // create new dog object
        Dog fluffy = new Dog();
        fluffy.setName("Fluffy");
        fluffy.setAge(14);
        tricks.clear();
        tricks.add("leave it");
        tricks.add("fetch");
        fluffy.setTricks(tricks);
        fluffy.setAdopted(Boolean.TRUE);
        System.out.println("\nFluffy dog object: " + fluffy);
        
        // create dog jsonString
        String jsonString = "{\"name\":\"Spike\",\"age\":7,\"tricks\":[\"roll over\",\"play dead\"],\"adopted\":false}"; 
        System.out.println("\nSpike Json String: " + jsonString);
        Dog spike = null;
        
        // create new pack object and add dogs
        Pack tammysPack = new Pack();
        tammysPack.addDog(fluffy);
        tammysPack.addDog(fido);
        
    /* ****** Use Jackson to serialize and deserialize dog and pack objects *******/
        
        // Create mapper, this is reusable.
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Deserialize json string to dog object and add to pack.
            spike = mapper.readValue(jsonString, Dog.class);
            System.out.println("\nSpike dog object: " + spike);
            tammysPack.addDog(spike);
            
            
            // Serialize dog object to json string
            jsonString = mapper.writeValueAsString(fido);
            System.out.println("\nFido json string:" + jsonString);
        
            // Serialize pack object to json string
            // write pack to json string
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tammysPack);
            System.out.println("\ntammys pack as json string:\n" + jsonString);
        
        }
        catch (JsonParseException e) {e.printStackTrace();}
        catch (JsonMappingException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        

    /* ****** Use Jackson to serialize/save to file and read from file/deserialize objects *******/
        
        
        try {
            // change dog object to json string and save to file
            mapper.writeValue(new File("dog.json"), fido);

            // read json string from file and change to dog object
            Dog newFido = mapper.readValue(new File("dog.json"), Dog.class);
            System.out.println("\nObjects created from Json files:");
            System.out.println("\nnewFido dog created from dog.json file: " + newFido);

            // change pack object to json string and save to file
            mapper.writeValue(new File("pack.json"), tammysPack);

            // read json string from file and change to pack object
            Pack newTammysPack = mapper.readValue(new File("pack.json"), Pack.class);
            System.out.println("\nnewTammysPack hashmap created from pack.json file");
            for (String dog : newTammysPack.getPack().keySet()) {
                System.out.println(dog + ": " + newTammysPack.getDog(dog));
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace(); 
        } catch (IOException e) {
            e.printStackTrace();
        }

    /* ****** Option of moving Json methods into separate class and methods *******/    
        /*
        //create new instance of this class
        //JacksonExample tester = new JacksonExample();

            try {
            // Change dog to jsonString and write to file
            
            //tester.writeJSON(fluffy);
            // write pack to file
            tester.writePackJSON(tammysPack);

            // read dog.json file

            Dog newDog = tester.readJSON();
            System.out.println(newDog);

            // read pack.json file
            Pack newPack = tester.readPackJSON();
            System.out.println("\nPack:");
            for(String dog : newPack.getPack().keySet()) {
                System.out.println("\n" + newPack.getDog(dog)); 
        }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
       */ 
    }
    // can move all json methods into their own class
   /* private void writeJSON(Dog dog) 
            throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("dog.json"), dog);
    }
    private Dog readJSON() 
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Dog dog = mapper.readValue(new File("dog.json"), Dog.class);
        return dog;
    }
    private void writePackJSON(Pack pack)
            throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("pack.json"), pack);
    }
    private Pack readPackJSON()
            throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Pack pack = mapper.readValue(new File("pack.json"), Pack.class);
        return pack;
    }*/
            
}
