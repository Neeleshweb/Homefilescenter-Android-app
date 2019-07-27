package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    AutoCompleteTextView act;
    EditText et1,et2,et3,et4 ;
    Button btn4;
    TextView txt;
    String message,a;
    String s1,s2,s3,s4,s5;
    Boolean flag ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        act=(AutoCompleteTextView)findViewById(R.id.email1);
        txt=(TextView)findViewById(R.id.create);
        et1=(EditText)findViewById(R.id.password1);
        et2=(EditText)findViewById(R.id.fullname);
        et3=(EditText)findViewById(R.id.city);
        et4=(EditText)findViewById(R.id.Mobno);
        btn4=(Button)findViewById(R.id.email_sign_in_button);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                flag = verify();
                if (flag) {

                    SQLiteDatabase database = openOrCreateDatabase("homefilescenter", MODE_APPEND, null);
                    database.execSQL("create table if not exists register(email varchar,password password,fullname varchar,city varchar,Mobno varchar)");
                    SharedPreferences s11 = getSharedPreferences("file2", 0);
                    String s8 = s11.getString("z", "not declared");
                    if (s8.equals("not declared")) {
                        database.execSQL("insert into register(email,password,fullname,city,Mobno) values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "')");
                        Toast.makeText(Signup.this, "CONGRATS YOUR DATA HAS BEEN ADDED SUCCESSFULLY", Toast.LENGTH_LONG).show();

                        Cursor curse = database.rawQuery("select * from register", null);

                        while (curse.moveToNext()) {
                            a = curse.getString(2);
                            Log.d("TESTING", "*********************1:" + a);
                        }

                        message = "Thank You for registering with us,Kindly put the valid credentials to login to your account";
                        Intent inte = new Intent(Signup.this, Login.class);

                        inte.putExtra("value2", message);


                        database.close();

                        startActivity(inte);
                        finish();
                    } else {
                        SharedPreferences.Editor edit = s11.edit();
                        edit.putString("z", "initialized");
                        edit.commit();
                        database.close();

                        Intent inte = new Intent(Signup.this, Login.class);
                        inte.putExtra("value2", message);

                        startActivity(inte);
                        finish();
                    }

                } else {
                    Toast.makeText(Signup.this, "TO PROCEED FORWARD,STOP SEEING THIS ERROR MESSAGE EVERYTIME,PROVIDE VALID DETAILS!!", Toast.LENGTH_LONG).show();

                }

            }


        });
    }



    public Boolean verify() {

        s1=act.getText().toString();
        s2=et1.getText().toString();
        s3=et2.getText().toString();
        s4=et3.getText().toString();
        s5=et4.getText().toString();
        if(s1.length()==0) {
            act.setError("emailid cannot be blank");
            return false ;
        }
        else if(!s1.endsWith("@gmail.com")) {
            act.setError("please provide a valid email id");
            return false ;
        }
        else if(s2.length()==0) {
            et1.setError("password is mandatory");
            return false ;
        }
        else if(s2.length()<8 || s2.length()>16) {
            et1.setError("password must be in between 8-16 characters long");
            return false ;
        }
        else if(s3.length()==0) {
            et2.setError("fullname is mandatory");
            return false ;
        }
        else if(s4.length()==0) {
            et3.setError("City name must be provided");
            return false ;
        }
        else if(s5.length()==0) {
            et4.setError("Mobile no is must");
            return false ;
        }
        else if(!s5.matches("[0-9]{10}")) {
            et4.setError("Mobile no must be numeric and of 10 digits");
            return false ;
        }
        else {
            return true ;
        }

    }



    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            exitByBackKey();


            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    protected void exitByBackKey() {
        Intent po=new Intent(Signup.this,Homepage.class);
        startActivity(po);
        finish();
    }
}




