package com.example.dellpc.bloodbank;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdminDonorInfo extends AppCompatActivity {
    TextView a,b,c,d,e,f;
    Button dele;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_donor_info);
       final String userii=getIntent().getStringExtra("userii");
        a=(TextView)findViewById(R.id.textView32);
        b=(TextView)findViewById(R.id.textView33);
        c=(TextView)findViewById(R.id.textView34);
        d=(TextView)findViewById(R.id.textView35);
        e=(TextView)findViewById(R.id.textView36);
        f=(TextView)findViewById(R.id.textView37);
        dele=(Button)findViewById(R.id.button22);
        db=new DatabaseHandler(AdminDonorInfo.this,null,null,1);
        String name=db.name(userii);
        String dob=db.dob(userii);
        String phone=db.mobile(userii);
        String sex=db.sexx(userii);
        String blood=db.blood(userii);
        String donor=db.donor(userii);
        a.setText(name);
        b.setText(dob);
        c.setText(phone);
        d.setText(sex);
        e.setText(blood);
        f.setText(donor);
        dele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder=new AlertDialog.Builder(AdminDonorInfo.this);
                a_builder.setMessage("Deleting User...")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                db.deleteUser(userii);
                                Intent i = new Intent(AdminDonorInfo.this,Admin.class);
                                startActivity(i);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert=a_builder.create();
                alert.setTitle("Alert!!!");
                alert.show();
            }
        });
    }

}
