package edu.uco.inventario.service.usecase.pais.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.PaisDTO;
import edu.uco.inventario.service.usecase.pais.CreatePaisUseCase;

public class CreatePaisUseCaseImpl implements CreatePaisUseCase {

	private DAOFactory factory;

	@Override
	public void execute(PaisDTO person) {
		 factory.getPaisDAO();

	}

	public CreatePaisUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
}
