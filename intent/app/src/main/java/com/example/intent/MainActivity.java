package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.intent.R;
import com.example.intent.kanth;

public class MainActivity extends AppCompatActivity {
    // declare all the view here
    EditText et,number,link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize all the views here
     et = findViewById(R.id.et);
     number =findViewById(R.id.number);
     link=findViewById(R.id.link);
    }



    public void dial(View view) {
        //here we will work with imlicient intent
        String n = number.getText().toString();
        //uri=unified resource identifiers
        // if phone -tel;,web - https://  loc-geo:lat,lon
        Uri uri = Uri.parse("tel:"+n);
        Intent i = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);
    }

    public void search(View view) {
        String n= link.getText().toString();
        Uri uri=Uri.parse("https://"+n);
        Intent i=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }

    public void Next(View view) {
        //here we will work withthe explict intent
        String n= et.getText().toString();
        // intent obj = new Intent(present class.next class)
        //startActivity(obj)
        Intent i=new Intent(MainActivity.this,kanth.class);
        i.putExtra("key",n);
        startActivity(i);
    }
}