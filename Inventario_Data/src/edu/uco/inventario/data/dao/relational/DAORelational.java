package edu.uco.inventario.data.dao.relational;

import static edu.uco.inventario.crosscutting.helper.SqlConnectionHelper.connectionIsOpen;

import java.sql.Connection;

import edu.uco.inventario.crosscutting.messages.Messages;

public class DAORelational {
	
	private Connection connection;

	protected DAORelational(final Connection connection) {
		
		if(!connectionIsOpen(connection)) {
			throw new RuntimeException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_NULL);
		}
		
		this.connection = connection;
		
	}

	protected final Connection getConnection() {
		return connection;
	}

}
