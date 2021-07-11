package com.example.random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class booking extends AppCompatActivity {
    TextView kanth;
    GridLayout grid;
    TextView a11,a12,a13,b11,b12,b13,c11,c12,c13,d11,d12,d13,e11,e12,e13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        kanth=findViewById(R.id.tan);
        kanth.setText("your area is"+getIntent().getExtras().getString("title"));

        grid=findViewById(R.id.grid);
        a11= findViewById(R.id.a1);
        a12= findViewById(R.id.a2);
        a13= findViewById(R.id.a3);
        b11= findViewById(R.id.b1);
        b12= findViewById(R.id.b2);
        b13= findViewById(R.id.b3);
        c11= findViewById(R.id.c1);
        c12= findViewById(R.id.c2);
        c13= findViewById(R.id.c3);
        d11= findViewById(R.id.d1);
        d12= findViewById(R.id.d2);
        d13= findViewById(R.id.d3);
        e11= findViewById(R.id.e1);
        e12= findViewById(R.id.e2);
        e13= findViewById(R.id.e3);
        e13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
                String str=c11.getText().toString();
                i.putExtra("str",e13.getText().toString());
                startActivity(i);
            }
        });
        e12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
                String str=e12.getText().toString();
                i.putExtra("str",e12.getText().toString());
                startActivity(i);
            }
        });
        e11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
                String str=e11.getText().toString();
                i.putExtra("str",e11.getText().toString());
                startActivity(i);
            }
        });
        d13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
                String str=d13.getText().toString();
                i.putExtra("str",d13.getText().toString());
                startActivity(i);
            }
        });
        d12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
                String str=d12.getText().toString();
                i.putExtra("str",d12.getText().toString());
                startActivity(i);
            }
        });
        d11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
                String str=d11.getText().toString();
                i.putExtra("str",d11.getText().toString());
                startActivity(i);
            }
        });
        c13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
                String str=c13.getText().toString();
                i.putExtra("str",c13.getText().toString());
                startActivity(i);
            }
        });
        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
                String str=c12.getText().toString();
                i.putExtra("str",c12.getText().toString());
                startActivity(i);
            }
        });
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
                String str=c11.getText().toString();
                i.putExtra("str",c11.getText().toString());
                startActivity(i);
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
                String str=b13.getText().toString();
                i.putExtra("str",b13.getText().toString());
                startActivity(i);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
                String str=b12.getText().toString();
                i.putExtra("str",b12.getText().toString());
                startActivity(i);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
                String str=b11.getText().toString();
                i.putExtra("str",b11.getText().toString());
                startActivity(i);
            }
        });
        a13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
                String str=a13.getText().toString();
                i.putExtra("str",a13.getText().toString());
                startActivity(i);
            }
        });
        a12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
                String str=a12.getText().toString();
                i.putExtra("str",a12.getText().toString());
                startActivity(i);

            }
        });
        a11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(booking.this,Slotbooking.class);
               String str=a11.getText().toString();
               i.putExtra("str",a11.getText().toString());
               startActivity(i);


            }
        });





    }


}