package edu.uco.inventario.service.usecase.usuario.implementation;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.UsuarioDTO;
import edu.uco.inventario.service.usecase.usuario.FindUsuarioPorId;

public class FindUsuarioPorIdImpl implements FindUsuarioPorId{

private final DAOFactory factory;
	
	public FindUsuarioPorIdImpl(DAOFactory factory) {
		this.factory=factory;
	}
	
	@Override
	public UsuarioDTO execute(final UUID id){
		UsuarioDTO result = new UsuarioDTO();
		final UsuarioDTO usuario = UsuarioDTO.create(id);
		List<UsuarioDTO> results = factory.getUsuarioDAO().find(usuario);
		
			results = factory.getUsuarioDAO().find(usuario);
		
		if(!results.isEmpty()) {
			result = results.get(0);
		}
		return result;
	}
}
