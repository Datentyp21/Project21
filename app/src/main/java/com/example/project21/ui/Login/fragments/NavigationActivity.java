package com.example.project21.ui.Login.fragments;

import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.SearchView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import com.example.project21.R;
import com.example.project21.search.SearchObject;
import com.example.project21.search.SystemObject;
import com.example.project21.tools.Connection;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private SearchView sview;
    private ListView lview;
    private ArrayAdapter<?> adapter;

    private Resources res;
    private String[] search;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        lview = findViewById(R.id.listview);
        sview = findViewById(R.id.searchView);

        res = getResources();
        search = new String[]{new SystemObject(res.getDrawable(R.drawable.ic_calendar), "Kalender",
                Connection.CUSER).getName(), new SystemObject(res.getDrawable(R.drawable.ic_calendar), "Kahllex",
                Connection.CUSER).getName()};

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, search);


        lview.setAdapter(adapter);
        lview.setVisibility(View.GONE);

        sview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                lview.setVisibility(View.VISIBLE);
                NavigationActivity.this.adapter.getFilter().filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                lview.setVisibility(View.VISIBLE);
                NavigationActivity.this.adapter.getFilter().filter(newText);
                return true;
            }
        });

        sview.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                lview.setVisibility(View.GONE);
                sview.onActionViewCollapsed();
                return true;
            }
        });

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.item1);
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
