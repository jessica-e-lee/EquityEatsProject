package com.example.jlee.equityeatsproject;import android.support.v7.app.ActionBarActivity;import android.os.Bundle;import android.view.Menu;import android.view.MenuItem;import android.widget.Button;import android.content.Intent;import android.os.Bundle;import android.view.KeyEvent;import android.view.Menu;import android.view.MenuItem;import android.view.View;import android.view.inputmethod.EditorInfo;import android.widget.Button;import android.widget.EditText;import android.widget.TextView;import android.widget.TextView.OnEditorActionListener;public class MainActivity extends ActionBarActivity {    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);    }    private void setupSellButton()    {        Button Search = (Button)findViewById(R.id.search1button);        Search.setOnClickListener(new View.OnClickListener()        {            @Override            public void onClick(View v)            {                startActivity(new Intent(MainActivity.this,CallAPI.class));            }        });    }    private void setupSearchButton()    {    }    @Override    public boolean onCreateOptionsMenu(Menu menu) {        // Inflate the menu; this adds items to the action bar if it is present.        getMenuInflater().inflate(R.menu.menu_main, menu);        return true;    }    @Override    public boolean onOptionsItemSelected(MenuItem item) {        // Handle action bar item clicks here. The action bar will        // automatically handle clicks on the Home/Up button, so long        // as you specify a parent activity in AndroidManifest.xml.        int id = item.getItemId();        //noinspection SimplifiableIfStatement        if (id == R.id.action_settings) {            return true;        }        return super.onOptionsItemSelected(item);    }}