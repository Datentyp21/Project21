package com.example.project21.ui.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.project21.R;
import com.example.project21.ui.Login.fragments.NavigationActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = findViewById(R.id.login_button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

                Intent homeIntent = new Intent(LoginActivity.this, NavigationActivity.class);
                startActivity(homeIntent);
                finish();

    }
}