package edu.uco.inventario.service.command.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.SeccionDTO;
import edu.uco.inventario.service.command.CreateSeccionCommand;

public class CreateSeccionCommandImpl implements CreateSeccionCommand {
	
	private DAOFactory factory ;

	@Override
	public void execute(SeccionDTO person) {
		factory.getSeccionDAO().create(person);
		
	}
	
	public CreateSeccionCommandImpl(DAOFactory factory) {
		this.factory = factory;
	}
}
