package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.EntradaDTO;

public interface CreateEntradaCommand {
	void execute(EntradaDTO usuario);
}
