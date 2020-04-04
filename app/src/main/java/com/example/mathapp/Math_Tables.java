package com.test.mathapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Math_Tables extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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
        setContentView(R.layout.activity_math__tables);

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
        getSupportActionBar().setTitle("Math Tables");

        list = (ListView) findViewById(R.id.list);
        final ArrayList<String> names = new ArrayList<>();
        names.add("Trigonometry Table");
        names.add("Squares 1 to 10");
        names.add("Cubes 1 to 10");
        names.add("Factorial 1 to 10");

        adapter = new ArrayAdapter(this, R.layout.list_item, names);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent_trigonometry_table = new Intent(Math_Tables.this, Trigonometry_Table.class);
                    startActivity(intent_trigonometry_table);
                }

                if (position == 1) {
                    Intent intent_squares = new Intent(Math_Tables.this, Squares.class);
                    startActivity(intent_squares);
                }

                if (position == 2) {
                    Intent intent_cubes = new Intent(Math_Tables.this, Cubes.class);
                    startActivity(intent_cubes);
                }

                if (position == 3) {
                    Intent intent_factorials = new Intent(Math_Tables.this, Factorials.class);
                    startActivity(intent_factorials);
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
