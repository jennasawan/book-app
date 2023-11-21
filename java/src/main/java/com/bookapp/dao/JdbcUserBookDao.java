package com.bookapp.dao;

import com.bookapp.model.ReadingLog;
import com.bookapp.model.User;
import com.bookapp.model.UserBook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserBookDao implements UserBookDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    public JdbcUserBookDao (JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }


    //bookuser logic should be handled in the service layer

    @Override
    public boolean addToUserBook(UserBook userBook){

        int userId = userBook.getUserId();
        int bookId = userBook.getBookId();
        String bookStatus = userBook.getBookStatus();


        String sql = "INSERT INTO user_book (user_id, book_id, book_status, percent_finished) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, userId, bookId, bookStatus, 0) == 1;

    };





}
