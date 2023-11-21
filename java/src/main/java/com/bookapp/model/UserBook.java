package com.bookapp.model;

public class UserBook {

    private int userId;
    private int bookId;
    private String bookStatus;
    private int percentFinished;


    public UserBook(){};

    public UserBook(int userId, int bookId, String bookStatus, int percentFinished){
        this.userId = userId;
        this.bookId = bookId;
        this.bookStatus = bookStatus;
        this.percentFinished = percentFinished;
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

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public int getPercentFinished() {
        return percentFinished;
    }

    public void setPercentFinished(int percentFinished) {
        this.percentFinished = percentFinished;
    }
}
