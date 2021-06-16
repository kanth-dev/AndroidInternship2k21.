package com.example.recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity implements itemAdapter.MyInterface {
    RecyclerView rv;
    Button button;
    int totalAmount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recyclerview);

        int[] images = {R.drawable.a, R.drawable.b};
        String[] itemNames = {"Rice","Chicken","Mutton","Papad","Potato","Dal","Gulab Jamun","Pickle","Custard","Curd"} ;
        String[] price={"100","150","200","30","50","60","20","10","30","25"};
        rv.setLayoutManager(new LinearLayoutManager(this));
        itemAdapter adapter = new itemAdapter(this,images,itemNames,price);
        rv.setAdapter(adapter);

    }

    public void submit(View view) {

    }
    @Override
    public void selectedItems(String itemName, String itemPrice, int position, int totalPrice) {
        Toast.makeText(this, " "+totalPrice, Toast.LENGTH_SHORT).show();
        Log.i("TOTAL"," "+totalPrice);
        totalAmount=totalAmount+Integer.parseInt(itemPrice);

        button.setText(String.valueOf(totalAmount));
}}
