package com.example.dellpc.bloodbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Homescreen extends AppCompatActivity {
    private Button login,register,admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        login = (Button)findViewById(R.id.button);
        register = (Button)findViewById(R.id.button2);
        admin=(Button)findViewById(R.id.button19);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Homescreen.this,AdminLogin.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Homescreen.this,Loign.class);
                startActivity(i);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Homescreen.this, Register.class);
                startActivity(i);
            }
        });
    }
}
