package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Viewprofile extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5 ;
    String emailid,password,name,city,mobno ;
    String g1,g2,g3,g4,g5;
    Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);

        tv1=(TextView)findViewById(R.id.textView7);
        tv2=(TextView)findViewById(R.id.textView9);
        tv3=(TextView)findViewById(R.id.textView10);
        tv4=(TextView)findViewById(R.id.textView11);
        tv5=(TextView)findViewById(R.id.textView12);
        btn=(Button)findViewById(R.id.button6);
        Intent in=getIntent();
        emailid=in.getStringExtra("values2");
        password=in.getStringExtra("values3");
        name=in.getStringExtra("values1");
        city=in.getStringExtra("values4");
        mobno=in.getStringExtra("values5");
        SQLiteDatabase db=openOrCreateDatabase("homefilescenter",MODE_APPEND,null);
        Cursor c=db.rawQuery("select * from register",null);
        while(c.moveToNext())
        {
            g1=c.getString(0);
            g2=c.getString(1);
            g3=c.getString(2);
            g4=c.getString(3);
            g5=c.getString(4);
        }
        if((emailid!=null&&password!=null) && (name!=null&&city!=null)) {
            tv1.setText("EMAILID:" +emailid);
            tv2.append("PASSWORD:" +password);
            tv3.append("FULLNAME:" +name);
            tv4.append("CITY:" +city);
            tv5.append("MOB-NO:" +mobno); }
        else if((g1!=null&&g2!=null) && (g3!=null&&g4!=null)) {
            tv1.setText("EMAILID:" +g1);
            tv2.append("PASSWORD:" +g2);
            tv3.append("FULLNAME:" +g3);
            tv4.append("CITY:" +g4);
            tv5.append("MOB-NO:" +g5);
        }



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data=new Intent();


                data.putExtra("fullname",name);
                setResult(98,data);

                finish();
            }
        });

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();



            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    protected void exitByBackKey()  {



        finish();

    }




}

