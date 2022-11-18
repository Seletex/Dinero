package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.SalidaDTO;

public interface CreateSalidaCommand {
	void execute(SalidaDTO usuario);
}
