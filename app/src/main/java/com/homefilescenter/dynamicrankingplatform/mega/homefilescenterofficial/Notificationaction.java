package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Notificationaction extends AppCompatActivity implements View.OnClickListener {
    Button start, clear;

    NotificationManager nmgr;
    NotificationCompat.Builder builder;
    Notification noti ;
    String s1,s2,s4 ;
    float s3;
    public static final int NOTIFICATION_ID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificationaction);
        Intent get=getIntent();
        s1=get.getStringExtra("prodname");
        s2=get.getStringExtra("review");
        s3=get.getFloatExtra("rates",0);
        s4=get.getStringExtra("emails");
        setlistener();
        nmgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        Intent in=new Intent(this,Notificationresult.class);
        in.putExtra("prods",s1);
        in.putExtra("rev",s2);
        in.putExtra("rat",s3);
        in.putExtra("email",s4);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, in, 0);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        noti = new Notification.Builder(this)
                .setContentTitle("NOTIFICATION FROM HOMEFILESCENTER")
                .setContentText("READ NOW")
                .setSmallIcon(R.drawable.notify2)
                .setContentIntent(pIntent)
                .setSound(alarmSound)


                .build();



    }
    public void setlistener() {
        start=(Button)findViewById(R.id.start);
        clear=(Button)findViewById(R.id.clear);
        if(s1!=null && s4!=null){
            Boolean flag=true;
            if(flag) {
                start.setOnClickListener(this);
            } else{
                Toast.makeText(this,"NO NEW NOTIFICATIONS",Toast.LENGTH_LONG).show();
            }
        } else {
            clear.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start :
                nmgr.notify(NOTIFICATION_ID,noti);
                break;
            case R.id.clear :
                nmgr.cancel(NOTIFICATION_ID);
        }
    }


}


