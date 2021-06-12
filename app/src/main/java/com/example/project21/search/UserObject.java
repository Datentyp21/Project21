package com.example.project21.search;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.project21.tools.Connection;

public class UserObject extends SearchObject{

    private String email;

    public UserObject(Drawable icon, String name, String email, Connection c) {
        super(icon, name, c);

        this.email = email;

    }

    public String getEmail() {
        return email;
    }
}
