package com.example.duc.todoapp.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.duc.todoapp.R;

/**
 * Created by Duc on 19/10/16.
 */

public class ToDoListFragment extends Fragment {

    String[] values = new String[] { "Buy the new MacBook Pro", "meet Mr. Parker", "Explain math to sis", "Buy some chips", "Wash my car"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todolist, container, false);

        ListView listView = (ListView) view.findViewById(R.id.toDoListView);

        listView.setAdapter(new ArrayAdapter<String>(getContext().getApplicationContext(), R.layout.listrow, values));


        return view;
    }

}
