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

public class Page15 extends AppCompatActivity {
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
        setContentView(R.layout.activity_page15);

        rg=(RadioGroup)findViewById(R.id.r15);
        tv1=(TextView)findViewById(R.id.page15);
        btn=(Button)findViewById(R.id.b15);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked=true;
                int ids = rg.getCheckedRadioButtonId();
                switch (ids) {
                    case R.id.radioButton57 :

                        value2 = 0;



                        Scorescollection num = new Scorescollection();
                        get=getIntent();
                        a=get.getIntExtra("val14",0);
                        b=num.calculatescore1(value2);
                        sum=a+b;




                        Intent send = new Intent(Page15.this, Resultstats.class);
                        send.putExtra("val15",sum);
                        startActivity(send);
                        finish();
                        break;
                    case R.id.radioButton58 :

                        value2=0;


                        Scorescollection num4=new Scorescollection();
                        get=getIntent();
                        a=get.getIntExtra("val14",0);
                        b=num4.calculatescore1(value2);
                        sum=a+b;



                        Intent send1=new Intent(Page15.this,Resultstats.class);
                        send1.putExtra("val15",sum);

                        startActivity(send1);
                        finish();
                        break ;
                    case R.id.radioButton59 :

                        value2=1;


                        Scorescollection num2=new Scorescollection();
                        get=getIntent();
                        a=get.getIntExtra("val14",0);
                        b=num2.calculatescore1(value2);
                        sum=a+b;


                        Intent send2=new Intent(Page15.this,Resultstats.class);
                        send2.putExtra("val15",sum);
                        startActivity(send2);
                        finish();
                        break ;
                    case R.id.radioButton60 :

                        value2=0;


                        Scorescollection num6=new Scorescollection();
                        get=getIntent();
                        a=get.getIntExtra("val14",0);
                        b=num6.calculatescore1(value2);
                        sum=a+b;


                        Intent send8=new Intent(Page15.this,Resultstats.class);
                        send8.putExtra("val15",sum);
                        startActivity(send8);
                        finish();
                        break ;


                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(R.id.radioButton57==checkedId) {
                    value=0;



                }
                else if(R.id.radioButton58==checkedId) {
                    value1=0;

                }
                else if(R.id.radioButton59==checkedId) {
                    value2=1;

                }
                else if(R.id.radioButton60==checkedId) {
                    value3=0;


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

        AlertDialog.Builder make = new AlertDialog.Builder(Page15.this);
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


