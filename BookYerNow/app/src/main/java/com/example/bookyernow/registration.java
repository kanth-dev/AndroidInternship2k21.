package com.example.bookyernow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class registration extends AppCompatActivity {
    EditText rname,remail,rphone,rpass;
    private FirebaseAuth fAuth;
    Button register;
    ProgressBar prgbar;
    FirebaseFirestore fStore;




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
                if (email.isEmpty()) {
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
                            FirebaseUser fuser=fAuth.getCurrentUser();

                            Task<Void> mail_has_sent = fuser.sendEmailVerification().addOnCompleteListener((OnCompleteListener<Void>) aVoid -> Toast.makeText(registration.this, "mail has sent", Toast.LENGTH_SHORT).show()).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "on Failure: Email Not Sent" + e.getMessage());
                                }
                            });

                            Toast.makeText(registration.this,"successfully logged",Toast.LENGTH_SHORT).show();
                            String userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference=fStore.collection("users").document(userID);

                            Map<String,Object> user=new HashMap<>();
                            user.put("name",name);
                            user.put("email",email);
                            user.put("phone",rphone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG,"on success"+userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"on failure"+e.toString());
                                }
                            });
                            if (!register.equals(null));
                            startActivity(new Intent(registration.this,MainActivity.class));




                        }else{


                            Toast.makeText(registration.this,"error !",Toast.LENGTH_SHORT).show();
                            prgbar.setVisibility(View.GONE);
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