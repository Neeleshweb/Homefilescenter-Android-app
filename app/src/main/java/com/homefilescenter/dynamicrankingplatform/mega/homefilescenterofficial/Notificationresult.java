package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Notificationresult extends AppCompatActivity {

    String s1,s2,s4 ;
    String z;
    TableLayout lay;
    HorizontalScrollView hv;
    TableRow tr;

    float s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificationresult);
        lay=(TableLayout)findViewById(R.id.tableLayout3);
        hv=(HorizontalScrollView)findViewById(R.id.horizontalscrollview1);



        SQLiteDatabase db=openOrCreateDatabase("homefilescenter",MODE_APPEND,null);
        Cursor curse=db.rawQuery("select * from reviews",null);
        while(curse.moveToNext()) {
            z=curse.getString(3);
        }
        Cursor cure=db.rawQuery("select * from reviews where email=?",new String[]{z});
        while(cure.moveToNext()) {
            s1= cure.getString(0);
            s2=cure.getString(1);
            s3=cure.getFloat(2);
            s4=cure.getString(3);

            tr=new TableRow(this);
            TextView tv1=new TextView(this);
            tv1.setText(s1);
            TextView tv2=new TextView(this);
            tv2.setText(s2);
            TextView tv3=new TextView(this);
            tv3.setText(""+s3);
            TextView tv4=new TextView(this);
            tv4.setText(s4);
            tr.addView(tv1);
            tr.addView(tv2);
            tr.addView(tv3);
            tr.addView(tv4);
            lay.addView(tr);
            db.close();
        }





    }
}


