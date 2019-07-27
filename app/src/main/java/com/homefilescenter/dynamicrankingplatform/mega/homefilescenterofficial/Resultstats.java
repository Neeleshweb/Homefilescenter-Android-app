package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial.myjavaclasses.Scorescollection;

public class Resultstats extends AppCompatActivity {
    Button btn;
    TextView txt;
    String name;
    int a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultstats);
        btn=(Button)findViewById(R.id.button14);
        txt=(TextView)findViewById(R.id.textView36);
        Intent in=getIntent();
        a=in.getIntExtra("val15",0);


        txt.setTextSize(28);
        txt.setTextColor(Color.GREEN);
        txt.setBackgroundResource(R.drawable.bgrect);
        txt.setText("YOU HAVE COMPLETED YOUR TEST SUCCESFULLY,TO VIEW SCORE CLICK BELOW:");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scorescollection num=new Scorescollection();
                int overall=num.grandtotal(a);

                if(overall>=10) {
                    AlertDialog.Builder make1=new AlertDialog.Builder(Resultstats.this);
                    make1.setTitle("RESULT STATUS");
                    make1.setMessage("CONGRATULATIONS YOUR SCORE IS" +overall +"WHICH IS GREATER THAN 10,SO YOU PASSED THE TEST,NOW YOU CAN ADD YOUR OWN CATEGORY");
                    make1.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent send=new Intent(Resultstats.this,Categoryform.class);
                            startActivity(send);
                            finish();
                        }
                    });
                    AlertDialog alert=make1.create();
                    alert.show();

                }
                else {
                    AlertDialog.Builder make=new AlertDialog.Builder(Resultstats.this);
                    make.setTitle("RESULT STATUS");
                    make.setMessage("SORRY YOUR SCORE IS" +overall +"WHICH IS LESS THAN 10,SO YOU FAILED THE TEST,YOU MUST GET ABOVE 10 TO ADD YOUR CATEGORY,BETTER LUCK NEXT TIME!!");
                    make.setNegativeButton("HOME", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SQLiteDatabase dt=openOrCreateDatabase("homefilescenter",MODE_APPEND,null);
                            Cursor c=dt.rawQuery("select * from register",null);
                            while(c.moveToNext()) {
                                name=c.getString(2);
                            }
                            Intent send=new Intent(Resultstats.this,Welcome.class);
                            send.putExtra("naam",name);
                            startActivity(send);
                            finish();
                        }
                    });
                    AlertDialog alert=make.create();
                    alert.show();

                }

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

        AlertDialog.Builder make = new AlertDialog.Builder(Resultstats.this);
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


