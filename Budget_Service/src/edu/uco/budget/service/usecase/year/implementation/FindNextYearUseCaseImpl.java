package edu.uco.budget.service.usecase.year.implementation;

import java.util.List;

import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.domain.YearDTO;
import edu.uco.budget.service.usecase.year.FindNextYearUseCase;
import edu.uco.inventario.crosscutting.helper.DateHelper;
import edu.uco.inventario.crosscutting.helper.UUIDHelper;

public class FindNextYearUseCaseImpl implements FindNextYearUseCase{

	private final DAOFactory factory;
	
	public FindNextYearUseCaseImpl(DAOFactory factory) {
		this.factory=factory;
	}
	@Override
	public YearDTO execute() {
		YearDTO year = YearDTO.create("", DateHelper.getNextYear());
		final List<YearDTO> result = factory.getYearDAO().find(year);
		if(!result.isEmpty()) {
			year.setId(UUIDHelper.getNewUUID());
			factory.getYearDAO().create(year);
		}else {
			
			year = result.get(0);
		}
		
		return year;
	}

}
