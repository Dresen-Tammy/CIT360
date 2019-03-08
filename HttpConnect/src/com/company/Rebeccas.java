package com.company;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.lang.annotation.Documented;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Rebeccas {

    public static void main(String args[]) throws Exception { //throw an exception for unavailable webpage
        //create object and store data needed to access a web page
        URL websitePage = new URL("https://www.motability.co.uk/cars-scooters-and-powerchairs/types-of-cars/by-makes-and-models");

        //build connection with a variable called bLakeConnection allowing
        //communication with web page by opening the connection
        HttpURLConnection bLakeConnection = (HttpURLConnection) websitePage.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(bLakeConnection.getInputStream()));
        // input will be read one line at a time. While there are still more lines, add to the response.
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        Document doc = Jsoup.parse(response.toString());
        ArrayList<Element> rows = doc.select("td");
        //read in code from the HTTP URL connection object as it goes into the buffer using the created connection
        /*BufferedReader bringInfoIn = new BufferedReader(new InputStreamReader(bLakeConnection.getInputStream()));

        //print out the values. Create string variable.
        String bLakeKOACode; //needed to read the code from the buffer and print it

        while ((bLakeKOACode = bringInfoIn.readLine()) != null) {         //run this string as long as there is code

            if (bLakeKOACode.isEmpty() != true) {
                System.out.println(bLakeKOACode);
            } else {
                System.out.println("Nothing available to print.");
            }

            //Printing will allow us to see the HTML code but will not print external style and coding sheets
        }
        //close session after finished
        bringInfoIn.close(); //close what was opened

    }*/
    }
}
