package edu.uco.inventario.service.command.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.SalidaDTO;
import edu.uco.inventario.service.usecase.salida.CreateSalidaUseCase;

public class CreateSalidaCommandImpl implements CreateSalidaUseCase {
	
	private DAOFactory factory ;

	@Override
	public void execute(SalidaDTO person) {
		factory.getSalidaDAO().create(person);
		
	}
	
	public CreateSalidaCommandImpl(DAOFactory factory) {
		this.factory = factory;
	}
}
