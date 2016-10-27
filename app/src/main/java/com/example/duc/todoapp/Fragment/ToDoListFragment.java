package com.example.duc.todoapp.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.duc.todoapp.R;
import com.example.duc.todoapp.View.MainActivity;

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

        final EditText inputText = (EditText) view.findViewById(R.id.inputText);
        Button addBtn = (Button) view.findViewById(R.id.addBtn);

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

        addBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dismissKeyboard();
                if (inputText.getText().toString().isEmpty()) {
                    Toast.makeText(getContext().getApplicationContext(), getString(R.string.inputEmpty), Toast.LENGTH_LONG).show();
                } else {
                    values.add(inputText.getText().toString());
                    myAdapter.notifyDataSetChanged();
                    inputText.getText().clear();
                }
            }
        });

        return view;
    }

    public void dismissKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

}

