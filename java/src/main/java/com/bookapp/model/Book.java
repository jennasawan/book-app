package com.bookapp.model;

public class Book {

    private int id;
    private String title;
    private String author;
    private String ISBN;
    private String coverUrl;
    private int pageCount;
    private boolean userCreated;
    private boolean isCompleted;

    public boolean isUserCreated() {
        return userCreated;
    }

    public void setUserCreated(boolean userCreated) {
        this.userCreated = userCreated;
    }

    public Book(){};

    public Book(String title, String author, String ISBN, int id, boolean userCreated, int pageCount) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.id = id;
        this.userCreated = userCreated;
        this.pageCount = pageCount;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
