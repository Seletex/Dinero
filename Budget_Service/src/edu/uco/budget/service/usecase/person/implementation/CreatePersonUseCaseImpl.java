package edu.uco.budget.service.usecase.person.implementation;

import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.service.usecase.person.CreatePersonUseCase;

public class CreatePersonUseCaseImpl implements CreatePersonUseCase{

	@Override
	public void execute(PersonDTO person) {
		DAOFactory.getDAOFactory(DAOFactoryType.SQL_SERVER).getPersonDAO().create(person);
		
	}

}
