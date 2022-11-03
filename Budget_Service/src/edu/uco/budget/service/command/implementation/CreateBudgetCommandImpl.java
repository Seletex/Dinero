package edu.uco.budget.service.command.implementation;

import edu.uco.budget.crosscutting.exception.BudgetCustomException;
import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.command.CreateBudgetCommand;
import edu.uco.budget.service.usecase.budget.CreateBudgetUseCase;

public class CreateBudgetCommandImpl implements CreateBudgetCommand {
	
	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.SQL_SERVER);
	private final CreateBudgetUseCase useCase = new CreateBudgetUseCase(factory);
	
	@Override
	public void execute(BudgetDTO budget) {
		try {
			try {
				factory.initTransaction();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//usecase execution
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
