package edu.uco.budget.service.command.implementation;


import edu.uco.budget.crosscutting.exception.BudgetCustomException;
import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.service.command.CreatePersonCommand;

import edu.uco.budget.service.usecase.person.CreatePersonUseCase;
import edu.uco.budget.service.usecase.person.implementation.CreatePersonUseCaseImpl;

public class CreatePersonCommandImpl  implements CreatePersonCommand{
	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.SQL_SERVER);
	private final CreatePersonUseCase useCase = new CreatePersonUseCaseImpl(factory);

	@Override
	public void execute(PersonDTO person) throws Throwable {
		try {
			factory.initTransaction();
			//usecase execution
			useCase.execute(person);
			factory.confirmTransaction();
		}catch(BudgetCustomException exception) {
			
			factory.cancelTransaction();
			throw exception;
		}catch(final Exception exception) {
			factory.cancelTransaction();
		}finally {
			factory.closeConnection();
		}
		
	}

}
