package com.pcfactory.pedidos.controller;

import com.pcfactory.pedidos.entity.PedidoProducto;
import com.pcfactory.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoProducto> listarPedidos() {
        return pedidoService.obtenerPedidos();
    }
}