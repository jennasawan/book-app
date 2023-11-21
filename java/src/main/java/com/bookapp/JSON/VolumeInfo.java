package com.bookapp.JSON;

import java.util.ArrayList;

public class VolumeInfo {

    private String title;
    private ArrayList<String> authors;
    private ImageLinks imageLinks;
    private ArrayList<IndustryIdentifier> industryIdentifiers;
    private int pageCount;

    public ArrayList<IndustryIdentifier> getIndustryIdentifiers() {
        return industryIdentifiers;
    }


    public String getTitle() {
        return title;
    }
    public ArrayList<String> getAuthors() {
        return authors;
    }
    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public int getPageCount() {
        return pageCount;
    }
}
