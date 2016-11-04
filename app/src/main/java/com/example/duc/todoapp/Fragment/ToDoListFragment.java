package com.example.duc.todoapp.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
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

import com.example.duc.todoapp.Mock.Mockdata;
import com.example.duc.todoapp.Model.ItemSingleton;
import com.example.duc.todoapp.Model.ToDoItem;
import com.example.duc.todoapp.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;


/**
 * Created by Duc on 19/10/16.
 */

public class ToDoListFragment extends Fragment {

    Mockdata values = new Mockdata();
    ArrayList<ToDoItem> items = values.getItems();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_todolist, container, false);

        final ArrayAdapter<ToDoItem> myAdapter = new ArrayAdapter<>(getContext().getApplicationContext(), R.layout.listrow, items);

        final EditText inputText = (EditText) view.findViewById(R.id.inputText);
        Button addBtn = (Button) view.findViewById(R.id.addBtn);

        final ListView listView = (ListView) view.findViewById(R.id.toDoListView);

        listView.setAdapter(myAdapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {


                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(getString(R.string.alertBoxDelete));

                builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        myAdapter.remove(items.get(position));
                        listView.setAdapter(myAdapter);
                        setMarked(listView);
                        myAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                        System.out.println("LONG");
                        //getItems();
                    }
                });

                builder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
                calculatePercentage();
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (items.get(i).getDone().equals(false)) {
                    items.get(i).setDone(true);
                } else {
                    items.get(i).setDone(false);
                }
                calculatePercentage();
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dismissKeyboard();
                if (inputText.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getContext().getApplicationContext(), getString(R.string.inputEmpty), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else {
                    //items.add(new ToDoItem(inputText.getText().toString(), false));
                    myAdapter.add(new ToDoItem(inputText.getText().toString(), false));
                    myAdapter.notifyDataSetChanged();
                    inputText.getText().clear();
                }
                calculatePercentage();
            }
        });

        calculatePercentage();
        return view;

    }

    public void dismissKeyboard() {
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

    public void setMarked(ListView listView) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getDone().equals(true))
                listView.setItemChecked(i, true);
        }
    }

    public void calculatePercentage() {

        ItemSingleton object = ItemSingleton.getInstance();
        NumberFormat formater = new DecimalFormat("#0.00");

        Double done = 0.0;
        Double undone = 0.0;

        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getDone().equals(true))
                    done += 1.0;

            }

            formater.format(done = (done / items.size()) * 100);
            formater.format(undone = 100 - done);
            object.setDone(done);
            object.setUndone(undone);
        }
        System.out.println("DONE: " + done + " / UNDONE: " + undone);
        System.out.println("OBJECT: " + " DONE: " + object.getDone() + " UNDONE: " + object.getUndone());
    }

}

