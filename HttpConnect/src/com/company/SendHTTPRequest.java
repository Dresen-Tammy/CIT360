package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.company.Recipe;
import com.company.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;;


public class SendHTTPRequest {
    public static void main(String[] args) {
        try {
            SendHTTPRequest.callMe("chicken");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void callMe(String searchQuery) {
        int responseCode = 0;
        try {
            String url = "https://www.food2fork.com/api/search?key=ca9b3bf940c9d4bc3928057e439d6564" + "&q=" + searchQuery;
            // Nasty Path url. Uncomment to show error
            //String url = "https://www.food2fork.com/api/search?key=ca9b3bf940c9d4bc3928057e439d6564XX" + "&q=" + searchQuery;
            // create new URL object
            URL obj = new URL(url);
            // Obtain a URLConnection object from the URL
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // Configure the URLConnection
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");


            // Read the header fields
          /* for (int i = 1; i <= 10; i++) {
               System.out.println(con.getHeaderFieldKey(i) + " = " + con.getHeaderField(i));
           }
           con.disconnect();
            */
            // get the header response code
            responseCode = con.getResponseCode();
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
            for (Recipe r : recipeMap) {
                System.out.println("Recipe: " + r.getTitle() + " Publisher: " + r.getPublisher() + " URL: " + r.getSource_url());
            }

            con.disconnect();
        } catch (
                Exception e) {
            System.out.println("Error getting recipes.\nResponseCode: " + responseCode);
            System.out.println(e);
        }


    }

    public static ArrayList<Recipe> deserializeArray(String json) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Response response = mapper.readValue(json, Response.class);

        ArrayList<Recipe> recipeList = response.getRecipes();

        return recipeList;

    }
}
