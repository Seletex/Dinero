package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.CiudadDTO;

public interface CreateCiudadCommand {
	void execute(CiudadDTO usuario);
}
