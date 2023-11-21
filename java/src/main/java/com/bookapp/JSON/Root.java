package com.bookapp.JSON;

import java.util.ArrayList;

public class Root {
    private String kind;
    private int totalItems;
    private ArrayList<Item> items;

    public Root(){};

    public Root(String kind, int totalItems, ArrayList<Item> items) {
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
