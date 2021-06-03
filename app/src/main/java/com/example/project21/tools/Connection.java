package com.example.project21.tools;

import android.app.Activity;
import android.content.Intent;

import com.example.project21.LoadingActivity;
import com.example.project21.ui.Login.LoginActivity;
import com.example.project21.ui.Login.PasswordResetActivity;
import com.example.project21.ui.Login.PasswordResetContinueActivity;
import com.example.project21.ui.Login.fragments.NavigationActivity;

public enum Connection {


    C1(LoginActivity.class),
    C2(LoadingActivity.class),
    C3(NavigationActivity.class),
    C4(PasswordResetActivity.class),
    C5(LoadingActivity.class),
    C6(PasswordResetContinueActivity.class),
    C7(LoadingActivity.class),
    C8(PasswordResetActivity.class);

    private static Connection lastConnection;

    private Class<?> to;

    Connection(Class<?> to){

        this.to = to;

    }

    public static Connection getLastConnection() {
        return lastConnection;
    }

    public static void setLastConnection(Connection lastConnection) {
        Connection.lastConnection = lastConnection;
    }
    public static boolean hasLastConnection(){
        return Connection.getLastConnection() != null;
    }

    public Class<?> getTo() {
         return to;
    }

    public void establish(Activity activity){

        Intent i = new Intent(activity, this.getTo());
        activity.startActivity(i);
        activity.finish();

    }
}
