package com.example.bookyernow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText remail,rpass;
    Button login;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText  rmail=findViewById(R.id.email);
        EditText  rpasswd=findViewById(R.id.passwd);
        Button login=findViewById(R.id.login);
        fAuth=FirebaseAuth.getInstance();
        login .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String email=rmail.getText().toString().trim();
                String passwd=rpasswd.getText().toString().trim();
                if (email.isEmpty()){
                    remail.setError("mail is required");
                    remail.requestFocus();
                    return;
                }
                if (passwd.isEmpty()){
                    rpass
                            .setError("password required");
                    rpass.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    remail.setError("enter valid mail");
                    remail.requestFocus();
                    return;
                }
                if (passwd.length()<6){
                    rpass.setError("password must be greater than 6 characters");
                    rpass.requestFocus();
                    return;
                }
                fAuth.signInWithEmailAndPassword(email,passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(login.this,registration.class));

                        }else {
                            Toast.makeText(login.this,"please check your login credentials",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


    }

    public void signup(View view) {
        startActivity(new Intent(login.this,registration.class));
    }
}