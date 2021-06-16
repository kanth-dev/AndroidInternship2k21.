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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;

public class registration extends AppCompatActivity {
    EditText ename, epasswd, erepasswd, ephone, eemail;
    Button eRegister;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ename = findViewById(R.id.name);
        epasswd = findViewById(R.id.passwd);
        erepasswd = findViewById(R.id.repassswd);
        ephone = findViewById(R.id.phone);
        eemail = findViewById(R.id.email);
        eRegister = findViewById(R.id.register);
        fAuth = FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), Interface.class));
            finish();

        }
        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = eemail.getText().toString().trim();
                String passwd =epasswd.getText().toString();
                String repasswd=erepasswd.getText().toString();
                final String name=ename.getText().toString();
                final String phone=ephone.getText().toString();
                if (TextUtils.isEmpty(name)){
                    ename.setError("Enter a name");
                    return;
                }
                if (TextUtils.isEmpty(phone)){
                    ephone.setError("enter a phone number");
                    return;
                }
                if (TextUtils.isEmpty(email)){
                    eemail.setError("Enter a email");
                    return;
                }
                if (TextUtils.isEmpty(passwd)){
                    epasswd.setError("enter a password");
                    return;
                }

                if (!erepasswd.equals(epasswd)){
                    erepasswd.setError("password is not match");
                    return;

                }
                fAuth.createUserWithEmailAndPassword(email,passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) ;
                        FirebaseUser fuser = fAuth.getCurrentUser();
                        fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(registration.this, "Verification mail send", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d(TAG, "onFailure:Email is not sent" + e.getMessage());
                            }
                        });
                        

                    }
            });
        }



    });



}

    }
