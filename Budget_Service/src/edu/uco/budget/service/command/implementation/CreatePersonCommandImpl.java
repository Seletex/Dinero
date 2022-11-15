package edu.uco.budget.service.command.implementation;


import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.service.command.CreatePersonCommand;

import edu.uco.budget.service.usecase.person.CreatePersonUseCase;
import edu.uco.budget.service.usecase.person.implementation.CreatePersonUseCaseImpl;
import edu.uco.inventario.crosscutting.exception.BudgetCustomException;

public class CreatePersonCommandImpl  implements CreatePersonCommand{
	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.SQL_SERVER);
	private final CreatePersonUseCase useCase = new CreatePersonUseCaseImpl(factory);

	@Override
	public void execute(PersonDTO person) {
		try {
			try {
				factory.initTransaction();
			} catch (Throwable e) {

				e.printStackTrace();
			}
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
