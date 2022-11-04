package edu.uco.budget.service.usecase.person.implementation;

import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.service.usecase.person.CreatePersonUseCase;

public class CreatePersonUseCaseImpl implements CreatePersonUseCase {
	private final DAOFactory factory;

	@Override
	public void execute(PersonDTO person) {

		factory.getPersonDAO().create(person);

	}

	public CreatePersonUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

}
