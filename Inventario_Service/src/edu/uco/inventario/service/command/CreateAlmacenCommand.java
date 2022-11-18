package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.AlmacenDTO;

public interface CreateAlmacenCommand {
	void execute(AlmacenDTO usuario);
}
