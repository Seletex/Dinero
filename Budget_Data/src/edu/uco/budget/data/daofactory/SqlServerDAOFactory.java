package edu.uco.budget.data.daofactory;

import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.YearDAO;

public final class SqlServerDAOFactory extends DAOFactory {
	
	SqlServerDAOFactory(){
		openConexion();
	}

	@Override
	protected void openConexion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BudgetDAO getBudgetDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDAO getPersonDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public YearDAO getYearDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
