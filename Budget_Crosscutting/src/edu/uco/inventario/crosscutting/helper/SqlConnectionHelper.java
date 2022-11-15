package edu.uco.inventario.crosscutting.helper;

import java.sql.Connection;
import java.sql.SQLException;

import edu.uco.inventario.crosscutting.exception.data.CrosscuttingCustomException;
import edu.uco.inventario.crosscutting.messages.Messages;

public final class SqlConnectionHelper {

	private SqlConnectionHelper() {
		super();
	}
	
	public static final boolean connectionIsNull(final Connection connection) {
		return ObjectHelper.isNull(connection);
	}

	public static final boolean connectionIsOpen(final Connection connection) {
		try {
			return  !connectionIsNull(connection)&& !connection.isClosed();
		}catch (final SQLException exception) {
			throw CrosscuttingCustomException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED,exception);
		}
		
	}
	public static final void closeConnection(final Connection connection) {
		
		try {
			if(!connectionIsOpen(connection)) {
				throw CrosscuttingCustomException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_ALREADY_IS_CLOSED);
		}
			connection.close();
		}catch(CrosscuttingCustomException exception) {
			throw exception;
		}
		
		catch(final SQLException exception) {
			throw CrosscuttingCustomException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED,exception);
		}
	}
	
public static final void initTransaction(final Connection connection) {
		
		try {
			if(connectionIsOpen(connection)) {
				throw CrosscuttingCustomException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED_FOR_INIT_TRANSACTION);
		}
			connection.setAutoCommit(false);
		}catch(CrosscuttingCustomException exception) {
			throw exception;
		}catch(final SQLException exception) {
			throw CrosscuttingCustomException.createTechnicalException(
					Messages.SqlConnectionHelper.TECHNICAL_TRY_INIT_TRANSACTION,exception);
		}
	}

	public static final void commitTransaction(final Connection connection) {
		
		try {
			if(connectionIsOpen(connection)) {
				throw CrosscuttingCustomException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED_FOR_COMMIT_TRANSACTION);
		}
			connection.setAutoCommit(false);
		}catch(CrosscuttingCustomException exception) {
			throw exception;
		}
		
		catch(final SQLException exception) {
			throw CrosscuttingCustomException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_TRY_INIT_TRANSACTION);
		}
}
	
}
