package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Feedback extends AppCompatActivity {
    TextView txt;
    EditText ed;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        txt=(TextView)findViewById(R.id.tt);
        ed=(EditText)findViewById(R.id.edit);
        bt=(Button)findViewById(R.id.boss);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1=ed.getText().toString();
                if(value1.length()==0) {

                    Viewdialog alert = new Viewdialog();
                    alert.showDialog(Feedback.this, "Empty feedback is not valid, please provide some valid and useful suggestions !");


                } else {
                    Viewdialog alert = new Viewdialog();
                    alert.showDialog(Feedback.this, "Congratulations your feedback has been processed and will be recieved by us soon, thank you for your valuable suggestions.");


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

        Intent gonow=new Intent(Feedback.this,Homepage.class);
        startActivity(gonow);
        finish();
    } }


