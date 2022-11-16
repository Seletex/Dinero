package edu.uco.budget.data.daofactory;



import static edu.uco.budget.crosscutting.helper.SqlConnectionHelper.connectionIsOpen;

import edu.uco.budget.crosscutting.exception.data.CrosscuttingCustomException;
import edu.uco.budget.crosscutting.exception.data.DataCustomException;
import edu.uco.budget.crosscutting.helper.SqlConnectionHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.dao.relational.sqlserver.BudgetSqlServerDAO;
import edu.uco.budget.data.dao.relational.sqlserver.PersonSqlServerDAO;
import edu.uco.budget.data.dao.relational.sqlserver.YearSqlServerDAO;

public final class SqlServerDAOFactory extends DAOFactory {

	

	SqlServerDAOFactory() {
		openConexion();
	}
	@Override
	protected void openConexion() {
		connectionIsOpen(connection);
	}
	@Override
	public void initTransaction() throws Throwable {
		
		try {
		SqlConnectionHelper.initTransaction(connection);
		}catch(CrosscuttingCustomException exception) {
			throw DataCustomException.createTechnicalException(Messages.SQLServerDAOFactory.TECHNICAL_PROBLEM_INIT_TRANSACTION, exception);
		}
		
	}

	@Override
	public void confirmTransaction() {
	}
		

	@Override
	public void cancelTransaction() {
		
	}

	@Override
	public void closeConnection() {

	}

	@Override
	public BudgetDAO getBudgetDAO() {
		return new BudgetSqlServerDAO(connection);
	}

	@Override
	public PersonDAO getPersonDAO() {

		return new PersonSqlServerDAO(connection);
	}

	@Override
	public YearDAO getYearDAO() {

		return new YearSqlServerDAO(connection);
	}

}
