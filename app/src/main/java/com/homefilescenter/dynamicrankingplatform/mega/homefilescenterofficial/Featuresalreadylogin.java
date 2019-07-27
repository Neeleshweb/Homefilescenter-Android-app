package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class Featuresalreadylogin extends AppCompatActivity {

    Button btn2,btn3 ;
    String name,dis ;
    String p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featuresalreadylogin);
        btn2=(Button)findViewById(R.id.button15);
        btn3=(Button)findViewById(R.id.button16);
        Intent get=getIntent();
        p=get.getStringExtra("values1");



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder make3 = new AlertDialog.Builder(Featuresalreadylogin.this);
                make3.setTitle("CONFIRMATION!!");
                make3.setMessage("If you proceed with this step,you cannot go back in between,are you sure you want to continue??");
                make3.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent n1=new Intent(Featuresalreadylogin.this,Customcategorydesc.class);
                        n1.putExtra("value2",p);
                        startActivity(n1);
                        finish();
                    }
                });
                make3.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SQLiteDatabase mydata=openOrCreateDatabase("homefilescenter",MODE_APPEND,null);
                        Cursor mycur=mydata.rawQuery("select * from register",null);
                        while(mycur.moveToNext()) {
                            name=mycur.getString(2);
                        }
                        Intent go=new Intent(Featuresalreadylogin.this,Welcome.class);
                        go.putExtra("lo",name);
                        startActivity(go);

                        finish();

                    }
                });
                AlertDialog alert = make3.create();
                alert.show();

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n2=new Intent(Featuresalreadylogin.this,Statistics.class);
                n2.putExtra("value2",p);
                startActivity(n2);
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

        SQLiteDatabase ds=openOrCreateDatabase("homefilescenter",MODE_APPEND,null);
        Cursor cb=ds.rawQuery("select * from register",null);
        while(cb.moveToNext()) {
            dis=cb.getString(2);
        }
        Intent myi=new Intent(Featuresalreadylogin.this,Welcome.class);
        myi.putExtra("awesome",dis);
        startActivity(myi);
        finish();
    } }



