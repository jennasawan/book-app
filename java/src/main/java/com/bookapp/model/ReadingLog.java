package com.bookapp.model;

public class ReadingLog {

    private int id;
    private int userId;
    private int bookId;
    private int pageNumber;
    private int starRating;
    private String thoughts;

    public ReadingLog(){};

    public ReadingLog(int id, int userId, int bookId, int pageNumber, int starRating, String thoughts){
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.pageNumber = pageNumber;
        this.starRating = starRating;
        this.thoughts = thoughts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
