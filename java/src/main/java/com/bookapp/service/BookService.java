package com.bookapp.service;

import com.bookapp.dao.BookDao;
import com.bookapp.dao.ReadingLogDao;
import com.bookapp.dao.UserBookDao;
import com.bookapp.dao.UserDao;
import com.bookapp.model.UserBook;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    private UserDao userDao;
    private BookDao bookDao;
    private ReadingLogDao readingLogDao;
    private UserBookDao userBookDao;

    public BookService(){};

    public BookService(UserDao userDao, BookDao bookDao, ReadingLogDao readingLogDao, UserBookDao userBookDao){
        this.userDao = userDao;
        this.bookDao = bookDao;
        this.readingLogDao = readingLogDao;
        this.userBookDao = userBookDao;
    }


    public boolean addToUserBook(UserBook userBook){
        int userId = userBook.getUserId();
        int bookId = userBook.getBookId();
        String bookStatus = userBook.getBookStatus();
        int percentFinished = 0;
        if(bookStatus == "History"){
            percentFinished = 100;
        }

        return userBookDao.addToUserBook(userBook);


    }



}
