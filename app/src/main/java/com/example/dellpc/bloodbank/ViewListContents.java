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
import android.widget.Toast;

import java.util.ArrayList;


public class ViewListContents extends AppCompatActivity {
    DatabaseHandler db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontent_layout);
        final ListView listview=(ListView)findViewById(R.id.listview);
        String bloodgrp=getIntent().getStringExtra("bloodgrp");
        db=new DatabaseHandler(ViewListContents.this,null,null,1);
        ArrayList<String> dolist=new ArrayList<>();
        final ArrayList<String> doinfo=new ArrayList<>();
        Cursor cursor=db.getlistcontent(bloodgrp);
        if(bloodgrp.equals("O+")){
            Cursor cursor1=db.getlistcontent("O-");
            if(cursor.getCount()==0 && cursor1.getCount()==0){
                Toast.makeText(ViewListContents.this,"No donor",Toast.LENGTH_LONG).show();
            }
            else{
                while(cursor.moveToNext()){
                    dolist.add("Name: "+cursor.getString(2)+"                 Blood Group: "+cursor.getString(7));
                    doinfo.add(cursor.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor1.moveToNext()){
                    dolist.add("Name: "+cursor1.getString(2)+"                 Blood Group: "+cursor1.getString(7));
                    doinfo.add(cursor1.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
            }
        }
        else if(bloodgrp.equals("O-")){
            if(cursor.getCount()==0){
                Toast.makeText(ViewListContents.this,"No donor",Toast.LENGTH_LONG).show();
            }
            else{
                while(cursor.moveToNext()){
                    dolist.add("Name: "+cursor.getString(2)+"                 Blood Group: "+cursor.getString(7));
                    doinfo.add(cursor.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
            }
        }
        else if(bloodgrp.equals("A+")){
            Cursor cursor1=db.getlistcontent("A-");
            Cursor cursor2=db.getlistcontent("O+");
            Cursor cursor3=db.getlistcontent("O-");
            if(cursor.getCount()==0 && cursor1.getCount()==0 && cursor2.getCount()==0 && cursor3.getCount()==0){
                Toast.makeText(ViewListContents.this,"No donor",Toast.LENGTH_LONG).show();
            }
            else{
                while(cursor.moveToNext()){
                    dolist.add("Name: "+cursor.getString(2)+"                 Blood Group: "+cursor.getString(7));
                    doinfo.add(cursor.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor1.moveToNext()){
                    dolist.add("Name: "+cursor1.getString(2)+"                 Blood Group: "+cursor1.getString(7));
                    doinfo.add(cursor1.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor2.moveToNext()){
                    dolist.add("Name: "+cursor2.getString(2)+"                 Blood Group: "+cursor2.getString(7));
                    doinfo.add(cursor2.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor3.moveToNext()){
                    dolist.add("Name: "+cursor3.getString(2)+"                 Blood Group: "+cursor3.getString(7));
                    doinfo.add(cursor3.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
            }
        }
        else if(bloodgrp.equals("A-")){
            Cursor cursor1=db.getlistcontent("O-");
            if(cursor.getCount()==0 && cursor1.getCount()==0){
                Toast.makeText(ViewListContents.this,"No donor",Toast.LENGTH_LONG).show();
            }
                else{
                while(cursor.moveToNext()){
                    dolist.add("Name: "+cursor.getString(2)+"                 Blood Group: "+cursor.getString(7));
                    doinfo.add(cursor.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor1.moveToNext()){
                    dolist.add("Name: "+cursor1.getString(2)+"                 Blood Group: "+cursor1.getString(7));
                    doinfo.add(cursor1.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
            }
        }
        else if(bloodgrp.equals("B+")){
            Cursor cursor1=db.getlistcontent("B-");
            Cursor cursor2=db.getlistcontent("O+");
            Cursor cursor3=db.getlistcontent("O-");
            if(cursor.getCount()==0 && cursor1.getCount()==0 && cursor2.getCount()==0 && cursor3.getCount()==0){
                Toast.makeText(ViewListContents.this,"No donor",Toast.LENGTH_LONG).show();
            }
            else{
                while(cursor.moveToNext()){
                    dolist.add("Name: "+cursor.getString(2)+"                 Blood Group: "+cursor.getString(7));
                    doinfo.add(cursor.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor1.moveToNext()){
                    dolist.add("Name: "+cursor1.getString(2)+"                 Blood Group: "+cursor1.getString(7));
                    doinfo.add(cursor1.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor2.moveToNext()){
                    dolist.add("Name: "+cursor2.getString(2)+"                 Blood Group: "+cursor2.getString(7));
                    doinfo.add(cursor2.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor3.moveToNext()){
                    dolist.add("Name: "+cursor3.getString(2)+"                 Blood Group: "+cursor3.getString(7));
                    doinfo.add(cursor3.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
            }
        }
        else if(bloodgrp.equals("B-")){
            Cursor cursor1=db.getlistcontent("O-");
            if(cursor.getCount()==0 && cursor1.getCount()==0){
                Toast.makeText(ViewListContents.this,"No donor",Toast.LENGTH_LONG).show();
            }
            else{
                while(cursor.moveToNext()){
                    dolist.add("Name: "+cursor.getString(2)+"                 Blood Group: "+cursor.getString(7));
                    doinfo.add(cursor.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor1.moveToNext()){
                    dolist.add("Name: "+cursor1.getString(2)+"                 Blood Group: "+cursor1.getString(7));
                    doinfo.add(cursor1.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
            }
        }
        else if(bloodgrp.equals("AB+")){
            Cursor cursor1=db.getlistcontent("O+");
            Cursor cursor2=db.getlistcontent("A+");
            Cursor cursor3=db.getlistcontent("A-");
            Cursor cursor4=db.getlistcontent("B+");
            Cursor cursor5=db.getlistcontent("B-");
            Cursor cursor6=db.getlistcontent("AB-");
            Cursor cursor7=db.getlistcontent("O-");
            if(cursor.getCount()==0 && cursor1.getCount()==0 && cursor2.getCount()==0 && cursor3.getCount()==0 && cursor4.getCount()==0 && cursor5.getCount()==0 && cursor6.getCount()==0 &&cursor7.getCount()==0){
                Toast.makeText(ViewListContents.this,"No donor",Toast.LENGTH_LONG).show();
            }
            else{
                while(cursor.moveToNext()){
                    dolist.add("Name: "+cursor.getString(2)+"                 Blood Group: "+cursor.getString(7));
                    doinfo.add(cursor.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor1.moveToNext()){
                    dolist.add("Name: "+cursor1.getString(2)+"                 Blood Group: "+cursor1.getString(7));
                    doinfo.add(cursor1.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor2.moveToNext()){
                    dolist.add("Name: "+cursor2.getString(2)+"                 Blood Group: "+cursor2.getString(7));
                    doinfo.add(cursor2.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor3.moveToNext()){
                    dolist.add("Name: "+cursor3.getString(2)+"                 Blood Group: "+cursor3.getString(7));
                    doinfo.add(cursor3.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor4.moveToNext()){
                    dolist.add("Name: "+cursor4.getString(2)+"                 Blood Group: "+cursor4.getString(7));
                    doinfo.add(cursor4.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor5.moveToNext()){
                    dolist.add("Name: "+cursor5.getString(2)+"                 Blood Group: "+cursor5.getString(7));
                    doinfo.add(cursor5.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor6.moveToNext()){
                    dolist.add("Name: "+cursor6.getString(2)+"                 Blood Group: "+cursor6.getString(7));
                    doinfo.add(cursor6.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
                while(cursor7.moveToNext()){
                    dolist.add("Name: "+cursor7.getString(2)+"                 Blood Group: "+cursor7.getString(7));
                    doinfo.add(cursor7.getString(3));
                    ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dolist);
                    listview.setAdapter(listAdapter);
                }
            }
        }
        else if(bloodgrp.equals("AB-")){
            Cursor cursor1=db.getlistcontent("A-");
            Cursor cursor2=db.getlistcontent("B-");
            Cursor cursor3=db.getlistcontent("O-");

            if(cursor.getCount()==0 && cursor1.getCount()==0 && cursor2.getCount()==0 && cursor3.getCount()==0 ){
                Toast.makeText(ViewListContents.this,"No donor",Toast.LENGTH_LONG).show();
            }
            else {
                while (cursor.moveToNext()) {
                    dolist.add("Name: " + cursor.getString(2) + "                 Blood Group: " + cursor.getString(7));
                    doinfo.add(cursor.getString(3));
                    ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dolist);
                    listview.setAdapter(listAdapter);
                }
                while (cursor1.moveToNext()) {
                    dolist.add("Name: " + cursor1.getString(2) + "                 Blood Group: " + cursor1.getString(7));
                    doinfo.add(cursor1.getString(3));
                    ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dolist);
                    listview.setAdapter(listAdapter);
                }
                while (cursor2.moveToNext()) {
                    dolist.add("Name: " + cursor2.getString(2) + "                 Blood Group: " + cursor2.getString(7));
                    doinfo.add(cursor2.getString(3));
                    ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dolist);
                    listview.setAdapter(listAdapter);
                }
                while (cursor3.moveToNext()) {
                    dolist.add("Name: " + cursor3.getString(2) + "                 Blood Group: " + cursor3.getString(7));
                    doinfo.add(cursor3.getString(3));
                    ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dolist);
                    listview.setAdapter(listAdapter);
                }
            }
        }
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ViewListContents.this,DonorInfo.class);
                i.putExtra("useri",doinfo.get(position));
                startActivity(i);
            }
        });
    }
}
