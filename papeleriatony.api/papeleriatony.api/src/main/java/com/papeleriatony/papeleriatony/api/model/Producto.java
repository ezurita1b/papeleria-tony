package com.papeleriatony.papeleriatony.api.model;

import lombok.Data;

@Data
public class Producto {

    private Integer idProducto;

    private Integer idCategoria;

    private Integer idProveedor;

    private String nombre;

    private String descripcion;

    private Double precio;

    private Integer stock;

    private String imagen;

    private Boolean estado;

}