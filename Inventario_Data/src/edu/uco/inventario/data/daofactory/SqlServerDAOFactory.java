package edu.uco.inventario.data.daofactory;

import static edu.uco.inventario.crosscutting.helper.SqlConnectionHelper.connectionIsOpen;

import edu.uco.inventario.crosscutting.exception.data.CrosscuttingCustomException;
import edu.uco.inventario.crosscutting.exception.data.DataCustomException;
import edu.uco.inventario.crosscutting.helper.SqlConnectionHelper;
import edu.uco.inventario.crosscutting.messages.Messages;
import edu.uco.inventario.data.dao.UsuarioDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.UsuarioSqlServerDAO;

public class SqlServerDAOFactory extends DAOFactory {

	

	SqlServerDAOFactory() {
		openConexion();
	}
	@Override
	protected void openConexion() {
		connectionIsOpen(connection);
	}
	@Override
	public void initTransaction()  {
		
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
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioSqlServerDAO(connection);
	}
	
	

}