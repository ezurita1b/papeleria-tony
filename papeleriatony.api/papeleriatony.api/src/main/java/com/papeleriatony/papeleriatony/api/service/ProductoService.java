package com.papeleriatony.papeleriatony.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleriatony.papeleriatony.api.model.Producto;
import com.papeleriatony.papeleriatony.api.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    // LISTAR
    public List<Map<String, Object>> listar() {
        return repository.listar();
    }

    // BUSCAR POR ID
    public Map<String, Object> buscarPorId(Integer id) {
        return repository.buscarPorId(id);
    }

    // GUARDAR
    public int guardar(Producto producto) {
        return repository.guardar(producto);
    }

    // ACTUALIZAR
    public int actualizar(Integer id, Producto producto) {
        return repository.actualizar(id, producto);
    }

    // ELIMINAR
    public int eliminar(Integer id) {
        return repository.eliminar(id);
    }
}