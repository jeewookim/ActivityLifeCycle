package com.example.a2016jkim.activitylifecycle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int onC;
    int onStt;
    int onResu;
    int onP;
    int onStp;
    int onRest;
    int onD;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences mSettings = MainActivity.this.getSharedPreferences("Settings", 0);
        int temp = mSettings.getInt("onCreate", onC) +1;
        save("onCreate", temp);
        TextView textView = (TextView) findViewById(R.id.Create);
        textView.setText("onCreate called: " + mSettings.getInt("onCreate", 0) + " times");

        Button button = (Button) findViewById(R.id.forward);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityDos.class);
                startActivity(intent);
            }

        });

        final Spinner dropdown  = (Spinner) findViewById(R.id.number_choice);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.number_choice, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(arrayAdapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = (String)dropdown.getSelectedItem();
                Intent intent =new Intent(MainActivity.this,ActivityDos.class);
                intent.putExtra("choice",s);
                startActivity(intent);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });}

        @Override
    public void onStart() {
        SharedPreferences mSettings = MainActivity.this.getSharedPreferences("Settings", 0);
        super.onStart();
        int temp = mSettings.getInt("onStart", onStt) +1;
        save("onStart", temp);
        TextView textView = (TextView) findViewById(R.id.Start);
        // textView.setText("onStart called: " + onStt + " times");
        textView.setText("onStart called: " + mSettings.getInt("onStart", 0) + " times");
    }

    @Override
    public void onResume() {
        SharedPreferences mSettings = MainActivity.this.getSharedPreferences("Settings", 0);
        super.onResume();
        int temp = mSettings.getInt("onResume", onResu) +1;
        save("onResume", temp);
        TextView textView = (TextView) findViewById(R.id.Resume);
        //textView.setText("onResume called: " + onResu + " times");
        textView.setText("onResume called: " + mSettings.getInt("onResume", 0) + " times");
    }

    @Override
    public void onPause() {
        SharedPreferences mSettings = MainActivity.this.getSharedPreferences("Settings", 0);
        super.onPause();
        int temp = mSettings.getInt("onPause", onP) +1;

        save("onPause", temp);
        TextView textView = (TextView) findViewById(R.id.Pause);
        // textView.setText("onPause called: " + onP + " times");
        textView.setText("onPause called: " + mSettings.getInt("onPause", 0) + " times");
        }

        @Override
        public void onStop () {
            SharedPreferences mSettings = MainActivity.this.getSharedPreferences("Settings", 0);
        super.onStop();
        int temp = mSettings.getInt("onStop", onStp) +1;
        save("onStop", temp);
        TextView textView = (TextView) findViewById(R.id.Stop);
        //textView.setText("onStop called: " + onStp + " times");
        textView.setText("onStop called: " + mSettings.getInt("onStop", 0) + " times");
    }

    @Override
    public void onRestart() {
        SharedPreferences mSettings = MainActivity.this.getSharedPreferences("Settings", 0);
        super.onRestart();
        int temp = mSettings.getInt("onRestart", onRest) +1;
        save("onRestart", temp);
        TextView textView = (TextView) findViewById(R.id.Restart);
        //textView.setText("onRestart called: " + onRest + " times");
        textView.setText("onRestart called: " + mSettings.getInt("onRestart", 0) + " times");
    }

    @Override
    public void onDestroy() {
        SharedPreferences mSettings = MainActivity.this.getSharedPreferences("Settings", 0);
        super.onDestroy();
        int temp = mSettings.getInt("onDestroy", onD) +1;
        save("onDestroy", temp);
        TextView textView = (TextView) findViewById(R.id.Destroy);
        //textView.setText("onDestroy called: " + onD + " times");
        textView.setText("onDestroy called: " + mSettings.getInt("onDestroy", 0) + " times");
    }

    public void save(String s, int x)
    {
        SharedPreferences mSettings = MainActivity.this.getSharedPreferences("Settings", 0);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(s, x);
        editor.commit();
    }
}
