package edu.uco.budget.service.usecase.budget.implementation;

import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.usecase.budget.CreateBudgetUseCase;


public final class CreateBudgetUseCaseImpl implements CreateBudgetUseCase{

	private DAOFactory factory;
	
	public final void CreateBudgetUseCase(DAOFactory factory) {
		this.factory=factory;
	}
	@Override
	public void execute(BudgetDTO budget) {
		DAOFactory.getDAOFactory(DAOFactoryType.SQL_SERVER).getBudgetDAO().create(budget);
	}

}
