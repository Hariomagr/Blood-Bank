package com.example.dellpc.bloodbank;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DonorInfo extends AppCompatActivity {
    Button back,logout;
    TextView a,b,c,d,e;
    ImageButton call,msz;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_info);
        back=(Button)findViewById(R.id.button11);
        logout=(Button)findViewById(R.id.button14);
        a=(TextView)findViewById(R.id.textView16);
        b=(TextView)findViewById(R.id.textView22);
        c=(TextView)findViewById(R.id.textView23);
        d=(TextView)findViewById(R.id.textView24);
        e=(TextView)findViewById(R.id.textView26);
        call=(ImageButton)findViewById(R.id.imageButton6);
        msz=(ImageButton)findViewById(R.id.imageButton9);
        String useri=getIntent().getStringExtra("useri");
        db=new DatabaseHandler(DonorInfo.this,null,null,1);
        String name=db.name(useri);
        String dob=db.dob(useri);
        String phone=db.mobile(useri);
        String sex=db.sexx(useri);
        String blood=db.blood(useri);
        a.setText(name);
        b.setText(dob);
        c.setText(phone);
        d.setText(sex);
        e.setText(blood);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DonorInfo.this,bloodselection.class);
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DonorInfo.this,Homescreen.class);
                startActivity(i);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent=new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+c.getText().toString()));
                startActivity(callIntent);
            }
        });
        msz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sms=new Intent(Intent.ACTION_SENDTO,Uri.parse("sms:"+c.getText().toString()));
                sms.putExtra("sms_body","Message from Blood Bank:"+"\n" +"In urgent need of blood donor. Kindly contact this number to donate blood."+"\n" +"Thank You!!!");
                startActivity(sms);

            }
        });
    }
}
