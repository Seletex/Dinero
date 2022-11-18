package edu.uco.inventario.service.usecase.estanteria.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.EstanteriaDTO;
import edu.uco.inventario.service.usecase.estanteria.CreateEstanteriaUseCase;

public class CreateEstanteriaUseCaseImpl implements CreateEstanteriaUseCase {

	private DAOFactory factory;

	@Override
	public void execute(EstanteriaDTO person) {
		factory.getEstanteriaDAO().create(person);

	}

	public CreateEstanteriaUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
}
