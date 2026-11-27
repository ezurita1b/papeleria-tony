package com.papeleriatony.papeleriatony.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.papeleriatony.papeleriatony.api.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Transactional
    public void comprarProducto(
            Integer idProducto,
            Integer cantidad) {

        repository.comprarProducto(
                idProducto,
                cantidad
        );

    }
}