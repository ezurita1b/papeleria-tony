package com.papeleriatony.papeleriatony.api.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProveedorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String,Object>> listar(){

        String sql = """
            SELECT *
            FROM proveedor
            ORDER BY id_proveedor
        """;

        return jdbcTemplate.queryForList(sql);
    }
}