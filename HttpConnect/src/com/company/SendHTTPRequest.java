package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SendHTTPRequest {
    public static void main(String[] args) {


        try {

            Runnable runnable = () -> {
                SendHTTPRequest.callMe("chicken");
            };
            Runnable runnable2 = () -> {
                SendHTTPRequest.callMe("cherry");
            };
            new Thread(runnable2).start();
            new Thread(runnable).start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static Runnable callMe(String searchQuery) {
        int responseCode = 0;
        try {
            // Happy/Nasty Path. Uncomment different line to show error
            //String url = "https://www.food2fork.com/api/search?key=ca9b3bf940c9d4bc3928057e439d6564" + "&q=" + searchQuery;
            //String url = "https://www.food2fork.com/api/search?key=ca9b3bf940c9d4bc3928057e439d6564XX" + "&q=" + searchQuery;
            String url = "https://www.food2foo.com/api/search?key=ca9b3bf940c9d4bc3928057e439d6564" + "&q=" + searchQuery;


            // create new URL object
            URL obj = new URL(url);


            // Obtain a URLConnection object from the URL
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // Configure the URLConnection
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");


            // Read the header fields
            //for (int i = 1; i <= 10; i++) {
            //   System.out.println(con.getHeaderFieldKey(i) + " = " + con.getHeaderField(i));
            //}


            // get the header response code
            responseCode = con.getResponseCode();
            if (responseCode == 200) {
                System.out.println("\n*** Searching for " + searchQuery + " recipes at Food2Fork.com API ***");
                System.out.println("Sending 'GET' request to URL : " + url);
                System.out.println("Response Code: " + responseCode);
                // create buffered reader to read in response
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                // input will be read one line at a time. While there are still more lines, add to the response.
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                // close the buffered reader
                in.close();
                // print out the response
                ArrayList<Recipe> recipeMap = deserializeArray(response.toString());
                System.out.println("\n*** Printing recipes for " + searchQuery + " ***");
                for (Recipe r : recipeMap) {
                    System.out.println("Recipe: " + r.getTitle() + " Publisher: " + r.getPublisher() + " URL: " + r.getSource_url());
                }
            } else {
                System.out.println("Error getting recipes.\nResponseCode: " + responseCode);

            }
            con.disconnect();
        } catch (Exception e) {

            System.out.println("Error getting recipes.\nResponseCode: " + responseCode);
            System.out.println(e);


        }


        return null;
    }

    public static ArrayList<Recipe> deserializeArray(String json) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Response response = mapper.readValue(json, Response.class);

        ArrayList<Recipe> recipeList = response.getRecipes();

        return recipeList;

    }
}
