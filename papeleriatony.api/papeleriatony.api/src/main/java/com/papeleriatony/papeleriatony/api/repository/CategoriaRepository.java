package com.papeleriatony.papeleriatony.api.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> listar() {

        String sql = """
                SELECT *
                FROM categoria
                ORDER BY id_categoria
                """;

        return jdbcTemplate.queryForList(sql);
    }
}