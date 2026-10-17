package com.pcfactory.pedidos.service;

import com.pcfactory.pedidos.dto.VentaProductoMensaje;
import com.pcfactory.pedidos.entity.PedidoProducto;
import com.pcfactory.pedidos.repository.PedidoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoProductoRepository pedidoProductoRepository;

    // Convierte cada elemento del mensaje en un PedidoProducto y guarda la lista completa
    @Transactional
    public void guardarPedido(List<VentaProductoMensaje> mensaje) {
        List<PedidoProducto> productos = new ArrayList<>();

        for (VentaProductoMensaje item : mensaje) {
            PedidoProducto producto = new PedidoProducto();

            producto.setNombreCliente(item.getNombreCliente());
            producto.setIdCliente(item.getIdCliente());
            producto.setIdProducto(item.getIdProducto());
            producto.setNombreProducto(item.getNombreProducto());
            producto.setPrecio(item.getPrecio());
            producto.setCantidad(item.getCantidad());

            productos.add(producto);
        }

        pedidoProductoRepository.saveAll(productos);
    }

    @Transactional(readOnly = true)
    public List<PedidoProducto> obtenerPedidos() {
        return pedidoProductoRepository.findAll();
    }
}