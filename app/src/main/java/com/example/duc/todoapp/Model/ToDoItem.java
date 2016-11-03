package com.example.duc.todoapp.Model;

/**
 * Created by duc on 28.10.16.
 */

public class ToDoItem {


    private String item;
    private Boolean isDone;

    public ToDoItem(String item, Boolean isDone) {
        this.item = item;
        this.isDone = isDone;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return item;
    }
}
