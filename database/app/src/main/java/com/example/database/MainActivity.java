package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.database.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText pass,name;
    ActivityMainBinding binding;
    SharedPreferences sp;
    SharedPreferences.Editor edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp=getSharedPreferences("ap",MODE_PRIVATE);
        setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
    }

    public void show(View view) {
        Snackbar.make(view,binding.name.getText().toString()+"\n"+
                binding.pass.getText().toString(),Snackbar.LENGTH_LONG).show();
         


        edt=sp.edit();
        edt.putString("name",binding.name.getText().toString());
        edt.putString("password",binding.pass.getText().toString());
        edt.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();

        edt=sp.edit();
        edt.putString("name",binding.name.getText().toString());
        edt.putString("password",binding.pass.getText().toString());
        edt.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String myname=sp.getString("name","null");
        String mypass=sp.getString("pass","null");
        binding.name.setText(myname);
        binding.pass.setText(mypass);
    }
}