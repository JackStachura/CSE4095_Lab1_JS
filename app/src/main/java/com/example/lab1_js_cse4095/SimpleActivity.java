package com.example.lab1_js_cse4095;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SimpleActivity extends AppCompatActivity {

    private final String C_TAG = "ON_CREATE";
    private final String S_TAG = "ON_START";
    private final String R_TAG = "ON_RESUMED";
    private final String P_TAG = "ON_PAUSED";
    private final String ST_TAG = "ON_STOP";
    private final String D_TAG = "ON_DESTROY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(C_TAG, "non-existant --> stopped");
        setContentView(R.layout.content_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button = findViewById(R.id.HelloWorld);
        button.setText("Show Message");
        TextView tv = findViewById(R.id.HWTextView);
        final boolean[] activated = {false};
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!activated[0]) {
                    button.setText("Hide Message");
                    tv.setText("Hello World!");
                    activated[0] = true;
                }
                else {
                    button.setText("Show Message");
                    tv.setText("");
                    activated[0] = false;
                }
            }
        });
    }
    protected void onStart(){
        super.onStart();
        Log.i(S_TAG,"stopped --> paused");
    }
    protected void onResume(){
        super.onResume();
        Log.i(R_TAG, "paused --> resumed");
    }
    protected void onPause(){
        super.onPause();
        Log.i(P_TAG, "resumed --> paused");
    }
    protected void onStop(){
        super.onStop();
        Log.i(ST_TAG, "paused --> stopped");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(D_TAG, "stopped --> destroyed");
    }
}