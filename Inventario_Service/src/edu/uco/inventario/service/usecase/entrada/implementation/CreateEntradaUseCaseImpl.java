package edu.uco.inventario.service.usecase.entrada.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.EntradaDTO;
import edu.uco.inventario.service.usecase.entrada.CreateEntradaUseCase;

public class CreateEntradaUseCaseImpl implements CreateEntradaUseCase {

	private DAOFactory factory;

	@Override
	public void execute(EntradaDTO person) {
		factory.getEntradaDAO().create(person);

	}

	public CreateEntradaUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
}
