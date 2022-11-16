package edu.uco.inventario.data.daofactory;

import java.sql.Connection;

import edu.uco.inventario.crosscutting.helper.SqlConnectionHelper;
import edu.uco.inventario.crosscutting.messages.Messages;
import edu.uco.inventario.data.dao.UsuarioDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.UsuarioSqlServerDAO;
import edu.uco.inventario.data.enumeration.DAOFactoryType;

public class DAOFactory {

	Connection connection = null;

	public static final DAOFactory getDAOFactory(final DAOFactoryType factory) {

		DAOFactory daoFactory = null;

		switch (factory) {
		case SQL_SERVER:
			daoFactory = new SqlServerDAOFactory();
			break;
		case CASSANDRA:
			throw new RuntimeException(
					Messages.DAOFactory.TECHNICAL_CASSANDRA_NOT_IMPLEMENT);

		case MARIADB:
			throw new RuntimeException(
					Messages.DAOFactory.TECHNICAL_MARIADB_NOT_IMPLEMENT);

		case MONGODB:
			throw new RuntimeException(
					Messages.DAOFactory.TECHNICAL_MONDGODB_NOT_IMPLEMENT);

		case MYSQL:
			throw new RuntimeException(Messages.DAOFactory.TECHNICAL_MYSQL_NOT_IMPLEMENT);

		case POSTGRESQL:
			throw new RuntimeException(
					Messages.DAOFactory.TECHNICAL_POSTGRESQL_NOT_IMPLEMENT);

		default:
			throw new RuntimeException(
					Messages.DAOFactory.TECHNICAL_UNEXPECTED_DAOFACTORY);
		}

		return daoFactory;
	}

	protected void openConexion() {
		connection = null;
	}

	public void initTransaction() {
	}

	public void confirmTransaction() {
		SqlConnectionHelper.closeConnection(connection);
	}

	public void cancelTransaction() {

	}

	public void closeConnection() {

	}

	public UsuarioDAO getUsuarioDAO() {

		return new UsuarioSqlServerDAO(connection);
	}

}
