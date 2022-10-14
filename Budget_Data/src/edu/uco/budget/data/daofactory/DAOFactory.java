package edu.uco.budget.data.daofactory;

import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.YearDAO;

public abstract class DAOFactory {
	
	public static final DAOFactory getDAOFactory() {
		return new SqlServerDAOFactory();
	}
	
	protected abstract void openConexion();
	
	public abstract void initTransaction();
	
	public abstract void confirmTransaction();
	
	public abstract void cancelTransaction();
	
	public abstract void closeConnection();
	
	public abstract BudgetDAO getBudgetDAO();
	
	public abstract PersonDAO getPersonDAO();
	
	public abstract YearDAO getYearDAO();

}
