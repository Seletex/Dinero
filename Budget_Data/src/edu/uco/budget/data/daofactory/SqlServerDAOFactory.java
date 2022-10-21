package edu.uco.budget.data.daofactory;

import static edu.uco.budget.crosscutting.helper.ExceptionHelper.ItinialTransaction;

import java.sql.Connection;

import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.dao.relational.sqlserver.BudgetSqlServerDAO;
import edu.uco.budget.data.dao.relational.sqlserver.PersonSqlServerDAO;
import edu.uco.budget.data.dao.relational.sqlserver.YearSqlServerDAO;

public final class SqlServerDAOFactory extends DAOFactory {

	private Connection connection;

	SqlServerDAOFactory() {
		openConexion();
	}
	@Override
	protected void openConexion() {
		try {
			ItinialTransaction(connection);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void initTransaction() {

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
