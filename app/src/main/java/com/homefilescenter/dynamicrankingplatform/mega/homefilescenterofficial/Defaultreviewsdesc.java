package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class Defaultreviewsdesc extends AppCompatActivity {
    Button btn;
    TextView tv19, tv20, tv21;
    ScrollView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defaultreviewsdesc);
        tv19 = (TextView) findViewById(R.id.textView19);
        tv20 = (TextView) findViewById(R.id.textView20);
        tv21 = (TextView) findViewById(R.id.textView21);
        sv = (ScrollView) findViewById(R.id.scrollView0);
        btn = (Button) findViewById(R.id.button17);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent num = new Intent(Defaultreviewsdesc.this, Defaultreviews.class);

                startActivity(num);
                finish();
            }
        }); }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            exitByBackKey();


            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    protected void exitByBackKey() {

        AlertDialog.Builder make = new AlertDialog.Builder(Defaultreviewsdesc.this);
        make.setTitle("SORRY !!");
        make.setMessage("You cannot go back once you have started the process,as we have informed you earlier");
        make.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        AlertDialog alert = make.create();
        alert.show();
    }
}


