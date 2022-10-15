package edu.uco.budget.service.usecase.budget.implementation;

import edu.uco.budget.data
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.usecase.budget.CreateBudgetUseCase;

public final class CreateBudgetUseCaseImpl implements CreateBudgetUseCase{

	@Override
	public void execute(BudgetDTO budget) {
		DAOFactory.getDAOFactory(DAOFactoryType.SQLSERVER).getBudgetDAO().create(budget);
	}

}
