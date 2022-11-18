package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.SeccionDTO;

public interface CreateSeccionCommand {
	void execute(SeccionDTO usuario);
}
