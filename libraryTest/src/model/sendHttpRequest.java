package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.*;


public class sendHttpRequest {
    public static void main(String[] args) throws IOException {
        // create executor
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // create user
        User tammy = new User();
        tammy.setUname("tammy");
        tammy.setPword("password");
        // create hashmap with login data
        HashMap<String, Object> loginData = new HashMap<>();
        loginData.put("command", "login");
        loginData.put("uname", tammy.getUname());
        loginData.put("pword", tammy.getPword());
        String loginJson = "";


        // send url call with future

        Future<HashMap> jsonResponse = executor.submit(new URLCallable(loginData));

        // get response from future
        HashMap<String, Object> response = null;
        try {
            response = jsonResponse.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        tammy.setSession((String) response.get("id"));

        // get books
        HashMap<String, Object> getBooks = new HashMap<>();
        getBooks.put("command", "books");

        Future<HashMap> getBooksResponse = executor.submit(new URLCallable(getBooks));

        HashMap bookResponse = null;
        try {
            bookResponse = getBooksResponse.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(bookResponse);
        ArrayList<String> books = (ArrayList<String>) bookResponse.get("books");
        HashMap<String, Book> library = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        for (String string : books) {
            Book book = mapper.readValue(string, Book.class);
            library.put(book.getTitle(), book);
            System.out.println(book);
        }


        executor.shutdown();

    }
    public static class URLCallable implements Callable<HashMap> {
        public HashMap<String, Object> request;


        public URLCallable(HashMap<String, Object> request)  {
            this.request = request;
        }

        @Override
        public HashMap call() {

            int responseCode = 0;
            try {
                // create dataMap

                // create URL connection
                String url = "http://localhost:8080/Store_war_exploded/LibraryServlet";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json");
                con.setDoOutput(true);

                // add requestData to connection
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                PrintWriter out = new PrintWriter(con.getOutputStream());
                mapper.writeValue(out, request);

                // get the header response code
                responseCode = con.getResponseCode();
                // if 200, then get jsonString from inputStream.
                if (responseCode == 200) {
                    System.out.println("sending request: " + request);
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    // close buffered reader
                    in.close();
                    // deserialize and return hashmap
                    return mapper.readValue(response.toString(), HashMap.class);
                }


                // get return information from server
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return request;
        }
    }
    public static String mapper(HashMap<String, Object> data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(data);
    }
    public static HashMap<String, Object> unmapper(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, HashMap.class);
    }
}
