package com.example.project21.ui.Login;

import android.content.res.ColorStateList;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.project21.R;

public class LoginWatcher implements TextWatcher {

    private LoginHandler handler;

    public LoginWatcher(LoginHandler handler){
        this.handler = handler;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {


        if(handler.getEmail().getText().toString().contains("@21er.at") &&
                handler.getPassword().getText().length() >= 8){

            handler.setSufficientPassword(true);
            handler.setVerifiedEmail(true);
            handler.getButton().setBackgroundTintList(ColorStateList.valueOf(handler.getActivity().getResources().getColor(R.color.button_accept)));

        } else {

            handler.getButton().setBackgroundTintList(ColorStateList.valueOf(handler.getActivity().getResources().getColor(R.color.button_reject)));
            handler.setSufficientPassword(false);
            handler.setVerifiedEmail(false);
        }

    }
}
