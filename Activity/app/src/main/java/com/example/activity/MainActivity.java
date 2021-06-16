package com.example.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText lmail,lpass;
    TextView lnewreg;
    ProgressBar prgbar;
    Button llogin;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lnewreg=findViewById(R.id.newreg);
        lmail=findViewById(R.id.mail);
        lpass=findViewById(R.id.pass);
        llogin=findViewById(R.id.login);
        llogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=lmail.getText().toString().trim();
                String password=lpass.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    lmail.setError("Email is Required:");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    lpass.setError("enter a valid password");
                    return;
                }
                if (password.length()<6){
                    lpass.setError("password must be grater than 6 characters");
                    return;
                }
                prgbar.setVisibility(view.VISIBLE);
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"logged in successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Interface.class));

                        }else{
                            Toast.makeText(MainActivity.this,"error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            prgbar.setVisibility(view.GONE);
                        }
                    }
                });

            }
        });


    }
    public void newregister(View view) {

        lnewreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),registration.class));
            }
        });

    }


}