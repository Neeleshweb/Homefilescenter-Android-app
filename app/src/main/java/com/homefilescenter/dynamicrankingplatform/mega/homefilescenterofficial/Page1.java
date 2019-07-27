package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial.myjavaclasses.Scorescollection;

public class Page1 extends AppCompatActivity {
    RadioGroup rg;
    TextView tv1;
    Button btn;
    int value,value1,value2,value3;
    Boolean clicked=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        rg=(RadioGroup)findViewById(R.id.r1);
        tv1=(TextView)findViewById(R.id.textView34);
        btn=(Button)findViewById(R.id.button11);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked=true;


                int ids = rg.getCheckedRadioButtonId();
                switch (ids) {
                    case R.id.radioButton :
                        value = 1;


                        Scorescollection num = new Scorescollection();



                        Intent send = new Intent(Page1.this,Page2.class);
                        send.putExtra("val1",num.calculatescore1(value));

                        startActivity(send);
                        finish();
                        break;
                    case R.id.radioButton2 :
                        int  value=0;

                        Scorescollection num4=new Scorescollection();


                        Intent send1=new Intent(Page1.this,Page2.class);
                        send1.putExtra("val1",num4.calculatescore1(value));
                        startActivity(send1);
                        finish();
                        break ;
                    case R.id.radioButton3 :
                        value=0;

                        Scorescollection num2=new Scorescollection();


                        Intent send2=new Intent(Page1.this,Page2.class);
                        send2.putExtra("val1",num2.calculatescore1(value));
                        startActivity(send2);
                        finish();
                        break ;
                    case R.id.radioButton4 :
                        value=0;

                        Scorescollection num6=new Scorescollection();


                        Intent send8=new Intent(Page1.this,Page2.class);
                        send8.putExtra("val1",num6.calculatescore1(value));
                        startActivity(send8);
                        finish();
                        break ;


                }


            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(R.id.radioButton==checkedId) {
                    value=1;




                }
                else if(R.id.radioButton2==checkedId) {
                    value1=0;

                }
                else if(R.id.radioButton3==checkedId) {
                    value2=0;

                }
                else if(R.id.radioButton4==checkedId) {
                    value3=0;


                }
            }
        });


        Thread timer=new Thread() {
            public void run() {
                try {
                    sleep(300000);
                } catch(Exception ee) {
                    ee.printStackTrace();
                } finally {
                    if(clicked) {

                    }
                    else {
                        Intent bol=new Intent(Page1.this,Times.class);

                        int v=0;

                        bol.putExtra("thread",v);

                        startActivity(bol);
                        finish();

                    } }
            }
        };
        timer.start();

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            exitByBackKey();


            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    protected void exitByBackKey() {

        AlertDialog.Builder make = new AlertDialog.Builder(Page1.this);
        make.setTitle("SORRY !!");
        make.setMessage("You cannot go back once you have started the process,please do not waste your time,you have few mins left hurry");
        make.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        AlertDialog alert = make.create();
        alert.show();
    } }

