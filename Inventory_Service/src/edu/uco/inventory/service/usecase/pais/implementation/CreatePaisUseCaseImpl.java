package edu.uco.inventory.service.usecase.pais.implementation;

import edu.uco.inventory.data.daofactory.DAOFactory;
import edu.uco.inventory.data.enumeration.DAOFactoryType;
import edu.uco.inventory.domain.PaisDTO;
import edu.uco.inventory.service.usecase.pais.CreatePaisUseCase;

public class CreatePaisUseCaseImpl implements CreatePaisUseCase{

	@Override
	public void execute(PaisDTO pais) {
		DAOFactory.getDAOFactory(DAOFactoryType.SQL_SERVER).getPaisDAO().create(pais);
		
	}

}
