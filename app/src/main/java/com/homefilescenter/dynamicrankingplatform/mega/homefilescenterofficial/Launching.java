package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Launching extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launching);
        Thread timer=new Thread() {
            public void run() {
                try {

                    sleep(5000);


                }
                catch(Exception ee) {
                    ee.printStackTrace();
                }
                finally {

                    Intent bol=new Intent(Launching.this,Homepage.class);
                    startActivity(bol);

                    finish();

                }
            }
        };
        timer.start();

    }
}

