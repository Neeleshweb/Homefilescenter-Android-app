package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial.myjavaclasses.Scorescollection;

public class Times extends AppCompatActivity {
    TextView txt;
    Button btn;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times);
        txt=(TextView)findViewById(R.id.textView37);
        btn=(Button)findViewById(R.id.button18);

        txt.setTextSize(28);
        txt.setTextColor(Color.GREEN);
        txt.setText("OOPS,YOU HAVE EXCEEDED THE MAXIMUM ALLOTED TIME OF THE TEST WHICH WAS 5 MINUTES,PLEASE TRY AGAIN:");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = getIntent();


                AlertDialog.Builder make1 = new AlertDialog.Builder(Times.this);
                make1.setTitle("RESULT STATUS");
                make1.setMessage("DUE TO TIMEOUT YOUR SCORE IS" + i.getIntExtra("thread", 0) + "YOU MUST ATTEMPT ALL QUESTIONS WITHIN 5 MINUTES,IF TIME EXPIRES YOUR SCORE WILL BE ZERO NO MATTER HOW MANY QUESTIONS YOU HAVE DONE TILL THAT TIME!!");
                make1.setPositiveButton("HOME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SQLiteDatabase dt=openOrCreateDatabase("homefilescenter",MODE_APPEND,null);
                        Cursor c=dt.rawQuery("select * from register",null);
                        while(c.moveToNext()) {
                            name=c.getString(2);
                        }
                        Intent send2=new Intent(Times.this,Welcome.class);
                        send2.putExtra("timeup",name);

                        startActivity(send2);
                        finish();
                    }
                });
                AlertDialog alert = make1.create();
                alert.show();

            }
        });

    }
}

