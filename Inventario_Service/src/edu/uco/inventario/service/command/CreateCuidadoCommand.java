package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.CuidadoDTO;

public interface CreateCuidadoCommand {
	void execute(CuidadoDTO usuario);
}
