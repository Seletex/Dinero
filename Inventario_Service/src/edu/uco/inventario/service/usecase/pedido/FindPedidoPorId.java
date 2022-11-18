package edu.uco.inventario.service.usecase.pedido;

import java.util.UUID;

import edu.uco.inventario.domain.PedidoDTO;

public interface FindPedidoPorId {
	PedidoDTO execute(UUID id);
}
