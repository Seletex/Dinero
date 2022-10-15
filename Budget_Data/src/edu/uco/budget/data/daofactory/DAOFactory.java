package edu.uco.budget.data.daofactory;

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

	protected abstract void openConexion();

	public abstract void initTransaction();

	public abstract void confirmTransaction();

	public abstract void cancelTransaction();

	public abstract void closeConnection();

	public abstract BudgetDAO getBudgetDAO();

	public abstract PersonDAO getPersonDAO();

	public abstract YearDAO getYearDAO();

}
