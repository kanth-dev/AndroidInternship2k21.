package com.example.registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;

public class registration extends AppCompatActivity {

      TextView tv;
      FirebaseAuth fAth;








    @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        tv.setText("Welcome "+fAth.getCurrentUser().getEmail());
        fAth=FirebaseAuth.getInstance();



        }


    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(registration.this,login.class));
        finish();
    }
}