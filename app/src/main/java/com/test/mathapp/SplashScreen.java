package com.test.mathapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class SplashScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ImageView ahare_icon;
    ImageView arithmetic_logo;
    ImageView math_table_logo;
    ImageView geometry_logo;
    ImageView trigonometry_logo;
    ImageView calculator_logo;
    ImageView share_logo;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("DashBoard");

        arithmetic_logo = findViewById(R.id.arithmetic_logo);
        arithmetic_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_arithmetic = new Intent(SplashScreen.this, Arithmetic.class);
                startActivity(intent_arithmetic);
            }
        });

        math_table_logo = findViewById(R.id.math_tables_logo);
        math_table_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_math_tables = new Intent(SplashScreen.this, Math_Tables.class);
                startActivity(intent_math_tables);
            }
        });

        geometry_logo = findViewById(R.id.geometry_logo);
        geometry_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_geometry_logo = new Intent(SplashScreen.this, Geometry.class);
                startActivity(intent_geometry_logo);
            }
        });

        trigonometry_logo = findViewById(R.id.trigonometry_logo);
        trigonometry_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_trigonometry_logo = new Intent(SplashScreen.this, Trigonometry.class);
                startActivity(intent_trigonometry_logo);
            }
        });

        calculator_logo = findViewById(R.id.calculator_logo);
        calculator_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_calculator_logo = new Intent(SplashScreen.this, Calculator.class);
                startActivity(intent_calculator_logo);
            }
        });

        share_logo = findViewById(R.id.share_logo);
        share_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = "Math Formulae App Url: " +
                        "https://play.google.com/store/apps/details?id=com.test.mathapp";
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(intent, "Share using: "));
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.db:
                Intent i1 = new Intent(this, SplashScreen.class);
                startActivity(i1);
                break;

            case R.id.abt_us:
                Intent i2 = new Intent(this, AboutUs.class);
                startActivity(i2);
                break;
        }

        return false;
    }

}
