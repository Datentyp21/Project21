package com.example.project21.ui.Login.fragments;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.project21.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class NavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new home()).commit();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.item1:
                        fragment = new home();
                        break;
                    case R.id.item2:
                        fragment = new notifications();
                        break;
                    case R.id.item3:
                        fragment = new timetable();
                        break;
                    case R.id.item4:
                        fragment = new roomplan();
                        break;
                    case R.id.item5:
                        fragment = new more();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
                return true;
            }
        });

    }
}