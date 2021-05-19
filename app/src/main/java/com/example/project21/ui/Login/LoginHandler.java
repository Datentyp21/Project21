package com.example.project21.ui.Login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project21.R;
import com.example.project21.ui.Login.fragments.NavigationActivity;

public class LoginHandler implements View.OnClickListener{

    final private LoginActivity activity;
    final private Button button;
    final private TextView email;
    final private TextView password;
    private boolean verified_email;
    private boolean sufficient_password;

    public LoginHandler(LoginActivity activity){
        this.activity = activity;
        button = activity.findViewById(R.id.login_button);
        email = activity.findViewById(R.id.editTextTextEmailAddress);
        password = activity.findViewById(R.id.editTextTextPassword2);

        LoginWatcher watcher = new LoginWatcher(this);

        email.addTextChangedListener(watcher);
        password.addTextChangedListener(watcher);
        button.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        if(this.isVerifiedEmail() && this.isSufficientPassword()) {

            Intent homeIntent = new Intent(activity, NavigationActivity.class);
            activity.startActivity(homeIntent);
            activity.finish();
        }
    }
    public void setVerifiedEmail(boolean verified_email){
        this.verified_email = verified_email;
    }
    public void setSufficientPassword(boolean sufficient_password){
        this.sufficient_password = sufficient_password;
    }
    public boolean isVerifiedEmail() {
        return verified_email;
    }
    public boolean isSufficientPassword() {
        return sufficient_password;
    }
    public TextView getPassword() {
        return password;
    }
    public TextView getEmail() {
        return email;
    }
    public Button getButton() {
        return button;
    }
    public LoginActivity getActivity(){
        return activity;
    }
}
