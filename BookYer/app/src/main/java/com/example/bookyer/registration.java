package com.example.bookyer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registration extends AppCompatActivity {
    EditText rname,remail,rphone,rpass;
    private FirebaseAuth fAuth;
    Button register;
    ProgressBar prgbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        EditText rname=findViewById(R.id.name);
        EditText remail=findViewById(R.id.email);
        EditText rphone=findViewById(R.id.phone);
        EditText rpass=findViewById(R.id.pass);
        Button register=findViewById(R.id.register);
        prgbar=findViewById(R.id.prgbar);
        fAuth=FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=remail.getText().toString().trim();
                String pass=rpass.getText().toString().trim();
                String name=rname.getText().toString().trim();
                String phone=rphone.getText().toString().trim();
                if (email.isEmpty()){
                    remail.setError("mail is required");
                    remail.requestFocus();
                    return;
                }
                if (pass.isEmpty()){
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
                if (pass.length()<6){
                    rpass.setError("password must be greater than 6 characters");
                    rpass.requestFocus();
                    return;
                }

                prgbar.setVisibility(view.VISIBLE);
                fAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(registration.this,"successfully logged",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(registration.this,login.class));


                        }else {


                            Toast.makeText(registration.this,"Try again",Toast.LENGTH_SHORT).show();
                            prgbar.setVisibility(view.GONE);
                        }



                    }

                });

            }
        });



    }

    public void signup(View view) {
        startActivity(new Intent(registration.this,login.class));
    }
}