package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Contactus extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4;
    Button bt1,bt2,bt3,bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        tv1=(TextView)findViewById(R.id.contact1);
        bt1=(Button)findViewById(R.id.contact4);
        tv2=(TextView)findViewById(R.id.contact2);
        tv3=(TextView)findViewById(R.id.contact3);
        tv4=(TextView)findViewById(R.id.contact7);
        bt2=(Button)findViewById(R.id.contact5);
        bt3=(Button)findViewById(R.id.contact6);
        bt4=(Button)findViewById(R.id.contact8);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/profile/preview?locale=en_US&trk=prof-0-sb-preview-primary-button"));
                startActivity(browserIntent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/neeleshweb/"));
                startActivity(browserIntent);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.smule.com/Neelesh_Java_pro"));
                startActivity(browserIntent);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCTDNnGpJYA4xYwsjI23d_AQ"));
                startActivity(browserIntent);
            }
        });

    }
}
