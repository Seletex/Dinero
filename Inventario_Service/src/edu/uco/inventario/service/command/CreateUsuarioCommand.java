package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.UsuarioDTO;

public interface CreateUsuarioCommand {
	
	void execute(UsuarioDTO usuario);

}
