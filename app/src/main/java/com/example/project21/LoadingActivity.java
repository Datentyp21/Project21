package com.example.project21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.example.project21.tools.Connection;
import com.example.project21.userdata.Role;
import com.example.project21.userdata.User;
import com.example.project21.userdata.UserDataHandler;
import com.example.project21.userdata.UserDataSet;

public class LoadingActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        UserDataHandler.addUser(new User(new UserDataSet("a.hage@21er.at", "ThomasdieHomomotive", Role.STUDENT)));
        UserDataHandler.addUser(new User(new UserDataSet("admin", "admin", Role.STUDENT)));

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                if (Connection.hasLastConnection()) {

                    switch (Connection.getLastConnection()) {

                        case C2:
                            Connection.C3.establish(LoadingActivity.this);
                            Connection.setLastConnection(Connection.C3);
                            break;
                        case C5:
                            Connection.C6.establish(LoadingActivity.this);
                            Connection.setLastConnection(Connection.C6);
                            break;
                        case C7:
                            Connection.C1.establish(LoadingActivity.this);
                            Connection.setLastConnection(Connection.C1);
                            break;
                        default:
                            break;

                    }

                } else {

                    Connection.C1.establish(LoadingActivity.this);
                    Connection.setLastConnection(Connection.C1);

                }

            }

        },SPLASH_TIME_OUT);

        bar = findViewById(R.id.progressBar);

        bar.setIndeterminate(true);
        bar.setScaleY(0.2f);

    }
}