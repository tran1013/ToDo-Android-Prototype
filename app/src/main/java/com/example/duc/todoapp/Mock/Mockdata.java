package com.example.duc.todoapp.Mock;

import com.example.duc.todoapp.Model.ToDoItem;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by duc on 28.10.16.
 */

public class Mockdata {


    /**
     * Mocklist to fill the tasklist if application starts
     */
    ArrayList<ToDoItem> items = new ArrayList<>(Arrays.asList(new ToDoItem("Buy the new MacBook Pro", false), new ToDoItem("meet Mr. Parker", false),
            new ToDoItem("Explain math to sis", false), new ToDoItem("Buy some chips", false), new ToDoItem("Wash my car", false)));

    public ArrayList<ToDoItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<ToDoItem> items) {
        this.items = items;
    }


}
