package com.example.project21.search;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.project21.R;
import com.example.project21.tools.Connection;

public class UserObject extends SearchObject{

    private String email;

    public UserObject(String name, String email, Connection c) {
        super(R.drawable.ic_account, name, c);

        this.email = email;

    }

    public String getEmail() {
        return email;
    }
}
