package edu.uco.inventory.data.daofactory;

import java.sql.Connection;

import edu.uco.inventory.data.dao.PaisDAO;
import edu.uco.inventory.data.dao.relational.sqlserver.PaisSqlServerDAO;

public final class SqlServerDAOFactory extends DAOFactory {

	private Connection connection;

	SqlServerDAOFactory() {
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
	public PaisDAO getPaisDAO() {
		return new PaisSqlServerDAO(connection);
	}

	

}
