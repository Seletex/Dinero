package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.PedidoDTO;

public interface CreatePedidoCommand {
	void execute(PedidoDTO usuario);
}
