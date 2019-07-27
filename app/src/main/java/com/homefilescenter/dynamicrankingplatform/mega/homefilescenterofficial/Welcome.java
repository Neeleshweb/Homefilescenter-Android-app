package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class Welcome extends AppCompatActivity {
    TextView tv1;
    HorizontalScrollView hv,hv7;
    String display,display2,display3,display4,display5,display6,display7,s1,s2,s3,s4;
    String name;

    ScrollView sv;
    Button btn,btn1 ;
    TableLayout tl;
    TableRow tr7;
    TableLayout tl7;
    TableRow tr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tv1=(TextView)findViewById(R.id.textView2);

Intent fb=getIntent();
        System.out.println(fb.getStringExtra("accesstoken"));
        sv=(ScrollView)findViewById(R.id.scrollView2);
        btn=(Button)findViewById(R.id.butt);
        btn1=(Button)findViewById(R.id.butt0);
        tl7=(TableLayout)findViewById(R.id.tableLayout7);
        hv7=(HorizontalScrollView)findViewById(R.id.horizontalscrollview7);
        tr7=new TableRow(Welcome.this);
        TextView view1=new TextView(this);
        view1.setTextColor(Color.BLACK);

        view1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24);
        view1.setText(" |*PRODUCT-NAME*| ");
        TextView view2=new TextView(this);
        view2.setTextColor(Color.BLACK);
        view2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24);
        view2.setText(" |*PRODUCT REVIEW POSTED*|");

        TextView view3=new TextView(this);
        view3.setTextColor(Color.BLACK);
        view3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24);
        view3.setText("  |*STARS GIVEN BY USER*| ");

        TextView view4=new TextView(this);
        view4.setTextColor(Color.BLACK);
        view4.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24);
        view4.setText(" |*USERS EMAIL-ID*| ");
        tr7.addView(view1);
        tr7.addView(view2);
        tr7.addView(view3);
        tr7.addView(view4);
        tl7.addView(tr7);
        Intent i=getIntent();
        display=i.getStringExtra("val");
        display2=i.getStringExtra("intent5");
        display3=i.getStringExtra("naam");
        display4=i.getStringExtra("abcd");
        display5=i.getStringExtra("timeup");
        display6=i.getStringExtra("lo");
        display7=i.getStringExtra("awesome");
        tv1.setTextColor(Color.BLACK);
        if(display!=null) {
            tv1.setText("Welcome to Homefilescenter Official™  " + display);
        }
        else if(display2!=null) {
            tv1.setText("Welcome to Homefilescenter Official™  " + display2);
        }
        else if(display3!=null) {
            tv1.setText("Welcome to Homefilescenter Official™  " + display3);
        }
        else if(display4!=null) {
            tv1.setText("Welcome to Homefilescenter Official™  " + display4);
        }
        else if(display5!=null) {
            tv1.setText("Welcome to Homefilescenter Official™  " + display5);
        }
        else if(display6!=null) {
            tv1.setText("Welcome to Homefilescenter Official™  " + display6);
        }
        else if(display7!=null) {
            tv1.setText("Welcome to Homefilescenter Official™  " + display7);
        }

        s1=i.getStringExtra("val1");
        s2=i.getStringExtra("val2");
        s3=i.getStringExtra("val3");
        s4=i.getStringExtra("val4");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder make3 = new AlertDialog.Builder(Welcome.this);
                make3.setTitle("CONFIRMATION!!");
                make3.setMessage("If you proceed with this step,you cannot go back in between,are you sure you want to continue??");
                make3.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent num=new Intent(Welcome.this,Defaultreviewsdesc.class);

                        startActivity(num);
                        finish();
                    }
                });
                make3.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });
                AlertDialog alert = make3.create();
                alert.show();

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            Boolean flag=true;
            @Override
            public void onClick(View v) {
                if(flag) {
                    tl=(TableLayout)findViewById(R.id.tableLayout1);
                    hv=(HorizontalScrollView)findViewById(R.id.horizontalscrollview);


                    SQLiteDatabase data=openOrCreateDatabase("homefilescenter",MODE_APPEND,null);

                    Cursor cur=data.rawQuery("select * from reviews",null);
                    while(cur.moveToNext()) {

                        String prodname=cur.getString(0);
                        String reviewdesc=cur.getString(1);
                        float stars=cur.getFloat(2);


                        String emails=cur.getString(3);
                        if((prodname!=null && reviewdesc!=null)&&(emails!=null)) {
                            tr=new TableRow(Welcome.this);
                            TextView t1=new TextView(Welcome.this);
                            t1.setTextColor(Color.WHITE);
                            t1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24);
                            t1.setText(prodname);
                            TextView t2=new TextView(Welcome.this);
                            t2.setTextColor(Color.WHITE);
                            t2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24);

                            t2.setText(reviewdesc);
                            TextView t3=new TextView(Welcome.this);
                            t3.setTextColor(Color.WHITE);
                            t3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24);
                            t3.setText("" +stars);
                            TextView t4=new TextView(Welcome.this);
                            t4.setTextColor(Color.WHITE);
                            t4.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24);

                            t4.setText(emails);


                            tr.addView(t1);


                            tr.addView(t2);


                            tr.addView(t3);


                            tr.addView(t4);

                            tl.addView(tr);

                            data.close();


                        } else {
                            AlertDialog.Builder make2 = new AlertDialog.Builder(Welcome.this);
                            make2.setTitle("NEW USER!!");
                            make2.setMessage("It seems like you are a new user of our app as you have not given review to any category,neither default nor custom,you can do it now,you can give review to default or custom,choose any one from below:");
                            make2.setPositiveButton("CUSTOM", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent send = new Intent(Welcome.this,Customcategorydesc.class);
                                    startActivity(send);
                                    finish();
                                }
                            });
                            make2.setNegativeButton("DEFAULT", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent send = new Intent(Welcome.this,Defaultreviewsdesc.class);
                                    startActivity(send);
                                    finish();
                                }
                            });
                            AlertDialog alert = make2.create();
                            alert.show();
                        }
                        flag=false;
                    } } }




        });

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();



            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    protected void exitByBackKey()  {

        AlertDialog.Builder make=new AlertDialog.Builder(Welcome.this);
        make.setTitle("LOGOUT CONFIRMATION");
        make.setMessage("Are you sure you want to logout,any unsaved data will be lost??");
        make.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent newact=new Intent(Welcome.this,Homepage.class);
                startActivity(newact);
                SharedPreferences num=getSharedPreferences("file2",MODE_PRIVATE);
                SharedPreferences.Editor edit = num.edit();
                edit.clear();
                edit.apply();
                finish();

            }
        });
        make.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert=make.create();
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.welcome,menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK&&requestCode==56) {
            String result = data.getStringExtra("fullname");
            tv1.setText("WELCOME TO HOMEFILESCENTER OFFICIAL APP" + result);
        }
        else if(resultCode==RESULT_OK&&requestCode==55) {
            String result2 = data.getStringExtra("name");
            tv1.setText("WELCOME TO HOMEFILESCENTER OFFICIAL APP" + result2);
        }



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings9) {

            Intent inte=new Intent(Welcome.this,Settings.class);
            startActivity(inte);
            return true;
        }
        else if(id==R.id.action_settings11) {

            Intent data=new Intent(Welcome.this,Viewprofile.class);
            data.putExtra("values1",display);
            data.putExtra("values2",s1);
            data.putExtra("values3",s2);
            data.putExtra("values4",s3);
            data.putExtra("values5",s4);
            startActivityForResult(data,56);

            return true;

        }
        else if(id==R.id.action_settings10) {

            Intent in1=new Intent(Welcome.this,Editprofile.class);
            in1.putExtra("values1",display);
            in1.putExtra("values2",s1);
            in1.putExtra("values3",s2);
            in1.putExtra("values4",s3);
            in1.putExtra("values5",s4);
            startActivityForResult(in1,55);
            return true;
        }
        else if(id==R.id.action_settings13) {

            Intent is=new Intent(Welcome.this,Aboutus.class);
            startActivity(is);
            return true;
        }

        else if(id==R.id.notify) {

            sendnotification();



            return true;
        }

        else if(id==R.id.action_settings8) {
            Intent is2=new Intent(Welcome.this,Featuresalreadylogin.class);
            is2.putExtra("values1",s1);
            startActivity(is2);
            finish();
            return true;
        }

        else if(id==R.id.action_settings7) {
            AlertDialog.Builder make=new AlertDialog.Builder(Welcome.this);
            make.setTitle("LOGOUT CONFIRMATION");
            make.setMessage("Are you sure you want to logout,any unsaved data will be lost??");
            make.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences num=getSharedPreferences("file2",MODE_PRIVATE);
                    SharedPreferences.Editor edit = num.edit();
                    edit.clear();
                    edit.apply();
                    Intent i=new Intent(Welcome.this,Homepage.class);
                    startActivity(i);
                    finish();

                }
            });
            make.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog alert=make.create();
            alert.show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void sendnotification() {
        Intent num=getIntent();
        String prod=num.getStringExtra("intent1");
        String reviews=num.getStringExtra("intent2");
        float rate=num.getFloatExtra("intent3",0);
        String emailid=num.getStringExtra("intent4");

        if(prod!=null && emailid!=null) {
            Intent intel=new Intent(Welcome.this,Notificationaction.class);
            intel.putExtra("prodname",prod);
            intel.putExtra("review",reviews);
            intel.putExtra("rates",rate);
            intel.putExtra("emails",emailid);

            startActivity(intel);
        }
        else {
            Toast.makeText(Welcome.this,"There is no recent notification,come back and check again after sometime",Toast.LENGTH_LONG).show();
        }





    }

}


