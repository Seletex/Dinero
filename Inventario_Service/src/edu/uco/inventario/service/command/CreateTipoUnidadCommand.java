package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.TipoUnidadDTO;

public interface CreateTipoUnidadCommand {
	void execute(TipoUnidadDTO usuario);
}
