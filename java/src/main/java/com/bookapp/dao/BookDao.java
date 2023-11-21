package com.bookapp.dao;

import com.bookapp.model.Book;

import java.util.List;

public interface BookDao {

    Integer addBook(Book book);

    Book getBookByID(int id);

    List<Book> getActiveBooks(int userId);

    List<Book> getWishlist(int userId);

    List<Book> getHistory(int userId);



}
