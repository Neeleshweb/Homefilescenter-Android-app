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
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Categoryform extends AppCompatActivity {
    AutoCompleteTextView tv1;
    EditText ed1,ed2,ed3,ed4,ed5;
    Button btn;
    String get ;
    String my;
    String cat,subcat1,subcat2,subcat3,subcat4,subcat5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryform);
        tv1=(AutoCompleteTextView)findViewById(R.id.category);
        ed1=(EditText)findViewById(R.id.sub_cat1);
        ed2=(EditText)findViewById(R.id.sub_cat2);
        ed3=(EditText)findViewById(R.id.sub_cat3);
        ed4=(EditText)findViewById(R.id.sub_cat4);
        ed5=(EditText)findViewById(R.id.sub_cat5);
        btn=(Button)findViewById(R.id.addcat);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cat=tv1.getText().toString();
                subcat1=ed1.getText().toString();
                subcat2=ed2.getText().toString();
                subcat3=ed3.getText().toString();
                subcat4=ed4.getText().toString();
                subcat5=ed5.getText().toString();

                SQLiteDatabase data=openOrCreateDatabase("homefilescenter",MODE_APPEND,null);
                data.execSQL("create table if not exists cat(Category varchar,sucat1 varchar,sucat2 varchar,sucat3 varchar,sucat4 varchar,sucat5 varchar)");
                data.execSQL("insert into cat values('" + cat + "','" + subcat1 + "','" + subcat2 + "','" + subcat3 + "','" + subcat4 + "','" +subcat5 + "')");
                Cursor cur1=data.rawQuery("select * from cat",null);
                while(cur1.moveToNext()) {
                    my=cur1.getString(0);


                }

                AlertDialog.Builder make1=new AlertDialog.Builder(Categoryform.this);
                make1.setTitle("RESULT STATUS");
                make1.setMessage("CONGRATULATIONS YOUR CATEGORY" +my+"is added to homefilescenter,you can view it in your category vault");
                make1.setPositiveButton("VIEW NOW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent send=new Intent(Categoryform.this,Statistics.class);
                        startActivity(send);
                        finish();
                    }
                });
                AlertDialog alert=make1.create();
                alert.show();

            }
        });

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            exitByBackKey();


            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    protected void exitByBackKey() {

        AlertDialog.Builder make = new AlertDialog.Builder(Categoryform.this);
        make.setTitle("SORRY !!");
        make.setMessage("You cannot go back in between the process !!");
        make.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        AlertDialog alert = make.create();
        alert.show();

    }

}
