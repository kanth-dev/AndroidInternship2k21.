package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    EditText et,link,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et= findViewById(R.id.et);
        EditText num = findViewById(R.id.number);
        EditText link= findViewById(R.id.link);
    }

    public void next(View view) {

        Intent intent = new Intent(MainActivity.this,name.class);

        startActivity(intent);

    }


    public void dial(View view) {
        //Here we will work with Implicit inte= ;
        Log.i(this,onCreate();)
    }


    public void search(View view) {
        String n = link.getText().toString();
        Uri uri = Uri.parse("https://"+n);
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }
}