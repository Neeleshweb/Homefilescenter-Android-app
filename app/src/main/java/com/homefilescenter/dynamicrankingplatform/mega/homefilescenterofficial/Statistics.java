package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;



import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public  class Statistics extends AppCompatActivity  {

    String cat,sub1,sub2,sub3,sub4,sub5;
    String naming;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        SQLiteDatabase db=openOrCreateDatabase("homefilescenter",MODE_APPEND,null);
        Cursor curse=db.rawQuery("select * from cat",null);
        while(curse.moveToNext()) {
            cat=curse.getString(0);
            sub1=curse.getString(1);
            sub2=curse.getString(2);
            sub3=curse.getString(3);
            sub4=curse.getString(4);
            sub5=curse.getString(5);

        }
        if((cat!=null && sub1!=null)&&(sub2!=null && sub3!=null)) {
            LinearLayout layout = new LinearLayout(this);
            layout.setBackgroundResource(R.drawable.a);


            final ArrayList<String> spinnerArray = new ArrayList<String>();
            spinnerArray.add(cat);
            spinnerArray.add(sub1);
            spinnerArray.add(sub2);
            spinnerArray.add(sub3);
            spinnerArray.add(sub4);
            spinnerArray.add(sub5);

            Spinner spinner = new Spinner(this,Spinner.MODE_DIALOG);
            spinner.setBackgroundResource(R.drawable.bgrect);

            ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
            spinner.setAdapter(spinnerArrayAdapter);

            layout.addView(spinner);

            setContentView(layout);

            ArrayAdapter adapt5=new ArrayAdapter(Statistics.this,android.R.layout.simple_spinner_item,spinnerArray);
            adapt5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapt5);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                Boolean count=false;
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if(count) {
                        switch(position) {
                            case 0:
                                Toast.makeText(Statistics.this,"Please click on sub-categories,as they can be rated,not the category",Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                Intent i1=new Intent(Statistics.this,Reviewsubmission.class);
                                i1.putExtra("one",sub1);
                                startActivity(i1);
                                finish();
                                break;
                            case 2:
                                Intent i2=new Intent(Statistics.this,Reviewsubmission.class);
                                i2.putExtra("two",sub2);
                                startActivity(i2);
                                finish();
                                break;
                            case 3:
                                Intent i3=new Intent(Statistics.this,Reviewsubmission.class);
                                i3.putExtra("three",sub3);
                                startActivity(i3);
                                finish();
                                break;
                            case 4:
                                Intent i4=new Intent(Statistics.this,Reviewsubmission.class);
                                i4.putExtra("four",sub4);
                                startActivity(i4);
                                finish();
                                break;
                            case 5:
                                Intent i5=new Intent(Statistics.this,Reviewsubmission.class);
                                i5.putExtra("five",sub5);
                                startActivity(i5);
                                finish();
                                break;
                        } }else {
                        count=true;
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        } else {
            AlertDialog.Builder make2 = new AlertDialog.Builder(Statistics.this);
            make2.setTitle("NEW USER!!");
            make2.setMessage("It seems like you are a new user of our app as your details are not existing,kindly take the test,then if you qualify,you can add your category and then check back here again.Would you like to take test now?? ");
            make2.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent send = new Intent(Statistics.this, Customcategorydesc.class);
                    startActivity(send);
                    finish();
                }
            });
            make2.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent send = new Intent(Statistics.this,Welcome.class);
                    SQLiteDatabase dts=openOrCreateDatabase("homefilescenter",MODE_APPEND,null);
                    Cursor c1=dts.rawQuery("select * from register",null);
                    while(c1.moveToNext()) {
                        naming=c1.getString(2);
                    }
                    send.putExtra("abcd",naming);
                    startActivity(send);
                    finish();
                }
            });
            AlertDialog alert = make2.create();
            alert.show();
        }


    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            exitByBackKey();


            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    protected void exitByBackKey() {

        AlertDialog.Builder make = new AlertDialog.Builder(Statistics.this);
        make.setTitle("SORRY !!");
        make.setMessage("You cannot go back !!");
        make.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        AlertDialog alert = make.create();
        alert.show();

    }

}








