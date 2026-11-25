package com.papeleriatony.papeleriatony.api.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.papeleriatony.papeleriatony.api.model.Producto;

@Repository
public class ProductoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // LISTAR
    public List<Map<String, Object>> listar() {

        String sql = """
            SELECT
                p.id_producto,
                p.nombre,
                p.descripcion,
                c.nombre AS categoria,
                pr.nombre_empresa AS proveedor,
                p.precio,
                p.stock,
                p.estado
            FROM producto p
            INNER JOIN categoria c
                ON p.id_categoria = c.id_categoria
            INNER JOIN proveedor pr
                ON p.id_proveedor = pr.id_proveedor
            ORDER BY p.id_producto
        """;

        return jdbcTemplate.queryForList(sql);
    }

    // BUSCAR POR ID
    public Map<String, Object> buscarPorId(Integer id) {

        String sql = """
            SELECT *
            FROM producto
            WHERE id_producto = ?
        """;

        return jdbcTemplate.queryForMap(sql, id);
    }

    // INSERTAR
    public int guardar(Producto producto) {

        String sql = """
            INSERT INTO producto(
                id_categoria,
                id_proveedor,
                nombre,
                descripcion,
                precio,
                stock,
                imagen,
                estado
            )
            VALUES (?,?,?,?,?,?,?,?)
        """;

        return jdbcTemplate.update(
                sql,
                producto.getIdCategoria(),
                producto.getIdProveedor(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getImagen(),
                producto.getEstado()
        );
    }

    // ACTUALIZAR
    public int actualizar(Integer id, Producto producto) {

        String sql = """
            UPDATE producto
            SET id_categoria=?,
                id_proveedor=?,
                nombre=?,
                descripcion=?,
                precio=?,
                stock=?,
                imagen=?,
                estado=?
            WHERE id_producto=?
        """;

        return jdbcTemplate.update(
                sql,
                producto.getIdCategoria(),
                producto.getIdProveedor(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getImagen(),
                producto.getEstado(),
                id
        );
    }

    // ELIMINAR
    public int eliminar(Integer id) {

        String sql = """
            DELETE FROM producto
            WHERE id_producto = ?
        """;

        return jdbcTemplate.update(sql, id);
    }

}