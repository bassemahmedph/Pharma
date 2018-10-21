package com.example.islamgsayed.firstapp.Home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
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
import android.widget.TextView;

import com.example.islamgsayed.firstapp.Cart.cart;
import com.example.islamgsayed.firstapp.Pharmact_Dictionary.Pharmacy_Dictionary;
import com.example.islamgsayed.firstapp.Map.MapForHospitals;
import com.example.islamgsayed.firstapp.Map.MapPlacesActivity;
import com.example.islamgsayed.firstapp.R;
import com.example.islamgsayed.firstapp.adwya.medicineDic;
import com.example.islamgsayed.firstapp.amrads_ha23a.popularDiseses;
import com.example.islamgsayed.firstapp.help.helpnnav;
import com.example.islamgsayed.firstapp.login_createAcc.loginActivity;
import com.example.islamgsayed.firstapp.make_order.makeorder;
import com.google.firebase.auth.FirebaseAuth;

public class navdrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth firebaseAuth;
    private TextView textViewemail;
    private TextView textViewDalel;

    CardView mapPlaces;
    CardView diseses,makeorderr,hospital,Remider,daleladwya;
    Button button;



   // private ImageButton button;
   // private ImageButton btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navdrawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mapPlaces = (CardView) findViewById(R.id.map_places);
        diseses=findViewById(R.id.deasese);
        makeorderr=findViewById(R.id.makeorderrr);
        hospital=findViewById(R.id.HospitalsDic);
        Remider=findViewById(R.id.ReminderCardView);
        daleladwya=findViewById(R.id.idddd);
        setSupportActionBar(toolbar);

//       // button = findViewById(R.id.pic1);
//        //btn = findViewById(R.id.pic2);
///*
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent activityChangeIntent = new Intent(navdrawer.this, MapsActivity.class);
//                 navdrawer.this.startActivity(activityChangeIntent);
//
//            }
//        });*/



//
//        button = find

        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this , loginActivity.class));
        }

        mapPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(navdrawer.this, MapPlacesActivity.class));
            }
        });
        diseses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(navdrawer.this , popularDiseses.class));
            }
        });
        makeorderr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), makeorder.class));
            }
        });
        Remider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.example.islamgsayed.firstapp.pillapp.ViewController.MainActivity.class));

            }

        });
        daleladwya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() , Pharmacy_Dictionary.class));
            }
        });
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(navdrawer.this , MapForHospitals.class));
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext() , cart.class));;
            }
        });

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
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navdrawer, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Setting) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(getApplicationContext(), loginActivity.class));
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
           // startActivity(new Intent(this , navdrawer.class));
            // Handle the camera action
        }  else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(this , medicineDic.class));

        } else if (id == R.id.nav_dalelelsaydlyat) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:123"));
            startActivity(callIntent);

        }

        else if (id == R.id.nav_share) {


            startActivity(new Intent(this ,helpnnav.class));
        } else if (id == R.id.nav_send) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, loginActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
