package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Defaultreviews extends AppCompatActivity {
    Spinner sp1,sp2,sp3,sp4,sp5,sp6;


    TextView tv1;


    String spinner1[]={"LAPTOPS","MOBILES","EARPHONES","GRAPHICS CARD","MOUSE"};
    String spinner2[]={"PC GAMES","MOVIES","TV SERIES"};
    String spinner3[]={"NOVELS","MAGAZINES","HOLY BOOKS","JAVA","J2EE"};
    String spinner4[]={"LEE COOPER","INDIAN TERRAIN","LEVI'S","PETER ENGLAND","GUCCI"};

    String spinner5[]={"CARS","BIKES"};
    String spinner6[]={"WEBSITES","ANDROID APPS"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defaultreviews);
        sp1 = (Spinner) findViewById(R.id.spinner);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        sp3 = (Spinner) findViewById(R.id.spinner3);
        sp4 = (Spinner) findViewById(R.id.spinner4);
        sp5 = (Spinner) findViewById(R.id.spinner5);
        sp6 = (Spinner) findViewById(R.id.spinner6);
        tv1 = (TextView) findViewById(R.id.textView18);


        ArrayAdapter adapt1 = new ArrayAdapter(Defaultreviews.this, android.R.layout.simple_spinner_item, spinner1);
        adapt1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapt1);


        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            Boolean count = false;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("inside switch" + position);
                if (count) {


                    switch (position) {
                        case 0:
                            Intent int1 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String a = spinner1[0];
                            int1.putExtra("value1", a);
                            startActivity(int1);
                            finish();
                            break;
                        case 1:
                            Intent int2 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String b = spinner1[1];
                            int2.putExtra("value2", b);
                            startActivity(int2);
                            finish();
                            break;
                        case 2:
                            Intent int3 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String c = spinner1[2];
                            int3.putExtra("value3", c);
                            startActivity(int3);
                            finish();
                            break;
                        case 3:
                            Intent int4 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String d = spinner1[3];
                            int4.putExtra("value4", d);
                            startActivity(int4);
                            finish();
                            break;
                        case 4:
                            Intent int5 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String e = spinner1[4];
                            int5.putExtra("value5", e);
                            startActivity(int5);
                            finish();
                            break;
                    }

                } else {
                    count = true;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter adapt2 = new ArrayAdapter(Defaultreviews.this, android.R.layout.simple_spinner_item, spinner2);
        adapt2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapt2);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            Boolean count1 = false;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (count1) {

                    switch (position) {
                        case 0:
                            Intent in = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String f = spinner2[0];
                            in.putExtra("val0", f);

                            startActivity(in);
                            finish();
                            break;
                        case 1:
                            Intent in1 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String g = spinner2[1];
                            in1.putExtra("val1", g);
                            startActivity(in1);
                            finish();
                            break;
                        case 2:
                            Intent in2 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String h = spinner2[2];
                            in2.putExtra("val2", h);
                            startActivity(in2);
                            finish();
                            break;

                    }


                } else {
                    count1 = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        ArrayAdapter adapt3 = new ArrayAdapter(Defaultreviews.this, android.R.layout.simple_spinner_item, spinner3);
        adapt3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(adapt3);
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            Boolean count3 = false;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (count3) {

                    switch (position) {
                        case 0:
                            Intent i1 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String s1 = spinner3[0];
                            i1.putExtra("v1", s1);
                            startActivity(i1);
                            finish();
                            break;
                        case 1:
                            Intent i2 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String s2 = spinner3[1];
                            i2.putExtra("v2", s2);
                            startActivity(i2);
                            finish();
                            break;
                        case 2:
                            Intent i3 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String s3 = spinner3[2];
                            i3.putExtra("v3", s3);
                            startActivity(i3);
                            finish();
                            break;
                        case 3:
                            Intent i4 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String s4 = spinner3[3];
                            i4.putExtra("v4", s4);
                            startActivity(i4);
                            finish();
                            break;
                        case 4:
                            Intent i5 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String s5 = spinner3[4];
                            i5.putExtra("v5", s5);

                            startActivity(i5);
                            finish();
                            break;
                    }
                } else {
                    count3 = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter adapt4 = new ArrayAdapter(Defaultreviews.this, android.R.layout.simple_spinner_item, spinner4);
        adapt4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp4.setAdapter(adapt4);
        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            Boolean count4 = false;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (count4) {

                    switch (position) {
                        case 0:
                            Intent it1 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String x1 = spinner4[0];
                            it1.putExtra("va1", x1);
                            startActivity(it1);
                            finish();
                            break;
                        case 1:
                            Intent it2 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String x2 = spinner4[1];
                            it2.putExtra("va2", x2);
                            startActivity(it2);
                            finish();
                            break;
                        case 2:
                            Intent it3 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String x3 = spinner4[2];
                            it3.putExtra("va3", x3);
                            startActivity(it3);
                            finish();
                            break;
                        case 3:
                            Intent it4 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String x4 = spinner4[3];
                            it4.putExtra("va4", x4);
                            startActivity(it4);
                            finish();
                            break;
                        case 4:
                            Intent it5 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String x5 = spinner4[4];
                            it5.putExtra("va5", x5);

                            startActivity(it5);
                            finish();
                            break;
                    }
                } else {
                    count4 = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter adapt5 = new ArrayAdapter(Defaultreviews.this, android.R.layout.simple_spinner_item, spinner5);
        adapt5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp5.setAdapter(adapt5);
        sp5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            Boolean count5 = false;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (count5) {

                    switch (position) {
                        case 0:
                            Intent t1 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String z1 = spinner5[0];
                            t1.putExtra("values0", z1);
                            startActivity(t1);
                            finish();
                            break;
                        case 1:
                            Intent t2 = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String z2 = spinner5[1];
                            t2.putExtra("values1", z2);
                            startActivity(t2);
                            finish();
                            break;

                    }
                } else {
                    count5 = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter adapt6 = new ArrayAdapter(Defaultreviews.this, android.R.layout.simple_spinner_item, spinner6);
        adapt6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp6.setAdapter(adapt6);
        sp6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            Boolean count6 = false;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (count6) {
                    switch (position) {
                        case 0:
                            Intent a = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String ab = spinner6[0];
                            a.putExtra("get1", ab);
                            startActivity(a);
                            break;
                        case 1:
                            Intent b = new Intent(Defaultreviews.this, Reviewsubmission.class);
                            String lm = spinner6[1];
                            b.putExtra("get2", lm);
                            startActivity(b);
                            break;

                    }
                } else {
                    count6 = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

        AlertDialog.Builder make = new AlertDialog.Builder(Defaultreviews.this);
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



