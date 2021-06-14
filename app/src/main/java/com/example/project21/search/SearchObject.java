package com.example.project21.search;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.project21.tools.Connection;

public abstract class SearchObject {

    private int iconID;
    private String name;
    private Connection c;

    public SearchObject(int iconID, String name, Connection c){

        this.iconID = iconID;
        this.name = name;
        this.c = c;

    }

    public int getIconID() {
        return iconID;
    }

    public String getName() {
        return name;
    }

    public Connection getC() {
        return c;
    }


}
