package edu.uco.budget.data.daofactory;

import java.sql.Connection;

import edu.uco.budget.crosscutting.helper.SqlConnectionHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.dao.relational.sqlserver.BudgetSqlServerDAO;
import edu.uco.budget.data.dao.relational.sqlserver.PersonSqlServerDAO;
import edu.uco.budget.data.dao.relational.sqlserver.YearSqlServerDAO;
import edu.uco.budget.data.enumeration.DAOFactoryType;

public abstract class DAOFactory {
	Connection connection = null;

	public static final DAOFactory getDAOFactory(final DAOFactoryType factory) {

		DAOFactory daoFactory = null;
		

		switch (factory) {
		case SQL_SERVER:
			daoFactory = new SqlServerDAOFactory();
			break;
		case CASSANDRA:
			throw new RuntimeException(Messages.DAOFactory.TECHNICAL_CASSANDRA_NOT_IMPLEMENT);

		case MARIADB:
			throw new RuntimeException(Messages.DAOFactory.TECHNICAL_MARIADB_NOT_IMPLEMENT);

		case MONGODB:
			throw new RuntimeException(Messages.DAOFactory.TECHNICAL_MONDGODB_NOT_IMPLEMENT);

		case MYSQL:
			throw new RuntimeException(Messages.DAOFactory.TECHNICAL_MYSQL_NOT_IMPLEMENT);

		case POSTGRESQL:
			throw new RuntimeException(Messages.DAOFactory.TECHNICAL_POSTGRESQL_NOT_IMPLEMENT);

		default:
			throw new RuntimeException(Messages.DAOFactory.TECHNICAL_UNEXPECTED_DAOFACTORY);
		}

		return daoFactory;
	}

	protected void openConexion() {
		 connection = null;
	}

	public abstract void initTransaction() throws Throwable;

	public void confirmTransaction() {
		SqlConnectionHelper.closeConnection(connection);
	}

	public void cancelTransaction() {

	}

	public void closeConnection() {

	}

	public BudgetDAO getBudgetDAO() {
		return new BudgetSqlServerDAO(connection);
	}

	public PersonDAO getPersonDAO() {
		return new PersonSqlServerDAO(connection);
	}

	public YearDAO getYearDAO() {
		return new YearSqlServerDAO(connection);
	}

}
