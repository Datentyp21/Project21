package com.example.project21;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.project21.R;

import org.jetbrains.annotations.NotNull;

public class home extends androidx.fragment.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        boolean attachToRoot;
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_home,container, attachToRoot = false);
        return rootView;

    }
}