package edu.uco.inventario.service.command.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.TipoUnidadDTO;
import edu.uco.inventario.service.command.CreateTipoUnidadCommand;

public class CreateTipoUnidadCommandImpl implements CreateTipoUnidadCommand {

	private DAOFactory factory;

	@Override
	public void execute(TipoUnidadDTO person) {
		factory.getTipoUnidadDAO().create(person);

	}

	public CreateTipoUnidadCommandImpl(DAOFactory factory) {
		this.factory = factory;
	}
}
