package com.example.project21.ui.Login.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project21.R;

public class timetable extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        boolean attachRoot;
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_timetable,container, attachRoot = false);
        return rootView;
    }
}
