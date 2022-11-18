package edu.uco.inventario.service.usecase.proveedor.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.ProveedorDTO;
import edu.uco.inventario.service.usecase.proveedor.CreateProveedorUseCase;

public class CreateProveedorUseCaseImpl implements CreateProveedorUseCase {

	private DAOFactory factory;

	@Override
	public void execute(ProveedorDTO person) {
		factory.getProveedorDAO().create(person);

	}

	public CreateProveedorUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
}
