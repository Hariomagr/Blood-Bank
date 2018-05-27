package com.example.dellpc.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Listdonor extends AppCompatActivity {
    Button name,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdonor);
        name=(Button)findViewById(R.id.button10);
        logout=(Button)findViewById(R.id.button15);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Listdonor.this,DonorInfo.class);
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Listdonor.this,Homescreen.class);
                startActivity(i);
            }
        });
    }
}