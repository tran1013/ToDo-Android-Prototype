package com.example.duc.todoapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Duc on 19/10/16.
 */

public class ToDoListClass extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_todolist, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


    }
}
