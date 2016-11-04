package com.example.duc.todoapp.Model;

/**
 * Created by duc on 04.11.16.
 */

public class ItemSingleton {
    public static final ItemSingleton object = new ItemSingleton();

    Double done;
    Double undone;

    public void setDone(Double done) {
        this.done = done;
    }

    public void setUndone(Double undone) {
        this.undone = undone;
    }

    public Double getDone() {
        return done;
    }

    public Double getUndone() {
        return undone;
    }

    private ItemSingleton() {
    }

    public static ItemSingleton getInstance() {
        return object;
    }
}
