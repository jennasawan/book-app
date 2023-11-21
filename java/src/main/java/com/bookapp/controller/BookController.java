package com.bookapp.controller;

import com.bookapp.JSON.BookJSON;
import com.bookapp.JSON.Root;
import com.bookapp.dao.BookDao;
import com.bookapp.dao.ReadingLogDao;
import com.bookapp.dao.UserBookDao;
import com.bookapp.model.Book;
import com.bookapp.model.ReadingLog;
import com.bookapp.model.UserBook;
import com.bookapp.service.BookService;
import com.bookapp.service.GoogleAPI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    private BookService bookService;
    private GoogleAPI google;
    private BookDao bookDao;
    private ReadingLogDao readingLogDao;
    private UserBookDao userBookDao;


    public BookController(BookService bookService, GoogleAPI google, BookDao bookDao, ReadingLogDao readingLogDao, UserBookDao userBookDao){
        this.bookService = bookService;
        this.google = google;
        this.bookDao = bookDao;
        this.readingLogDao = readingLogDao;
        this.userBookDao = userBookDao;
    }

    //BOOKS
    @GetMapping("/google/books/{title}")
    public List<BookJSON> get5books(@PathVariable String title){
        Root newRoot = google.get5BooksByTitle(title);
        return google.googleSearchResultsByTitle(newRoot);
    };

    @GetMapping("/google/book/{ISBN}")
    public BookJSON getBookByISBN(@PathVariable String ISBN){
        Root newRoot = google.getByIsbn(ISBN);
        return google.googleSearchResultsByISBN(newRoot, ISBN);
    };

    @PostMapping("/book")
    public Integer addBook(@RequestBody Book book) {
        return bookDao.addBook(book);
    };

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookDao.getBookByID(id);
    }

    @PostMapping("/user/book")
    public boolean addToUserBookTable(@RequestBody UserBook userBook){
        return userBookDao.addToUserBook(userBook);
    }

    @GetMapping("/active/{userId}")
        public List<Book> getActiveBooks(@PathVariable int userId){
            return bookDao.getActiveBooks(userId);

    }

    @GetMapping("/wishlist/{userId}")
    public List<Book> getWishlist(@PathVariable int userId){
        return bookDao.getWishlist(userId);
    }

    @GetMapping("history/{userId}")
    public List<Book> getHistory(@PathVariable int userId){
        return bookDao.getHistory(userId);
    }


    //READING LOGS

    @PostMapping("/log")
    public Integer addReadingLog(@RequestBody ReadingLog log){
        return readingLogDao.addReadingLog(log);
    }



}
