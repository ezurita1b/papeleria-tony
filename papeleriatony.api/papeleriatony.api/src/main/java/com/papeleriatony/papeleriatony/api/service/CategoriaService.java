package com.papeleriatony.papeleriatony.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleriatony.papeleriatony.api.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Map<String, Object>> listar() {
        return repository.listar();
    }
}