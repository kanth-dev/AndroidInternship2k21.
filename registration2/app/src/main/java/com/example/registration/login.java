package com.example.registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

       EditText mail,pass;
       FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mail=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        auth=FirebaseAuth.getInstance();
        if (auth.getCurrentUser()!=null){
            startActivity(new Intent(this,registration.class));
            finish();
        }

    }

    public void login(View view) {

            String email = mail.getText().toString().trim();
            String password = pass.getText().toString();
            if (email.isEmpty()|password.isEmpty()){
                mail.setError("maill is required");
                pass.setError("password required");
            }
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        startActivity(new Intent(login.this,registration.class));
                    }else {
                        Toast.makeText(login.this, "login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });

                }

                }




