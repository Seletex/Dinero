package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.ProveedorDTO;

public interface CreateProveedorCommand {
	void execute(ProveedorDTO usuario);
}
