package edu.uco.inventario.service.usecase.usuario;

import java.util.UUID;

import edu.uco.inventario.domain.UsuarioDTO;

public interface FindUsuarioPorId {
	
	UsuarioDTO execute(UUID id);

}
