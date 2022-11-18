package edu.uco.inventario.service.usecase.ciudad.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.CiudadDTO;
import edu.uco.inventario.service.usecase.ciudad.CreateCiudadUseCase;

public class CreateCiuadUseCaseImpl implements CreateCiudadUseCase {

	private DAOFactory factory;

	@Override
	public void execute(CiudadDTO person) {
		factory.getUCiudadDAO();

	}

	public CreateCiuadUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
}
