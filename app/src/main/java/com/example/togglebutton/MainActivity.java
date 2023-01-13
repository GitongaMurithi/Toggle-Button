package com.example.togglebutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view) {

        //Inflating the drawer layout into variable drawer layout
        drawerLayout=(DrawerLayout) getLayoutInflater().inflate(R.layout.activity_main,null);
        //Declaring and Instantiating the frame layout that all the views will be included
        FrameLayout frameLayout=drawerLayout.findViewById(R.id.frameLayout);
        frameLayout.addView(view);
        super.setContentView(drawerLayout);

       // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Toolbar toolbar=drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView=drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()){
            case R.id.settings:
                startActivity(new Intent(MainActivity.this,Settings.class));
                overridePendingTransition(0,0);
                break;

            case R.id.profile:
                startActivity(new Intent(MainActivity.this,Profile.class));
                overridePendingTransition(0,0);
                break;

            case R.id.about:
                startActivity(new Intent(MainActivity.this,AboutUs.class));
                overridePendingTransition(0,0);
                break;

        }
        return true;
    }

    protected  void allocateActivityTitle(String title){
        if (getSupportActionBar() !=null){
            getSupportActionBar().setTitle(title);
        }
    }
}