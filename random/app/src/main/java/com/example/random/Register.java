package com.example.random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.DrawableMarginSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText rmail,rpass;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        rmail = findViewById(R.id.rmail);
        rpass = findViewById(R.id.rpass);
        auth = FirebaseAuth.getInstance();
    }

    public void signup(View view) {
        String mail = rmail.getText().toString().trim();
        String pass = rpass.getText().toString();

        if (mail.isEmpty()|pass.isEmpty()){
            Toast.makeText(this, "Please fill all the details",
                    Toast.LENGTH_SHORT).show();
        }else if(pass.length()<6){
            rpass.setError("Minimum 6 digits");
        }
        else{
            auth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        startActivity(new Intent(Register.this,
                                MainActivity.class));
                        Toast.makeText(Register.this, "Registered"
                                , Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(Register.this, "Registration Failed",
                                Toast.LENGTH_SHORT).show();
                }

                }
            });

        }
}

    public void signin(View view) {
        Intent i=new Intent(Register.this,MainActivity.class);
        startActivity(i);
    }
}