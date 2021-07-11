package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class payout extends AppCompatActivity {
    TextView mny,area1,totaalc;

    Button updation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payout);


        totaalc=findViewById(R.id.totalc);
        area1=findViewById(R.id.area);
        area1.setText("your total area is "+getIntent().getExtras().getString("TotalArea"));
            mny= findViewById(R.id.tc);

            updation=findViewById(R.id.update);

        mny.setText(" your total cost per day is"+getIntent().getExtras().getString("TotalCost"));

        String str=mny.getText().toString();
        str=str.replaceAll("[^0-9]","");


        String finalStr = str;
        updation.setOnClickListener(new View.OnClickListener() {






           @Override
           public void onClick(View v) {

               totaalc.setText(finalStr);
               int num2=Integer.parseInt(finalStr);
               Intent ip=new Intent(payout.this,payin.class);
               ip.putExtra("cost",totaalc.getText());
               startActivity(ip);










           }
       });

    }










    }
