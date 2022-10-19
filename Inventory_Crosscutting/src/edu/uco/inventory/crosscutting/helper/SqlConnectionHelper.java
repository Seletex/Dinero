package edu.uco.inventory.crosscutting.helper;

import java.sql.Connection;
import java.sql.SQLException;

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
			throw new RuntimeException(exception.getMessage());
		}
		
	}
}
