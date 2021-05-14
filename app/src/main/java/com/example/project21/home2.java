package com.example.project21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class home2 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager().beginTransaction().replace(R.id.bottomNavigation,new notifications()).commit();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                case R.id.item1:
                    fragment= new notifications();
                    break;
                case R.id.item2:
                    fragment = new timetable();
                    break;
                case R.id.item3:
                    fragment = new home();
                    break;
                case R.id.item4:
                    fragment = new roomplan();
                    break;
                case R.id.item5:
                    fragment = new more();
                    break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.bottomNavigation,fragment).commit();
                return true;
            }
        });


    }
}