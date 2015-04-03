package com.example.jlee.equityeatsproject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by JLee on 4/2/15.
 */
public class GetURL {


        public static String getParameterKey(String search)
        {


            // replace all spaces with "+"

            for (int i = 0; i < search.length(); i++) {

                char searchIndex = search.charAt(i);
                if (searchIndex == ' ') {
                    searchIndex = '+';

                }
            }
            String urlBase = "https://itunes.apple.com/search?";
            String key1 = "term";
            String key2 = "country";


            String link= (urlBase + key1 + "=" + search + "&" + key2 + "=" + "US");
            URL url;
            StringBuilder builder;
            String line;
            JSONObject json;
            String output;
            try {
                url = new URL(link);

                URLConnection connection = url.openConnection();

                String urlString = "";
                builder = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

                json = new JSONObject(builder.toString());
                output = json.toString();
            }
            catch (IOException e)

            {
                output= "THIS DIDN'T WORK";

            }

            catch(JSONException j)
            {
                output = "WRONG!";
            }

            return output;
        }



    }
