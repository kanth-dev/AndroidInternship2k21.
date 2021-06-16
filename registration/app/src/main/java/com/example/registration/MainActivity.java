package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] Branch={"----Select Branch-------","CSE","ECE","CIVIL","IT","MECH"};
    EditText name,number,mail;
    TextView dob;
    Button register;
    CheckBox tel,sp,hin,eng;
    Spinner spinner;
    RadioButton gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sp =findViewById(R.id.spinner);
      EditText  name=findViewById(R.id.name);
        TextView dob=findViewById(R.id.dob);
        CheckBox tel=findViewById(R.id.tel);
        CheckBox hin=findViewById(R.id.hin);
        CheckBox eng=findViewById(R.id.eng);
        CheckBox spa=findViewById(R.id.sp);
        EditText mail=findViewById(R.id.mail);
        Button register=findViewById(R.id.register);
        RadioGroup gender=findViewById(R.id.gender);



        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Branch);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        sp.setAdapter(aa);


    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),Branch[position] ,Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void register(View view) {
        String n =name.getText().toString();
        String m=mail.getText().toString();
        String num=number.getText().toString();


    }
    public void dob(View view){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker View, int year, int month, int date) {
                dob.setText(date + "/" + (month + 1) + "/" + year);
            }
        }, year, month, date);
        dpd.show();
    }

}