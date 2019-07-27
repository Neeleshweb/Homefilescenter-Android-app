package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class Login extends AppCompatActivity {
    AutoCompleteTextView tv1, tv3;
    EditText et1;
    LoginButton login_button;
    CallbackManager callbackManager ;
    Button btn4;
    TextView tv2;
    String a, b, c, d, e, f, g, h;
    boolean Islogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_login);


        tv1 = (AutoCompleteTextView) findViewById(R.id.email);
        tv3 = (AutoCompleteTextView) findViewById(R.id.password);
        btn4 = (Button) findViewById(R.id.button5);

        tv2 = (TextView) findViewById(R.id.wolf);


        Intent num = getIntent();
        String s = num.getStringExtra("message");

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = tv1.getText().toString();
                d = tv3.getText().toString();


                if (c.length() == 0) {
                    tv1.setError("Email id cannot be blank");
                } else if (!c.endsWith("@gmail.com")) {
                    tv1.setError("Emailid you entered is not valid,please enter a valid email id");
                } else if (d.length() == 0) {
                    tv3.setError("password is mandatory ");
                } else if (d.length() < 8 || d.length() > 16) {
                    tv3.setError("password  must be in between 8-16 characters long");
                }


                SQLiteDatabase db = openOrCreateDatabase("homefilescenter", MODE_APPEND, null);
                SharedPreferences s11 = getSharedPreferences("file2", 0);
                String s8 = s11.getString("z", "not declared");
                if (s8.equals("not declared")) {

                    Cursor cur = db.rawQuery("select * from register", null);
                    while (cur.moveToNext()) {
                        a = cur.getString(0);
                        b = cur.getString(1);
                        e = cur.getString(2);
                        f = cur.getString(3);

                        g = cur.getString(4);


                    }
                    if (a != null || b != null) {
                        if (a.equals(c) && b.equals(d)) {
                            Intent in = new Intent(Login.this, Welcome.class);
                            in.putExtra("val", e);
                            in.putExtra("val1", a);
                            in.putExtra("val2", b);
                            in.putExtra("val3", f);
                            in.putExtra("val4", g);
                            db.close();
                            startActivity(in);
                            finish();
                        } else if (!a.equals(c) || !b.equals(d)) {

                            AlertDialog.Builder make1 = new AlertDialog.Builder(Login.this);
                            make1.setTitle("ACCOUNT VERIFICATION FAILED!");
                            make1.setMessage("The username or password you entered does not match our database,check and try again");
                            make1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent send = new Intent(Login.this, Login.class);
                                    startActivity(send);
                                    finish();
                                }
                            });
                            AlertDialog alert = make1.create();
                            alert.show();

                        }
                    } else {
                        AlertDialog.Builder make2 = new AlertDialog.Builder(Login.this);
                        make2.setTitle("NEW USER!!");
                        make2.setMessage("It seems like you are a new user of our app as your details are not existing,kindly sign in first and then try again");
                        make2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent send = new Intent(Login.this, Login.class);
                                startActivity(send);
                                finish();
                            }
                        });
                        AlertDialog alert = make2.create();
                        alert.show();
                    }

                } else {
                    SharedPreferences.Editor edit = s11.edit();
                    edit.putString("z", "initialized");
                    edit.apply();
                    db.close();
                    Intent inte = new Intent(Login.this, Welcome.class);
                    inte.putExtra("val", e);
                    Toast.makeText(Login.this, "YOUR DATA IS ALREADY ADDED", Toast.LENGTH_LONG).show();
                    startActivity(inte);
                    finish();
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
        Intent po=new Intent(Login.this,Homepage.class);
        startActivity(po);
        finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}



