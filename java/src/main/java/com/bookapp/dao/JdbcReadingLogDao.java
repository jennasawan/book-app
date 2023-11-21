package com.bookapp.dao;

import com.bookapp.model.ReadingLog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcReadingLogDao implements ReadingLogDao{

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    public JdbcReadingLogDao(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer addReadingLog(ReadingLog log){

        String sql = "INSERT INTO reading_log (user_id, book_id, page_number, star_rating, thoughts) " +
        "VALUES (?, ?, ?, ?, ?) RETURNING id;";

        Integer newLogId = jdbcTemplate.queryForObject(sql, Integer.class, log.getUserId(), log.getBookId(), log.getPageNumber(), log.getStarRating(), log.getThoughts());

        return newLogId;


    }


}
