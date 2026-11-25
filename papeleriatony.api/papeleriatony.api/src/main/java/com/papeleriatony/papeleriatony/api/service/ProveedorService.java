package com.papeleriatony.papeleriatony.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleriatony.papeleriatony.api.repository.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository repository;

    public List<Map<String,Object>> listar(){
        return repository.listar();
    }
}