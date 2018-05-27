package com.example.dellpc.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loign extends AppCompatActivity {
    Button login,register;
    EditText lo,pa;
    DatabaseHandler db;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loign);
        lo=(EditText)findViewById(R.id.editText);
        pa=(EditText)findViewById(R.id.editText2);
        login=(Button)findViewById(R.id.button3);
        register=(Button)findViewById(R.id.button4);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View args0) {
                    db=new DatabaseHandler(Loign.this,null,null,1);
                String pas=pa.getText().toString();
                String log=lo.getText().toString();
                String StoredPassword=db.getregister(log);
                if(pas.equals(StoredPassword)){
                    String Userid=db.name(log);
                    Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Loign.this,Acceptdonate.class);
                    i.putExtra("Userid",Userid);
                    i.putExtra("log",log);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Username/Password incorrect", Toast.LENGTH_LONG).show();
                    pa.setText("");
                    lo.setText("");
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Loign.this,Register.class);
                startActivity(i);
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_settings:
                // search action
                Intent i=new Intent(Loign.this,Register.class);
                startActivity(i);
                return true;
        }
        return false;

    }
}
