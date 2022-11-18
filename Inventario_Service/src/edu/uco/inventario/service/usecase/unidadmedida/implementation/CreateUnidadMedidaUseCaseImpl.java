package edu.uco.inventario.service.usecase.unidadmedida.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.UnidadMedidaDTO;
import edu.uco.inventario.service.usecase.unidadmedida.CreateUnidadMedidaUseCase;

public class CreateUnidadMedidaUseCaseImpl implements CreateUnidadMedidaUseCase {

	@SuppressWarnings("unused")
	private DAOFactory factory;

	public CreateUnidadMedidaUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public void execute(UnidadMedidaDTO person) {
		factory.getUnidadMedidaDAO();

	}
}
