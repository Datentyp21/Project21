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
import com.example.project21.search.IconAdapter;
import com.example.project21.search.SearchObject;
import com.example.project21.search.SeperateObject;
import com.example.project21.search.SystemObject;
import com.example.project21.search.UserObject;
import com.example.project21.tools.Connection;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class NavigationActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private SearchView sview;
    private ListView lview;

    private IconAdapter adapter;
    private ArrayList<SearchObject> objectList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        lview = findViewById(R.id.listview);
        sview = findViewById(R.id.searchView);

        objectList = new ArrayList<>();

        objectList.add(new UserObject("Alexander Hage", "a.hage@21er.at", Connection.CUSER));
        objectList.add(new UserObject("Yolanda Hage", "y.hage@21er.at", Connection.CUSER));
        objectList.add(new UserObject("Julian Hage", "j.hage@21er.at", Connection.CUSER));
        objectList.add(new UserObject("Tim Dröpke", "t.droepke@21er.at", Connection.CUSER));
        objectList.add(new SeperateObject());
        objectList.add(new SystemObject(R.drawable.ic_notifications, "Notifications", Connection.CUSER));

        adapter = new IconAdapter(this, objectList);

        lview.setAdapter(adapter);

        lview.setVisibility(View.GONE);

        sview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                adapter.getFilter().filter(query);
                lview.setVisibility(View.VISIBLE);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                lview.setVisibility(View.VISIBLE);
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
