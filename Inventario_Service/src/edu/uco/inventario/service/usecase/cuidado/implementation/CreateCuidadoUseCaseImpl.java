package edu.uco.inventario.service.usecase.cuidado.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.CuidadoDTO;
import edu.uco.inventario.service.usecase.cuidado.CreateCuidadoUseCase;

public class CreateCuidadoUseCaseImpl implements CreateCuidadoUseCase {

	private DAOFactory factory;

	@Override
	public void execute(CuidadoDTO person) {
		factory.getCuidadoDAO().create(person);

	}

	public CreateCuidadoUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
}
