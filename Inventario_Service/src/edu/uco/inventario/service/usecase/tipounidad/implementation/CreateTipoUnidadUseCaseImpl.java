package edu.uco.inventario.service.usecase.tipounidad.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.TipoUnidadDTO;
import edu.uco.inventario.service.usecase.tipounidad.CreateTipoUnidadUseCase;

public class CreateTipoUnidadUseCaseImpl implements CreateTipoUnidadUseCase {

	private DAOFactory factory;

	@Override
	public void execute(TipoUnidadDTO person) {
		factory.getTipoUnidadDAO().create(person);

	}

	public CreateTipoUnidadUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

}
