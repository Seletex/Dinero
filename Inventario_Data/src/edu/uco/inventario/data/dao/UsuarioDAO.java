package edu.uco.inventario.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.domain.UsuarioDTO;

public interface UsuarioDAO {
	
	void create(UsuarioDTO usuarioDTO);

	List<UsuarioDTO> find(UsuarioDTO usuarioDTO);

	void update(UsuarioDTO usuarioDTO);

	void delete(UUID id);

}
