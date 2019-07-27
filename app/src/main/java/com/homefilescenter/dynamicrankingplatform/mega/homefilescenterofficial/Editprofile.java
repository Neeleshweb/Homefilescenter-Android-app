package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.ByteArrayOutputStream;

public class Editprofile extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5 ;
    Button btn2 ;
    String emailid,fullname,mobno,cityin,passwords ;
    String s1,s2,s3,s4,s5;
    String data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        ed1=(EditText)findViewById(R.id.editText3);
        ed2=(EditText)findViewById(R.id.editText4);
        ed3=(EditText)findViewById(R.id.editText5);
        ed4=(EditText)findViewById(R.id.editText6);
        ed5=(EditText)findViewById(R.id.editText7);

        btn2=(Button)findViewById(R.id.button8);
        Intent intent=getIntent();
        fullname=intent.getStringExtra("values1");
        emailid=intent.getStringExtra("values2");
        passwords=intent.getStringExtra("values3");
        cityin=intent.getStringExtra("values4");
        mobno=intent.getStringExtra("values5");



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=ed1.getText().toString();
                s2=ed2.getText().toString();
                s3=ed3.getText().toString();
                s4=ed4.getText().toString();
                s5=ed5.getText().toString();
                SQLiteDatabase dat=openOrCreateDatabase("homefilescenter",MODE_PRIVATE,null);
                dat.execSQL("update register set email='"+s1+"' where email='"+emailid+"' ");
                dat.execSQL("update register set password='"+s2+"' where password='"+passwords+"' ");
                dat.execSQL("update register set fullname='"+s3+"' where fullname='"+fullname+"' ");
                dat.execSQL("update register set city='"+s4+"' where city='"+cityin+"' ");
                dat.execSQL("update register set Mobno='"+s5+"' where Mobno='"+mobno+"' ");
                Toast.makeText(Editprofile.this,"ACCOUNT UPDATED SUCCESSFULLY,PLEASE LOGOUT AND LOGIN WITH UPDATED ID",Toast.LENGTH_LONG).show();
                SharedPreferences s11 = getSharedPreferences("file2", 0);
                String s8 = s11.getString("z", "not declared");
                if (s8.equals("not declared")) {
                    Cursor curly=dat.rawQuery("select * from register",null);
                    while(curly.moveToNext()) {
                        data1=curly.getString(2);
                    }
                    Intent data=new Intent();
                    data.putExtra("name",data1);
                    setResult(97,data);
                    dat.close();
                    finish();


                }
                else {
                    SharedPreferences.Editor edit = s11.edit();
                    edit.putString("z", "initialized");
                    edit.commit();
                    dat.close();
                    Intent data=new Intent();
                    data.putExtra("name",data1);
                    setResult(97,data);
                    dat.close();
                    finish();
                }
            }
        });
    }


}





