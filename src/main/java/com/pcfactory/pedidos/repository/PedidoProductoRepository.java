package com.pcfactory.pedidos.repository;

import com.pcfactory.pedidos.entity.PedidoProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoProductoRepository
        extends JpaRepository<PedidoProducto, Long> {
}