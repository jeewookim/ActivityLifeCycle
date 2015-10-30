package com.example.a2016jkim.activitylifecycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class ActivityDos extends AppCompatActivity {
    

    String userChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String choice = intent.getStringExtra("choice");
        TextView textView = (TextView) findViewById(R.id.Value_Presenter);
        textView.setText("Value chosen: " + choice);


        final EditText editText = (EditText) findViewById(R.id.edit_text);
        editText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userChoice = editText.getText().toString();

            }
        });

        Button button = (Button) findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent type_intent = new Intent(ActivityDos.this, MainActivity.class);
                type_intent.putExtra("userChoice", userChoice);
                type_intent.putExtra(userChoice, 0);
                startActivity(type_intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void onSubmit()
        {
        this.finish();
    }

}