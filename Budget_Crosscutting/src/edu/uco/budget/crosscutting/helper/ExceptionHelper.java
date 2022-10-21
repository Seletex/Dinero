package edu.uco.budget.crosscutting.helper;

import static edu.uco.budget.crosscutting.helper.SqlConnectionHelper.connectionIsNull;
import static edu.uco.budget.crosscutting.helper.SqlConnectionHelper.connectionIsOpen;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.SQLNonTransientException;
import java.sql.SQLTransientConnectionException;
public class ExceptionHelper {

	private ExceptionHelper() {
		super();
	}

	public static final boolean AccesException(final Connection connection) {
		return connectionIsOpen(connection);
	}

	public static final boolean AccessException(final Connection connection) throws Throwable {
		try {
			return !connectionIsNull(connection) && !connection.isClosed();
		} catch (final SQLInvalidAuthorizationSpecException exception) {
			throw new RuntimeException(exception.getMessage());
		}

	}
	
	public static final boolean ItinialTransaction(final Connection connection) throws Throwable, Throwable {
		try {
			return !AccessException(connection)&& !connection.isClosed();
		}catch(SQLNonTransientException exception) {
			throw new RuntimeException(exception.getMessage());
		}
	}
	
	public static final boolean ConfimTransaction(final Connection connection) throws Throwable, Throwable {
		try {
			return !AccessException(connection)&& !connection.isClosed();
		}catch(SQLTransientConnectionException exception) {
			throw new RuntimeException(exception.getMessage());
		}
	}
}
