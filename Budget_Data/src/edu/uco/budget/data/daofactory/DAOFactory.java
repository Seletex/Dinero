package edu.uco.budget.data.daofactory;

import static edu.uco.budget.crosscutting.helper.ExceptionHelper.ConfimTransaction;
import static edu.uco.budget.crosscutting.helper.ExceptionHelper.ItinialTransaction;
import static edu.uco.budget.crosscutting.helper.SqlConnectionHelper.connectionIsOpen;

import java.sql.Connection;
import java.sql.SQLException;

import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.enumeration.DAOFactoryType;

public abstract class DAOFactory {

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

	protected void openConexion(final Connection connection) {
		connectionIsOpen(connection);
	}

	public void initTransaction(final Connection connection) throws Throwable {
		ItinialTransaction(connection);
	}

	public void confirmTransaction(final Connection connection) throws Throwable {
		ConfimTransaction(connection);
	};

	public boolean cancelTransaction(final Connection connection) {
		try {
			return !connectionIsOpen(connection)&& !connection.isClosed();
		} catch (SQLException exception) {
			throw new RuntimeException(exception.getMessage());
		}
	}

	public abstract void closeConnection();

	public abstract BudgetDAO getBudgetDAO();

	public abstract PersonDAO getPersonDAO();

	public abstract YearDAO getYearDAO();

	public void cancelTransaction() {
		// TODO Auto-generated method stub
		
	}

	

	public void initTransaction() {
		// TODO Auto-generated method stub
		
	}

	public void confirmTransaction() {
		// TODO Auto-generated method stub
		
	}

	protected void openConexion() {
		// TODO Auto-generated method stub
		
	}

}
