package edu.uco.inventario.service.usecase.usuario;

import edu.uco.inventario.domain.UsuarioDTO;

public interface CreateUsuarioUseCase {
	void execute(UsuarioDTO person);
}
