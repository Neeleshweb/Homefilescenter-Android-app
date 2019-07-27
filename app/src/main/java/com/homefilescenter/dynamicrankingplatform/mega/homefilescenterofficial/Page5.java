package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial.myjavaclasses.Scorescollection;

public class Page5 extends AppCompatActivity {
    RadioGroup rg;
    TextView tv1;
    Button btn;
    int value,value1,value2,value3;
    Boolean clicked=false;
    int a,b,sum;
    Intent get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);
        rg=(RadioGroup)findViewById(R.id.r5);
        tv1=(TextView)findViewById(R.id.page5);

        btn=(Button)findViewById(R.id.b5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked=true;
                int ids = rg.getCheckedRadioButtonId();
                switch (ids) {
                    case R.id.radioButton17 :

                        value3 = 0;


                        Scorescollection num = new Scorescollection();
                        get=getIntent();
                        a=get.getIntExtra("val4",0);
                        b=num.calculatescore1(value3);
                        sum=a+b;



                        Intent send = new Intent(Page5.this, Page6.class);
                        send.putExtra("val5",sum);

                        startActivity(send);
                        finish();
                        break;
                    case R.id.radioButton18 :

                        value3=0;

                        Scorescollection num4=new Scorescollection();
                        get=getIntent();
                        a=get.getIntExtra("val4",0);
                        b=num4.calculatescore1(value3);
                        sum=a+b;



                        Intent send1=new Intent(Page5.this,Page6.class);
                        send1.putExtra("val5",sum);
                        startActivity(send1);
                        finish();
                        break ;
                    case R.id.radioButton19 :

                        value3=0;

                        Scorescollection num2=new Scorescollection();
                        get=getIntent();
                        a=get.getIntExtra("val4",0);
                        b=num2.calculatescore1(value3);
                        sum=a+b;



                        Intent send2=new Intent(Page5.this,Page6.class);
                        send2.putExtra("val5",sum);
                        startActivity(send2);
                        finish();
                        break ;
                    case R.id.radioButton20 :

                        value3=1;

                        Scorescollection num6=new Scorescollection();
                        get=getIntent();
                        a=get.getIntExtra("val4",0);
                        b=num6.calculatescore1(value3);
                        sum=a+b;



                        Intent send8=new Intent(Page5.this,Page6.class);
                        send8.putExtra("val5",sum);
                        startActivity(send8);
                        finish();
                        break ;


                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(R.id.radioButton17==checkedId) {
                    value=0;



                }
                else if(R.id.radioButton18==checkedId) {
                    value1=0;

                }
                else if(R.id.radioButton19==checkedId) {
                    value2=0;

                }
                else if(R.id.radioButton20==checkedId) {
                    value3=1;


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

        AlertDialog.Builder make = new AlertDialog.Builder(Page5.this);
        make.setTitle("SORRY !!");
        make.setMessage("You cannot go back once you have started the process,please do not waste your time,you have few mins left hurry");
        make.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        AlertDialog alert = make.create();
        alert.show();

    }

}

