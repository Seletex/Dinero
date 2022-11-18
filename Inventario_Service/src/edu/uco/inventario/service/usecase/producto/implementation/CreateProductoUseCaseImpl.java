package edu.uco.inventario.service.usecase.producto.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.ProductoDTO;
import edu.uco.inventario.service.usecase.producto.CreateProductoUseCase;

public class CreateProductoUseCaseImpl implements CreateProductoUseCase {

	private DAOFactory factory;

	@Override
	public void execute(ProductoDTO person) {
		factory.getProductoDAO().create(person);

	}

	public CreateProductoUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
}
