package com.example.mathapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Trigonometry extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ArrayAdapter adapter;
    ListView list;
    EditText theFilter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigonometry);

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
        getSupportActionBar().setTitle("Trigonometry");


        list = (ListView) findViewById(R.id.list);
        final ArrayList<String> names = new ArrayList<>();
        names.add("Trigonometrical Ratio");
        names.add("Trigonometric Identities");

        adapter = new ArrayAdapter(this, R.layout.list_item, names);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent_trigonometrical_ratio = new Intent(Trigonometry.this, Trigonometrical_ratio.class);
                    startActivity(intent_trigonometrical_ratio);
                }

                if (position == 1) {
                    Intent intent_trigonometrical_identities = new Intent(Trigonometry.this, Trigonometric_identities.class);
                    startActivity(intent_trigonometrical_identities);
                }
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
