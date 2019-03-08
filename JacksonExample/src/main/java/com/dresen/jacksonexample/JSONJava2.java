package com.dresen.jacksonexample;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JSONJava2 {

    /**
     * JSON = JavaScript Object Notation
     *
     * @param args
     */
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        //create a new object called Facebook
        Facebook facebook = createObject();

        try {

            // an array in ordered sequence of values.
            System.out.println("Regular View");
            String regularView = mapper.writeValueAsString(facebook);
            System.out.println(regularView);

            //convert text into an object:
            String jsonInString = "{\"name\":\"Ryan Weston\",\"age\":41,\"status\":\"Student\",\"scholarship\":9250}";
            Facebook normalFacebook = mapper.readValue(jsonInString, Facebook.class);
            System.out.println(normalFacebook);

            // Display everything
            System.out.println("\nEverything View");
            String displayEverythingView = mapper.writeValueAsString(facebook);
            System.out.println(displayEverythingView);

            Facebook EverythingFacebook = mapper.readValue(jsonInString, Facebook.class);
            System.out.println(EverythingFacebook);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // insert objects or actual data into the application
    //send data as an object...
    // I need name, age, status, scholarship, and profile attributes, along with getters and setters.
    private static Facebook createObject() {

        Facebook facebook = new Facebook();

        facebook.setName("Ryan Weston");
        facebook.setAge(41);
        facebook.setStatus("Student");
        facebook.setScholarship(new BigDecimal("9250"));

        List<String> profile = new ArrayList<>();
        profile.add("Picture");

        facebook.setProfile(profile);

        return facebook;


    }
    public static class Facebook {
        private String name;
        private int age;
        private String status;
        private BigDecimal scholarship;
        private List<String> profile;

        public Facebook() {
        }

        public Facebook(String name, int age, String status, BigDecimal scholarship, List<String> profile) {
            this.name = name;
            this.age = age;
            this.status = status;
            this.scholarship = scholarship;
            this.profile = profile;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public BigDecimal getScholarship() {
            return scholarship;
        }

        public void setScholarship(BigDecimal scholarship) {
            this.scholarship = scholarship;
        }

        public List<String> getProfile() {
            return profile;
        }

        public void setProfile(List<String> profile) {
            this.profile = profile;
        }
    }
}
