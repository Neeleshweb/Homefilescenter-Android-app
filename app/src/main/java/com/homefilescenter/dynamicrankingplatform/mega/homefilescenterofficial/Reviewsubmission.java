package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Reviewsubmission extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4,tv5,ed1;
    EditText  ed2, ed3;
    ScrollView sv;
    RatingBar rb;
    Button btn;
    Boolean flag;
    String s1, s2, s3;
    String prodname,reviewdesc,email,fullnames ;
    float ratings ;
    float s4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewsubmission);
        sv = (ScrollView) findViewById(R.id.scrollView);
        tv1 = (TextView) findViewById(R.id.textView22);
        tv2 = (TextView) findViewById(R.id.textView23);
        tv3 = (TextView) findViewById(R.id.textView24);
        tv4 = (TextView) findViewById(R.id.textView25);
        tv5 = (TextView) findViewById(R.id.textView01);
        ed1 = (TextView) findViewById(R.id.editText9);
        ed2 = (EditText) findViewById(R.id.editText10);
        ed3 = (EditText) findViewById(R.id.editText0);
        rb = (RatingBar) findViewById(R.id.ratingBar);
        Intent in=getIntent();

        String a=in.getStringExtra("value1");
        String b=in.getStringExtra("value2");
        String c=in.getStringExtra("value3");
        String d=in.getStringExtra("value4");
        String e=in.getStringExtra("value5");
        String f=in.getStringExtra("val0");
        String g=in.getStringExtra("val1");
        String h=in.getStringExtra("val2");
        String i=in.getStringExtra("v1");
        String j=in.getStringExtra("v2");
        String k=in.getStringExtra("v3");
        String l=in.getStringExtra("v4");
        String m=in.getStringExtra("v5");
        String n=in.getStringExtra("va1");
        String o=in.getStringExtra("va2");
        String p=in.getStringExtra("va3");
        String q=in.getStringExtra("va4");
        String r=in.getStringExtra("va5");
        String s=in.getStringExtra("values0");
        String t=in.getStringExtra("values1");
        String u=in.getStringExtra("get1");
        String v=in.getStringExtra("get2");
        String w=in.getStringExtra("one");
        String x=in.getStringExtra("two");
        String y=in.getStringExtra("three");
        String z=in.getStringExtra("four");
        String mynam=in.getStringExtra("five");
        ed1.setBackgroundResource(R.drawable.rect1);
        if(a!=null) {
            ed1.setText(a);
        }
        else if(b!=null) {
            ed1.setText(b);
        }
        else if(c!=null) {
            ed1.setText(c);
        }
        else if(d!=null) {
            ed1.setText(d);
        }
        else if(e!=null) {
            ed1.setText(e);
        }
        else if(f!=null) {
            ed1.setText(f);
        }
        else if(g!=null) {
            ed1.setText(g);
        }
        else if(h!=null) {
            ed1.setText(h);
        }
        else if(i!=null) {
            ed1.setText(i);
        }
        else if(j!=null) {
            ed1.setText(j);
        }
        else if(k!=null) {
            ed1.setText(k);
        }
        else if(l!=null) {
            ed1.setText(l);
        }
        else if(m!=null) {
            ed1.setText(m);
        }
        else if(n!=null) {
            ed1.setText(n);
        }
        else if(o!=null) {
            ed1.setText(o);
        }
        else if(p!=null) {
            ed1.setText(p);
        }
        else if(q!=null) {
            ed1.setText(q);
        }
        else if(r!=null) {
            ed1.setText(r);
        }
        else if(s!=null) {
            ed1.setText(s);
        }
        else if(t!=null) {
            ed1.setText(t);
        }
        else if(u!=null) {
            ed1.setText(u);
        }
        else if(v!=null) {
            ed1.setText(v);
        }
        else if(w!=null) {
            ed1.setText(w);
        }
        else if(x!=null) {
            ed1.setText(x);
        }
        else if(y!=null) {
            ed1.setText(y);
        }
        else if(z!=null) {
            ed1.setText(z);
        }
        else if(mynam!=null) {
            ed1.setText(mynam);
        }

        btn = (Button) findViewById(R.id.but);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = verify();
                if (flag) {
                    s1 = ed1.getText().toString();
                    s2 = ed2.getText().toString();
                    s3 = ed3.getText().toString();
                    s4 = rb.getRating();

                    SQLiteDatabase db = openOrCreateDatabase("homefilescenter", MODE_APPEND, null);
                    db.execSQL("create table if not exists reviews(product_name varchar,review_description varchar,stars int(6),email varchar)");
                    SharedPreferences s11 = getSharedPreferences("file2", 0);
                    String s8 = s11.getString("z", "not declared");
                    if (s8.equals("not declared")) {
                        db.execSQL("insert into reviews(product_name,review_description,stars,email)values('"+s1+"','" +s2+"','"+s4+"','"+s3+"')");
                        Toast.makeText(Reviewsubmission.this,"REVIEW SUBMITTED SUCCESSFULLY,NOW YOU CAN VIEW IT",Toast.LENGTH_LONG).show();
                        Cursor curse=db.rawQuery("select * from reviews",null);
                        while(curse.moveToNext()) {
                            prodname=curse.getString(0);
                            reviewdesc=curse.getString(1);
                            ratings=curse.getFloat(2);
                            email=curse.getString(3);
                        }


                        Cursor curse1=db.rawQuery("select * from register",null);
                        while(curse1.moveToNext()) {
                            fullnames=curse1.getString(2);
                        }
                        Intent intent=new Intent(Reviewsubmission.this,Welcome.class);
                        intent.putExtra("intent1",prodname);
                        intent.putExtra("intent2",reviewdesc);
                        intent.putExtra("intent3",ratings);
                        intent.putExtra("intent4",email);
                        intent.putExtra("intent5",fullnames);
                        startActivity(intent);

                        db.close();
                        finish();
                    } else {

                        SharedPreferences.Editor edit = s11.edit();
                        edit.putString("z", "initialized");
                        edit.commit();

                        Intent inte = new Intent(Reviewsubmission.this,Welcome.class);
                        inte.putExtra("intent1",prodname);
                        inte.putExtra("intent2",reviewdesc);
                        inte.putExtra("intent3",ratings);
                        inte.putExtra("intent4",email);
                        inte.putExtra("intent5",fullnames);
                        db.close();

                        startActivity(inte);
                        finish();
                    }
                }  else {
                    Toast.makeText(Reviewsubmission.this,"TO STOP SEEING THIS BOX,PLEASE PROVIDE VALID DETAILS ONLY",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public Boolean verify() {
        s1 = ed1.getText().toString();
        s2 = ed2.getText().toString();
        s3 = ed3.getText().toString();
        s4 = rb.getRating();
        if (s1.length() == 0) {
            ed1.setError("NAME OF PRODUCT YOU RATE IS MUST");
            return false;
        } else if (s2.length() == 0) {
            ed2.setError("YOU MUST GIVE REASON FOR YOUR REVIEW,CANNOT BE EMPTY");
            return false;
        } else if (s3.length() == 0) {
            ed3.setError("WE MUST KNOW WHO YOU ARE,SO WE NEED A VALID EMAIL-ID");
            return false;
        } else if (s4 < 1) {
            Toast.makeText(Reviewsubmission.this, "MINIMUM HALF STARS ARE MANDATORY,NOT SO BAD!!", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
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

        AlertDialog.Builder make = new AlertDialog.Builder(Reviewsubmission.this);
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


