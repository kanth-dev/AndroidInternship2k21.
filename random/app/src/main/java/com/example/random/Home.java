package com.example.random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity  {
    FirebaseAuth auth;
    RecyclerView rcv;
    String s1[];






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rcv=findViewById(R.id.rclview);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        s1=getResources().getStringArray(R.array.WareHouse_list);
        myAdapter myAdapter=new myAdapter(this,s1);
        rcv.setAdapter(myAdapter);
        getSupportActionBar().hide();
        rcv.setLayoutManager(new LinearLayoutManager(this));






        auth = FirebaseAuth.getInstance();


    }


    


    public void logout(View view) {
        auth.signOut();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }



}