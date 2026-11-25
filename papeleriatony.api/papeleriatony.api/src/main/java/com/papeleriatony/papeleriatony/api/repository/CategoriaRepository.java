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
    public int guardar(String nombre, String descripcion){

    String sql = """
        INSERT INTO categoria(
            nombre,
            descripcion
        )
        VALUES(?,?)
    """;

    return jdbcTemplate.update(
            sql,
            nombre,
            descripcion
    );
}
public int actualizar(
        Integer id,
        String nombre,
        String descripcion
){

    String sql = """
        UPDATE categoria
        SET nombre=?,
            descripcion=?
        WHERE id_categoria=?
    """;

    return jdbcTemplate.update(
            sql,
            nombre,
            descripcion,
            id
    );
}public int eliminar(Integer id){

    String sql = """
        DELETE
        FROM categoria
        WHERE id_categoria=?
    """;

    return jdbcTemplate.update(
            sql,
            id
    );
}
}