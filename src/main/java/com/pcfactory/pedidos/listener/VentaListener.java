package com.pcfactory.pedidos.listener;

import com.pcfactory.pedidos.dto.VentaProductoMensaje;
import com.pcfactory.pedidos.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VentaListener {

    private static final Logger logger =
            LoggerFactory.getLogger(VentaListener.class);

    @Autowired
    private PedidoService pedidoService;

    // Spring escucha la cola; cada mensaje que llega ejecuta este método
    @RabbitListener(queues = "${app.rabbitmq.queue}")
    public void consumirVenta(List<VentaProductoMensaje> mensaje) {
        pedidoService.guardarPedido(mensaje);

        logger.info(
                "Pedido registrado: {} productos guardados en MySQL",
                mensaje.size()
        );
    }
}