package com.example.duc.todoapp.Fragment;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.duc.todoapp.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Duc on 19/10/16.
 */

public class ToDoListFragment extends Fragment {

    ArrayList<String> values = new ArrayList<String>(Arrays.asList("Buy the new MacBook Pro", "meet Mr. Parker", "Explain math to sis", "Buy some chips", "Wash my car"
    ));
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todolist, container, false);

        final ArrayAdapter<String> myAdapter = new ArrayAdapter<>(getContext().getApplicationContext(), R.layout.listrow, values);

        ListView listView = (ListView) view.findViewById(R.id.toDoListView);

        listView.setAdapter(myAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {


                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(getString(R.string.alertBoxDelete));

                builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        values.remove(position);
                        myAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
                return false;
            }
        });
        return view;
    }



}
