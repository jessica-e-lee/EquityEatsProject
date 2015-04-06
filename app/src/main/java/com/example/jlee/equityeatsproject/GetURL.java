package com.example.jlee.equityeatsproject;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import android.util.JsonReader;


/**
 * Created by JLee on 4/2/15.
 */
public class GetURL {


    public static ArrayList<String> getParameterKey(String search)  {
        // turn search Name Name to Name+Name for search parameter
        String parameters = search.replaceAll(" ", "+");

        String urlBase = "https://itunes.apple.com/search?";
        String key1 = "term";
        String key2 = "country";


        String link = (urlBase + key1 + "=" + parameters + "&" + key2 + "=" + "US");
        URL url;
        StringBuilder builder;

        // initialize variables

        String line;
        JSONArray bigArray = null;
        JSONObject json2;
        String artistName="";
        String kind = "";
        String collectionName = "";
        String trackName = "";
        double price = 0;
        String genre= "";
        double collectionPrice;
        String output = "";
        ArrayList<String> responseList = new ArrayList<>();

        try {
            url = new URL(link);

            URLConnection connection = url.openConnection();
            // example from Google Code JSON to Java -- https://developers.google.com/image-search/v1/jsondevguide
            String urlString = "";
            builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

             json2 = new JSONObject(builder.toString());


            bigArray = json2.getJSONArray("results");
           JSONObject[] arrays = new JSONObject[bigArray.length()];

             // get the objects within the JSON array
            for (int i = 0; i < bigArray.length() ; i++) {

                JSONObject childJSONObject = bigArray.getJSONObject(i);

                arrays[i]=childJSONObject;

            }
                // create each individual response in response lost
                for (int j = 0; j < arrays.length; j++) {

                    JSONObject child = arrays[j];

                    artistName = child.getString("artistName");
                    kind = child.getString("kind");
                    trackName = child.getString("trackName");
                    collectionName = child.getString("collectionName");
                    genre = child.getString("primaryGenreName");
                    price= child.getDouble("trackPrice");
                    collectionPrice = child.getDouble("collectionPrice");
                    String temp = ("Kind: " + kind + "\n" + "Artist: " + artistName +
                            "\n" + "Track Name: " + trackName +  "\n" + "Album: " + collectionName +
                            "\n" + "Genre: " + genre + "\n" + "Track Price: $" +
                            price + "\n" + "Album Price: $" + collectionPrice + "\n");

                    responseList.add(temp);


                }

        }
        catch (Exception j) {
            output = "We could not process your request";

        }
        return responseList;
    }

}