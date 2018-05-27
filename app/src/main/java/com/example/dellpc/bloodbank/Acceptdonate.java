package com.example.dellpc.bloodbank;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Acceptdonate extends AppCompatActivity {
    Button accept,donate,logout,remove;
    DatabaseHandler db;
    TextView wel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceptdonate);
        accept=(Button)findViewById(R.id.button6);
        remove=(Button)findViewById(R.id.button17);
        logout=(Button)findViewById(R.id.button12);
        wel=(TextView)findViewById(R.id.textView15);
        donate=(Button)findViewById(R.id.button8);
        final String log=getIntent().getStringExtra("log");
        String Userid=getIntent().getStringExtra("Userid");
        wel.setText("Welcome "+Userid);
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=new DatabaseHandler(Acceptdonate.this,null,null,1);
                db.updatedonor(log);
                Intent i = new Intent(Acceptdonate.this,Donor.class);
                startActivity(i);
            }
        });
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Acceptdonate.this,bloodselection.class);
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Acceptdonate.this,Homescreen.class);
                startActivity(i);
            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=new DatabaseHandler(Acceptdonate.this,null,null,1);
                db.updatedonor1(log);
                Toast.makeText(getApplicationContext(),"Removed from donor's list",Toast.LENGTH_LONG).show();
            }
        });
    }
}
