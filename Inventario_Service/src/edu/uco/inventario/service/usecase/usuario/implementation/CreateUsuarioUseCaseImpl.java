package edu.uco.inventario.service.usecase.usuario.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.UsuarioDTO;
import edu.uco.inventario.service.usecase.usuario.CreateUsuarioUseCase;

public class CreateUsuarioUseCaseImpl implements CreateUsuarioUseCase {
	
	private DAOFactory factory ;

	@Override
	public void execute(UsuarioDTO person) {
		factory.getUsuarioDAO().create(person);
		
	}
	
	public CreateUsuarioUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

}
