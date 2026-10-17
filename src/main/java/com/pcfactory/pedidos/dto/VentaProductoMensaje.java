package com.pcfactory.pedidos.dto;

import lombok.Data;

import java.math.BigDecimal;

// Mensaje que llega desde el MS Ventas (los nombres deben coincidir con VentaProductoRequest)
@Data
public class VentaProductoMensaje {

    private String nombreCliente;
    private Long idCliente;
    private Long idProducto;
    private String nombreProducto;
    private BigDecimal precio;
    private Integer cantidad;
}