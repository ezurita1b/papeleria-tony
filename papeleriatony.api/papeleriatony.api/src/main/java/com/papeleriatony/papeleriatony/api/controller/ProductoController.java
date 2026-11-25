package com.papeleriatony.papeleriatony.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.papeleriatony.papeleriatony.api.model.Producto;
import com.papeleriatony.papeleriatony.api.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    // LISTAR
    @GetMapping
    public List<Map<String, Object>> listar() {

        return service.listar();

    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Map<String, Object> buscarPorId(
            @PathVariable Integer id) {

        return service.buscarPorId(id);

    }

    // INSERTAR
    @PostMapping
    public String guardar(
            @RequestBody Producto producto) {

        service.guardar(producto);

        return "Producto registrado correctamente";

    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public String actualizar(
            @PathVariable Integer id,
            @RequestBody Producto producto) {

        service.actualizar(id, producto);

        return "Producto actualizado correctamente";

    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public String eliminar(
            @PathVariable Integer id) {

        service.eliminar(id);

        return "Producto eliminado correctamente";

    }

}