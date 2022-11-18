package edu.uco.inventario.service.usecase.almacen.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.AlmacenDTO;
import edu.uco.inventario.service.usecase.almacen.CreateAlmacenUseCase;

public class CreateAlmacenUseCaseImpl implements CreateAlmacenUseCase {

	private DAOFactory factory;

	@Override
	public void execute(AlmacenDTO person) {
		factory.getAlmacenDAO().create(person);

	}

	public CreateAlmacenUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
}
