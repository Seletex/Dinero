package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.PaisDTO;

public interface CreatePaisCommand {
	void execute(PaisDTO usuario);
}
