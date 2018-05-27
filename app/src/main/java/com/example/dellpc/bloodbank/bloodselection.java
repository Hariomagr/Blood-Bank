package com.example.dellpc.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class bloodselection extends AppCompatActivity {
    Button submit,logout;
    String bloodgrp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodselection);
        Spinner myspinner=(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(bloodselection.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        submit=(Button)findViewById(R.id.button9);
        logout=(Button)findViewById(R.id.button13);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bloodgrp.equals("")){
                    Toast.makeText(getApplicationContext(), "Select Any", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(bloodselection.this, ViewListContents.class);
                    i.putExtra("bloodgrp",bloodgrp);
                    startActivity(i);
                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(bloodselection.this,Homescreen.class);
                startActivity(i);
            }
        });
    }
}
