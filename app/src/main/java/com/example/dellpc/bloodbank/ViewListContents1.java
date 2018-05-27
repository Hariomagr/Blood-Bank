package com.example.dellpc.bloodbank;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewListContents1 extends AppCompatActivity {
    DatabaseHandler db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontent1);
        final ListView listView=(ListView)findViewById(R.id.listview1);
        db=new DatabaseHandler(ViewListContents1.this,null,null,1);
        final ArrayList<String> dolist=new ArrayList<>();
        Cursor cursor=db.getdetail();
        while (cursor.moveToNext()){
            dolist.add(cursor.getString(3));
            ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
            listView.setAdapter(listAdapter);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ViewListContents1.this,AdminDonorInfo.class);
                i.putExtra("userii",dolist.get(position).toString());
                startActivity(i);
            }
        });
    }
}
