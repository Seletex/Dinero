package edu.uco.budget.data.dao.relational;

import static edu.uco.budget.crosscutting.helper.SqlConnectionHelper.connectionIsOpen;

import java.sql.Connection;

import edu.uco.budget.crosscutting.messages.Messages;

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
