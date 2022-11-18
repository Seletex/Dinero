package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.EstanteriaDTO;

public interface CreateEstanteriaCommand {
	void execute(EstanteriaDTO usuario);
}
