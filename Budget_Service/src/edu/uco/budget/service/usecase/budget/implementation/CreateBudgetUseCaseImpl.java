package edu.uco.budget.service.usecase.budget.implementation;



import java.util.List;
import java.util.UUID;

import edu.uco.budget.crosscutting.exception.BudgetCustomException;
import edu.uco.budget.crosscutting.exception.service.ServiceCustomException;
import edu.uco.budget.crosscutting.helper.UUIDHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.domain.YearDTO;
import edu.uco.budget.service.usecase.budget.CreateBudgetUseCase;
import edu.uco.budget.service.usecase.person.FindPersonById;
import edu.uco.budget.service.usecase.person.implementation.FindPersonByIdImpl;
import edu.uco.budget.service.usecase.year.implementation.FindNextYearUseCaseImpl;

public final class CreateBudgetUseCaseImpl implements CreateBudgetUseCase{

	private final DAOFactory factory;
	private final FindNextYearUseCaseImpl findNextYearUseCaseImpl;
	private final FindPersonById findPersonById;
	
	public CreateBudgetUseCaseImpl(final DAOFactory factory) {
		this.factory = factory;
		findNextYearUseCaseImpl = new FindNextYearUseCaseImpl(factory);
		findPersonById = new FindPersonByIdImpl(factory);
	}
	
	@Override
	public void execute(final BudgetDTO budget) throws Throwable {
		try{
			final YearDTO year = findNextYearUseCaseImpl.execute();
		
		final PersonDTO person = findPerson(budget.getPersona().getId());
		budget.setYear(year);
		budget.setPersona(person);
		validateIfBudgetExist(budget);
		
		budget.setId(UUIDHelper.getNewUUID());
		
		
		factory.getBudgetDAO().create(budget);
		}catch(ServiceCustomException exception) {
			throw exception;
		}catch(BudgetCustomException exception) {
			throw exception;
		}catch(Exception exception) {
			throw exception;
		}
	}
	//1 hora 30 minutos
	private final PersonDTO findPerson(final UUID id) throws Exception {
		final PersonDTO person = findPersonById.execute(id); 
		if(person.notExist()) {
			throw ServiceCustomException.createUserException(Messages.
					ServiceCustomException.BUSINESS_PERSON_DOES_NOT_EXIST);
		}
		return person;
	}
	private final void validateIfBudgetExist(BudgetDTO budget) {
		List<BudgetDTO> results = factory.getBudgetDAO().find(budget);
		if(!results.isEmpty()) {
			throw ServiceCustomException.createUserException(Messages.ServiceCustomException.BUSINESS_BUDGET_EXIST);
		}
	}
	
	
	

}
