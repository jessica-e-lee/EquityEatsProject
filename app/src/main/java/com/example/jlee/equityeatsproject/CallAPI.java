package com.example.jlee.equityeatsproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import org.json.*;

public class CallAPI extends ActionBarActivity {



//link to iTunes API

    public static String urlBase = "https://itunes.apple.com/search?";



    //get user input string

    public String getParameterKey(String search)

    {
        // replace all spaces with "+"

        for (int i= 0; i< search.length(); i++)
        {

            char searchIndex= search.charAt(i);
            if (searchIndex == ' ')
            {
               searchIndex = '+';

            }
        }

        String key1= "term";
        String key2= "country";


        String parameterKey = "urlBase" + "key1" + "=" + "search"+ "&" + "key2" + "=" + "US";
        System.out.println(parameterKey);
        return parameterKey;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_api);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_call_api, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
