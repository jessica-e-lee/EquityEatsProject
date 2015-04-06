package com.example.jlee.equityeatsproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.*;
import java.io.BufferedReader;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import android.os.StrictMode;
import android.text.method.ScrollingMovementMethod;
import android.widget.ListView;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;
import android.widget.BaseAdapter;

public class CallAPI extends ActionBarActivity {


    String searchFor;
    ArrayList<String> output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_api);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String searchFor = MainActivity.searchFor;

        output = GetURL.getParameterKey(searchFor);
        if (output!=null) {
            getListView();
        }
    }



        protected void getListView() {

            ArrayAdapter adapter = new ArrayAdapter<String>(
                    this,
                android.R.layout.simple_list_item_1, output);


            ListView listview;
            listview = (ListView) findViewById(R.id.listView);

            listview.setAdapter(adapter);
           adapter.notifyDataSetChanged();
        }

/// get a scroll bar



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.menu_call_api, menu);
        return true;
    }

  //  @Override
  // public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
     // int id = item.getItemId();

      //  noinspection SimplifiableIfStatement
     //        return true;
      // }

      //  return super.onOptionsItemSelected(item);
   }

