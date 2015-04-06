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

        String parameters = search.replaceAll(" ", "+");

        String urlBase = "https://itunes.apple.com/search?";
        String key1 = "term";
        String key2 = "country";


        String link = (urlBase + key1 + "=" + parameters + "&" + key2 + "=" + "US");
        URL url;
        StringBuilder builder;

        String line;
        String output = "";
        String songName;
        JSONArray bigArray = null;
        JSONObject individualObject = null;
        JSONObject json2;
        JSONObject singleResponse= null;
        String wrapperType= "";
        String artistName="";
        String kind = "";
        int artistId = 0;
        int trackId = 0;
        String collectionName = "";
        String trackName = "";
        //String[] responseList = {"empty"};
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

                for (int j = 0; j < arrays.length; j++) {

                    JSONObject child = arrays[j];

                    wrapperType = child.getString("wrapperType");
                    artistName = child.getString("artistName");
                    kind = child.getString("kind");
                    trackId = child.getInt("trackId");
                    trackName = child.getString("trackName");

                    // singleResponse = new JSONObject();
                    // singleResponse.put("wrapperType", wrapperType);
                    //singleResponse.put("artistName", artistName);
                    // singleResponse.put("kind", kind);
                    // singleResponse.put("trackId", trackId);
                    //singleResponse.put ("trackName", trackName);
                    //   String result = singleResponse.toString();
                    String temp = "wrapperType: " + wrapperType + "\n" + "artistName: " + artistName +
                            "\n" + "kind: " + kind + "\n" + "trackId: " + trackId + "\n" + "trackName: " +
                            trackName + "\n" ;

                    responseList.add(temp);


                }

        }
        catch (Exception j) {
            output = "We could not process your request";

        }
       // catch (IOException e) {
        //    output = "We could not process your request";
       // }

        return responseList;
    }

}