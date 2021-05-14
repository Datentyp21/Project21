package com.example.project21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.example.project21.ui.Login.LoginActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;

    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable(){

            @Override
            public void run() {

                InetSocketAddress address = new InetSocketAddress("84.115.73.101", 5001);

                try {

                    Socket socket = new Socket();
                    socket.connect(address, 10000);

                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                    pw.println("8====D");
                    pw.flush();

                    Scanner s = new Scanner(new BufferedReader(new InputStreamReader(socket.getInputStream())));
                    while(s.hasNextLine()){
                        System.out.println("Antwort vom Server: " + s.nextLine());
                    }
                    pw.close();
                    socket.close();


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

        bar = findViewById(R.id.progressBar);

        bar.setIndeterminate(true);
        bar.setScaleY(0.2f);

    }
}