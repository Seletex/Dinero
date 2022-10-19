package edu.uco.budget.service.usecase.year.implementation;

import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.YearDTO;
import edu.uco.budget.service.usecase.year.CreateYearUseCase;

public class CreateYearUseCaseImpl implements CreateYearUseCase {

	@Override
	public void execute(YearDTO year) {
		DAOFactory.getDAOFactory(DAOFactoryType.SQL_SERVER).getYearDAO().create(year);
		
	}

}
