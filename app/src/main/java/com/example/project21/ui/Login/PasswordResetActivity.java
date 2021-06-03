package com.example.project21.ui.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project21.LoadingActivity;
import com.example.project21.R;
import com.example.project21.tools.Connection;

public class PasswordResetActivity extends AppCompatActivity {

    private Button b1;

    private TextView v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);

        b1 = findViewById(R.id.login_button);

        v1 = findViewById(R.id.textView6);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Connection.C5.establish(PasswordResetActivity.this);
                Connection.setLastConnection(Connection.C5);

            }
        });
    }
}