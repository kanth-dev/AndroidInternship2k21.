package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class kanth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanth);
        String n= getIntent().getStringExtra("key");
        Toast.makeText(this, "wlcome"+n, Toast.LENGTH_SHORT).show();

    }
}