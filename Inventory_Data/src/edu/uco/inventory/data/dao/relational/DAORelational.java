package edu.uco.inventory.data.dao.relational;

import java.sql.Connection;

import static edu.uco.inventory.crosscutting.helper.SqlConnectionHelper.connectionIsOpen;
import edu.uco.inventory.crosscutting.messages.Messages;

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
