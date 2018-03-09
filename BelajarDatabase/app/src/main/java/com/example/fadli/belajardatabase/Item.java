package com.example.fadli.belajardatabase;

/**
 * Created by fadli on 3/9/18.
 */

public class Item {
    private int id;
    private String name;
    private int priority;

    public Item() {
    }

    public Item(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public Item(int id,String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
