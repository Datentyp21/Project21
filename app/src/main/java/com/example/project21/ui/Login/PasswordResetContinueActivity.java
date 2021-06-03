package com.example.project21.ui.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project21.LoadingActivity;
import com.example.project21.R;
import com.example.project21.tools.Connection;

public class PasswordResetContinueActivity extends AppCompatActivity {

    private Connection c1;
    private Connection c2;

    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset_continue);

        b1 = findViewById(R.id.login_button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Connection.C7.establish(PasswordResetContinueActivity.this);
                Connection.setLastConnection(Connection.C7);

            }
        });

    }
}