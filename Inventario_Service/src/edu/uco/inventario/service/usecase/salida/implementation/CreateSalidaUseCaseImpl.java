package edu.uco.inventario.service.usecase.salida.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.SalidaDTO;
import edu.uco.inventario.service.usecase.salida.CreateSalidaUseCase;

class CreateSalidaUseCaseImpl implements CreateSalidaUseCase {

	private DAOFactory factory;

	@Override
	public void execute(SalidaDTO person) {
		factory.getSalidaDAO().create(person);

	}

	public CreateSalidaUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
}