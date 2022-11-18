package edu.uco.inventario.service.usecase.pedido;

import edu.uco.inventario.domain.PedidoDTO;

public interface CreatePedidoUseCase {
	void execute(PedidoDTO person);
}
