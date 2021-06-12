package com.example.project21.ui.Login;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project21.R;
import com.example.project21.tools.Connection;
import com.example.project21.userdata.Role;
import com.example.project21.userdata.User;
import com.example.project21.userdata.UserDataHandler;
import com.example.project21.userdata.UserDataSet;

public class LoginHandler implements View.OnClickListener{

    final private LoginActivity activity;
    final private Button button;
    final private TextView email;
    final private TextView password;
    private TextView invalid;
    private TextView reset_password;
    private TextView guest_login;
    private boolean verified_email;
    private boolean sufficient_password;

    private Connection c1;
    private Connection c2;

    public LoginHandler(LoginActivity activity){
        this.activity = activity;
        button = activity.findViewById(R.id.login_button);
        email = activity.findViewById(R.id.id1);
        password = activity.findViewById(R.id.editTextTextPassword2);
        invalid = activity.findViewById(R.id.textView5);
        reset_password =  activity.findViewById(R.id.textView2);
        guest_login = activity.findViewById(R.id.textView3);

        if(User.getFailAttempts() == 0){
            invalid.setVisibility(View.INVISIBLE);
        } else
            if (User.getFailAttempts() > 3) {
                invalid.setText(R.string.try_again_delay);
            }

        LoginWatcher watcher = new LoginWatcher(this);

        email.addTextChangedListener(watcher);
        password.addTextChangedListener(watcher);
        button.setOnClickListener(this);

        reset_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Connection.C4.establish(getActivity());
                Connection.setLastConnection(Connection.C4);

            }
        });

        guest_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Connection.C2.establish(getActivity());
                Connection.setLastConnection(Connection.C2);
                User.setCurrentUser(new User());

            }
        });
    }



    @Override
    public void onClick(View v) {


        //IMPORTANT DO NOT FORGET TO REMOVE !!!!! - TOM

        if((User.getFailAttempts()) <= 3 && ((LoginHandler.this.isVerifiedEmail() && LoginHandler.this.isSufficientPassword()) ||
                email.getText().toString().contains("admin"))){

            if(UserDataHandler.containsUser(new User(new UserDataSet(this.getEmail().getText().toString(), this.getPassword().getText().toString(), Role.TEMPORARY_LOGIN)))) {

                Connection.C2.establish(getActivity());
                Connection.setLastConnection(Connection.C2);

            } else {

                User.setFailAttempts(User.getFailAttempts() + 1);
                Connection.C7.establish(getActivity());
                Connection.setLastConnection(Connection.C7);

            }

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
