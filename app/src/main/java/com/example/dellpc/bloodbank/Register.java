package com.example.dellpc.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Register extends AppCompatActivity{
    DatabaseHandler db;
    TextView mo;
    public EditText userid,password,name,dob,number;
    RadioButton male,female;
    public String sex="",bloodgrp="",phone="",birth="",useri="",pass="",nam="";
    Button home,reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Spinner myspinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Register.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);

        myspinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String label = adapterView.getItemAtPosition(i).toString();
                if (label.equals("Select any"))
                    bloodgrp = "";
                else
                    bloodgrp = label;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        userid = (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText4);
        name = (EditText) findViewById(R.id.editText5);
        dob = (EditText) findViewById(R.id.editText6);
        number = (EditText) findViewById(R.id.editText7);
        male = (RadioButton) findViewById(R.id.Male);
        female = (RadioButton) findViewById(R.id.female);
        home = (Button) findViewById(R.id.button16);
        mo=(TextView)findViewById(R.id.textView14);
        reg=(Button)findViewById(R.id.button5);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, Homescreen.class);
                startActivity(i);
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (male.isChecked())
                    sex = "Male";
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (female.isChecked())
                    sex = "Female";
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                db= new DatabaseHandler(Register.this,null,null,1);
                phone=number.getText().toString();
                birth=dob.getText().toString();
                useri=userid.getText().toString();
                pass=password.getText().toString();
                nam=name.getText().toString();
                String mail=db.getregister(useri);
                if(phone.equals("")||birth.equals("")||useri.equals("")||pass.equals("")||nam.equals("")||sex.equals("")||bloodgrp.equals("") ){

                    Toast.makeText(getApplicationContext(), "Enter All Fields", Toast.LENGTH_LONG).show();
                }
                else if(phone.length()!=10){
                    mo.setText("Enter Valid Mobile Number");
                }
                else if(mail.equals("BloodDonationProject")){
                    Toast.makeText(getApplicationContext(), "Email already Exists", Toast.LENGTH_LONG).show();
                }
                else if(mail.equals(useri)){
                    Toast.makeText(getApplicationContext(), "Email already Exists", Toast.LENGTH_LONG).show();
                }
                else{
                    db=new DatabaseHandler(Register.this,null,null,2);
                    Registerdata reg= new Registerdata();
                    reg.setname(nam);
                    reg.setemail(useri);
                    reg.setPassword(pass);
                    reg.setbloodgrp(bloodgrp);
                    reg.setsex(sex);
                    reg.setdob(birth);
                    reg.setnumber(phone);
                    db.addregister(reg);
                    Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Register.this,Loign.class);
                    startActivity(i);
                }
            }
        });
    }
}



