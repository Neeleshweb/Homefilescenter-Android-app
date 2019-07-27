package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.VideoView;



public class Homepage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,Galleryfrag.OnFragmentInteractionListener,Toolsfrag.OnFragmentInteractionListener, Termfrag.OnFragmentInteractionListener
        ,Privacyfrag.OnFragmentInteractionListener,Feedbackfrag.OnFragmentInteractionListener,Featuresfrag.OnFragmentInteractionListener,Contactusfrag.OnFragmentInteractionListener,Blogfrag.OnFragmentInteractionListener,Aboutusfrag.OnFragmentInteractionListener

{
    Button btn,btn3;

    Button btn4 ;
    boolean Islogin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_homepage);

        SQLiteDatabase d=openOrCreateDatabase("homefilescenter",MODE_APPEND,null);
        d.execSQL("create table if not exists register(email varchar,password password,fullname varchar,city varchar,Mobno varchar)");
        d.execSQL("create table if not exists reviews(product_name varchar,review_description varchar,stars int(6),email varchar)");
        d.execSQL("create table if not exists cat(Category varchar,sucat1 varchar,sucat2 varchar,sucat3 varchar,sucat4 varchar,sucat5 varchar)");

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.edit().putBoolean("Islogin", Islogin).commit();
        firstcheck();
        btn=(Button)findViewById(R.id.button3);

        btn3=(Button)findViewById(R.id.button);
        btn4=(Button)findViewById(R.id.videoclick);


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=EN5EMrlSAEA"));
                startActivity(browserIntent);



            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent log=new Intent(Homepage.this,Login.class);

                startActivity(log);
                finish();
            }




        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent logs=new Intent(Homepage.this,Signup.class);
                startActivity(logs);
                finish();

            }


        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder make=new AlertDialog.Builder(Homepage.this);
            make.setTitle("EXIT CONFIRMATION");
            make.setMessage("Are you sure you want to exit the app,any unsaved session data will be lost ??");
            make.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent inte=new Intent(Homepage.this,Settings.class);
            startActivity(inte);
            return true;
        }


        else if(id==R.id.action_settings3) {

            Intent is=new Intent(Homepage.this,Message.class);
            startActivity(is);
            return true;
        }
        else if(id==R.id.action_settings0) {

            Intent is=new Intent(Homepage.this,Aboutus.class);
            startActivity(is);
            return true;
        }



        else if(id==R.id.action_settings6) {


            Intent i=new Intent(Homepage.this,Login.class);
            startActivity(i);
            finish();

        }


        else if(id==R.id.action_settings4) {
            AlertDialog.Builder make=new AlertDialog.Builder(Homepage.this);
            make.setTitle("EXIT CONFIRMATION");
            make.setMessage("Are you sure you want to exit the app,any unsaved session data will be lost ??");
            make.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            make.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(Homepage.this,"THE CHOICE IS YOURS",Toast.LENGTH_LONG).show();
                }
            });
            AlertDialog alert=make.create();
            alert.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment=null;
        String title="navbar" ;
        if (id == R.id.nav_camera) {
            ConnectivityManager connec = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

            if (connec != null && (
                    (connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) ||
                            (connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED))) {

                fragment=new Galleryfrag();
                int requestcode=25 ;


                Intent il=new Intent(Homepage.this,Galley.class);
                startActivityFromFragment(fragment ,il, requestcode);

            } else if (connec != null && (
                    (connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.DISCONNECTED) ||
                            (connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.DISCONNECTED ))) {


                AlertDialog.Builder make3 = new AlertDialog.Builder(Homepage.this);
                make3.setTitle("CONNECTION FAILED");
                make3.setMessage("It seems like you are not connected to the internet,please check your connection and then try again");
                make3.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent send = new Intent(Homepage.this, Homepage.class);
                        startActivity(send);
                        finish();
                    }
                });
                AlertDialog alert = make3.create();
                alert.show();

            }

        } else if (id == R.id.feedback) {
            ConnectivityManager connec = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

            if (connec != null && (
                    (connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) ||
                            (connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED))) {

                fragment=new Feedbackfrag();
                int requestcode=21 ;


                Intent il=new Intent(Homepage.this,Feedback.class);
                startActivityFromFragment(fragment ,il, requestcode);
                finish();

            } else if (connec != null && (
                    (connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.DISCONNECTED) ||
                            (connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.DISCONNECTED ))) {

                //Not connected.
                AlertDialog.Builder make3 = new AlertDialog.Builder(Homepage.this);
                make3.setTitle("CONNECTION FAILED");
                make3.setMessage("It seems like you are not connected to the internet,please check your connection and then try again");
                make3.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent send = new Intent(Homepage.this, Homepage.class);
                        startActivity(send);
                        finish();
                    }
                });
                AlertDialog alert = make3.create();
                alert.show();

            }




        } else if (id == R.id.features) {

            fragment=new Featuresfrag();
            int requestcode=173 ;


            Intent il=new Intent(Homepage.this,Features.class);
            startActivityFromFragment(fragment ,il, requestcode);
        } else if (id == R.id.blog) {
            ConnectivityManager connec = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

            if (connec != null && (
                    (connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) ||
                            (connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED))) {

                fragment=new Blogfrag();
                int requestcode=174 ;


                Intent il=new Intent(Homepage.this,Blog.class);
                startActivityFromFragment(fragment ,il, requestcode);

            } else if (connec != null && (
                    (connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.DISCONNECTED) ||
                            (connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.DISCONNECTED ))) {

                //Not connected.
                AlertDialog.Builder make3 = new AlertDialog.Builder(Homepage.this);
                make3.setTitle("CONNECTION FAILED");
                make3.setMessage("It seems like you are not connected to the internet,please check your connection and then try again");
                make3.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent send = new Intent(Homepage.this, Homepage.class);
                        startActivity(send);
                        finish();
                    }
                });
                AlertDialog alert = make3.create();
                alert.show();

            }


        } else if (id == R.id.terms) {
            fragment=new Termfrag();
            int requestcode=175 ;


            Intent il=new Intent(Homepage.this,Terms.class);
            startActivityFromFragment(fragment ,il, requestcode);

        } else if (id == R.id.privacy) {
            fragment=new Privacyfrag();
            int requestcode=176 ;


            Intent il=new Intent(Homepage.this,Privacy.class);
            startActivityFromFragment(fragment ,il, requestcode);
        }
        else if (id == R.id.aboutus) {
            fragment=new Aboutusfrag();
            int requestcode=177 ;


            Intent il=new Intent(Homepage.this,Aboutus.class);
            startActivityFromFragment(fragment ,il, requestcode);
        }
        else if (id == R.id.contactus) {
            ConnectivityManager connec = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

            if (connec != null && (
                    (connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) ||
                            (connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED))) {

                fragment=new Contactusfrag();
                int requestcode=178 ;


                Intent il=new Intent(Homepage.this,Contactus.class);
                startActivityFromFragment(fragment ,il, requestcode);

            } else if (connec != null && (
                    (connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.DISCONNECTED) ||
                            (connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.DISCONNECTED ))) {

                //Not connected.
                AlertDialog.Builder make3 = new AlertDialog.Builder(Homepage.this);
                make3.setTitle("CONNECTION FAILED");
                make3.setMessage("It seems like you are not connected to the internet,please check your connection and then try again");
                make3.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent send = new Intent(Homepage.this, Homepage.class);
                        startActivity(send);
                        finish();
                    }
                });
                AlertDialog alert = make3.create();
                alert.show();

            }

        }

        if(fragment!=null) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.mycustomlayout, fragment);
            fragmentTransaction.commit();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    private void firstcheck() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Islogin = prefs.getBoolean("Islogin", false);
        if(Islogin) {
            Intent gu=new Intent(Homepage.this,Welcome.class);
            startActivity(gu);
            finish();
        }
        else {

        }
    }




    @Override
    public void onFragmentInteractionGallery(Uri uri) {

    }

    @Override
    public void onFragmentInteractionTools(Uri uri) {

    }

    @Override
    public void onTermfragInteraction(Uri uri) {

    }

    @Override
    public void onPrivacyfragInteraction(Uri uri) {

    }

    @Override
    public void onBlogfragInteraction(Uri uri) {

    }

    @Override
    public void onContactusfragInteraction(Uri uri) {

    }

    @Override
    public void onFeaturesfragInteraction(Uri uri) {

    }

    @Override
    public void onFeedbackfragInteraction(Uri uri) {

    }

    @Override
    public void onAboutusfragInteraction(Uri uri) {

    }
}

