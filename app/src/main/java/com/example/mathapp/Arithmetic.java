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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Arithmetic extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ArrayAdapter adapter;
    ListView list;
    EditText theFilter;
    ImageView back;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic);

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
        getSupportActionBar().setTitle("Arithmetic");


        list = (ListView) findViewById(R.id.list);
        final ArrayList<String> names = new ArrayList<>();
        names.add("Expansions");
        names.add("Factorization");
        names.add("Indices");
        names.add("Logarithms");
        names.add("Banking");
        names.add("Solids");

        adapter = new ArrayAdapter(this, R.layout.list_item, names);
        list.setAdapter(adapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {
                        Intent intent_expansions = new Intent(Arithmetic.this, Expansions.class);
                        startActivity(intent_expansions);
                    }

                    if (position == 1) {
                        Intent intent_f = new Intent(Arithmetic.this, Factorization.class);
                        startActivity(intent_f);
                    }

                    if (position == 2) {
                        Intent intent_indices = new Intent(Arithmetic.this, Indices.class);
                        startActivity(intent_indices);
                    }

                    if (position == 3) {
                        Intent intent_logarithms = new Intent(Arithmetic.this, Logarithm.class);
                        startActivity(intent_logarithms);
                    }

                    if (position == 4) {
                        Intent intent_banking = new Intent(Arithmetic.this, Banking.class);
                        startActivity(intent_banking);
                    }

                    if (position == 5) {
                        Intent intent_solids = new Intent(Arithmetic.this, Solids.class);
                        startActivity(intent_solids);
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
