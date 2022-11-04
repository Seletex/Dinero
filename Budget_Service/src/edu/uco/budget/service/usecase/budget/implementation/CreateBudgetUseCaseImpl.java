package edu.uco.budget.service.usecase.budget.implementation;



import edu.uco.budget.data.daofactory.DAOFactory;

import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.usecase.budget.CreateBudgetUseCase;

public final class CreateBudgetUseCaseImpl implements CreateBudgetUseCase{

	private final DAOFactory factory;
	
	
	@Override
	public void execute(BudgetDTO budget) {
		factory.getBudgetDAO().create(budget);
	}
	public CreateBudgetUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	

}
