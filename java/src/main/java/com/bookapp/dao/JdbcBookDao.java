package com.bookapp.dao;

import com.bookapp.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBookDao implements BookDao{

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    public JdbcBookDao(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer addBook(Book book) {
        String sql = "INSERT INTO book(isbn,cover_url,title,author, page_count) " +
                "VALUES(?,?,?,?,?) RETURNING id;";

        return jdbcTemplate.queryForObject(sql,Integer.class,book.getISBN(),book.getCoverUrl(),
                book.getTitle(),book.getAuthor(), book.getPageCount());

    }

    @Override
    public Book getBookByID(int id)
    {
        Book book = null;

        String sql = "SELECT * FROM book WHERE id = ?";

        SqlRowSet rowset = jdbcTemplate.queryForRowSet(sql,id);

        if(rowset.next()){
            book = mapRowToBook(rowset);
        }
        return book;
    }

    @Override
    public List<Book> getActiveBooks(int userId){

        List<Book> activeBooks = new ArrayList<>();

        String sql = "SELECT * FROM book b \n" +
                "INNER JOIN user_book ub\n" +
                "ON b.id = ub.book_id\n" +
                "WHERE ub.user_id = ? AND ub.book_status = 'Current'";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while(rowSet.next()){
            Book book = mapRowToBook(rowSet);
            activeBooks.add(book);
        }

        return activeBooks;


    }

    @Override
    public List<Book> getWishlist(int userId){

        List<Book> wishlistBooks = new ArrayList<>();

       String sql = "SELECT * FROM book b \n" +
                "INNER JOIN user_book ub\n" +
                "ON b.id = ub.book_id\n" +
                "WHERE ub.user_id = ? AND ub.book_status = 'Wishlist'";

       SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

       while(rowSet.next()){
           Book book = mapRowToBook(rowSet);
           wishlistBooks.add(book);
       }

       return wishlistBooks;

    }

    @Override
    public List<Book> getHistory(int userId){

        List<Book> bookHistory = new ArrayList<>();

        String sql = "SELECT * FROM book b \n" +
                "INNER JOIN user_book ub\n" +
                "ON b.id = ub.book_id\n" +
                "WHERE ub.user_id = ? AND ub.book_status = 'History'";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while(rowSet.next()){
            Book book = mapRowToBook(rowSet);
            bookHistory.add(book);
        }

        return bookHistory;

    }




    private Book mapRowToBook(SqlRowSet rowSet){
        Book book = new Book();

        book.setId(rowSet.getInt("id"));
        book.setTitle(rowSet.getString("title"));
        book.setAuthor(rowSet.getString("author"));
        book.setISBN(rowSet.getString("isbn"));
        book.setCoverUrl(rowSet.getString("cover_url"));
        return book;

    }


}
