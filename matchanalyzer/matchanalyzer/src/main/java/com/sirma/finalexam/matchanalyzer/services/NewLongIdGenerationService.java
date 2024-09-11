package com.sirma.finalexam.matchanalyzer.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class NewLongIdGenerationService {

    private JdbcTemplate jdbcTemplate;

    public NewLongIdGenerationService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long generateUniqueId(String tableName) {
        Long maxId = getMaxId(tableName);
        return maxId + 1;
    }

    private Long getMaxId(String tableName) {
        String sql = "SELECT COALESCE(MAX(id), 0) FROM " + tableName;
        return jdbcTemplate.queryForObject(sql, Long.class);
    }
}
