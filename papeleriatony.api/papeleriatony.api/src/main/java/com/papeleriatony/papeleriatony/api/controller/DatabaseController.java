package com.papeleriatony.papeleriatony.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/db-test")
    public Map<String,Object> probarConexion(){

        String sql = """
            SELECT current_database() AS base
        """;

        return jdbcTemplate.queryForMap(sql);
    }

}