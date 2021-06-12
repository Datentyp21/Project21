package com.example.project21.search;

import android.widget.ImageView;

import com.example.project21.tools.Connection;

public abstract class SearchObject {

    private ImageView icon;
    private String name;
    private Connection c;

    public SearchObject(ImageView icon, String name, Connection c){

        this.icon = icon;
        this.name = name;
        this.c = c;

    }

    public ImageView getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public Connection getC() {
        return c;
    }


}
