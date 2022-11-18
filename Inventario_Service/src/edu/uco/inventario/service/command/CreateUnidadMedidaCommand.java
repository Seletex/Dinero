package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.UnidadMedidaDTO;

public interface CreateUnidadMedidaCommand {
	void execute(UnidadMedidaDTO usuario);
}
