package com.papeleriatony.papeleriatony.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.papeleriatony.papeleriatony.api.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping("/comprar")
    public ResponseEntity<String> comprar() {

        try {

            service.comprarProducto(
                    1,
                    5
            );

            return ResponseEntity.ok(
                    "Compra realizada correctamente"
            );

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());

        }

    }
}   