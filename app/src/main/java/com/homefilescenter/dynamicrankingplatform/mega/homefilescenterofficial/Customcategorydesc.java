package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Customcategorydesc extends AppCompatActivity {
    String s1;
    Button btn;
    TextView tv0,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customcategorydesc);
        btn = (Button) findViewById(R.id.test50);
        tv0 = (TextView) findViewById(R.id.textView26);
        tv2 = (TextView) findViewById(R.id.textView27);
        tv3 = (TextView) findViewById(R.id.textView28);
        tv4 = (TextView) findViewById(R.id.textView29);
        tv5 = (TextView) findViewById(R.id.textView30);
        tv6 = (TextView) findViewById(R.id.textView31);
        tv7 = (TextView) findViewById(R.id.textView32);
        tv8 = (TextView) findViewById(R.id.textView33);
        Intent in = getIntent();
        s1 = in.getStringExtra("value2");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ing = new Intent(Customcategorydesc.this, Page1.class);
                ing.putExtra("emailid", s1);
                startActivity(ing);
                finish();
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

        AlertDialog.Builder make = new AlertDialog.Builder(Customcategorydesc.this);
        make.setTitle("SORRY !!");
        make.setMessage("You cannot go back once you have started the process,as we have informed you earlier");
        make.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        AlertDialog alert = make.create();
        alert.show();




    } }
