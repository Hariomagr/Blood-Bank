package com.example.dellpc.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {
    Button logout,showall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        logout=(Button)findViewById(R.id.button20);
        showall=(Button)findViewById(R.id.button18);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Admin.this,Homescreen.class);
                startActivity(i);
            }
        });
        showall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Admin.this,ViewListContents1.class);
                startActivity(i);
            }
        });
    }
}
