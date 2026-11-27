package com.papeleriatony.papeleriatony.api.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void comprarProducto(
            Integer idProducto,
            Integer cantidad) {

        String sql = """
                SELECT *
                FROM producto
                WHERE id_producto = ?
                FOR UPDATE
                """;

        Map<String, Object> producto =
                jdbcTemplate.queryForMap(
                        sql,
                        idProducto
                );

        Integer stock =
                ((Number) producto.get("stock"))
                .intValue();

        if (stock < cantidad) {

            throw new RuntimeException(
                    "Stock insuficiente"
            );

        }

        String actualizar = """
                UPDATE producto
                SET stock = stock - ?
                WHERE id_producto = ?
                """;

        jdbcTemplate.update(
                actualizar,
                cantidad,
                idProducto
        );
    }
}