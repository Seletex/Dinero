package edu.uco.budget.crosscutting.messages;

public class Messages {

	public static class DAOFactory {

		private DAOFactory() {
			super();
		}

		public static final String TECHNICAL_MONDGODB_NOT_IMPLEMENT = "DAOFactory for MongoDB is not implement yet";
		public static final String TECHNICAL_MARIADB_NOT_IMPLEMENT = "DAOFactory for MariaDB is not implement yet";
		public static final String TECHNICAL_CASSANDRA_NOT_IMPLEMENT = "DAOFactory for Cassandra is not implement yet";
		public static final String TECHNICAL_ORACLE_NOT_IMPLEMENT = "DAOFactory for Oracle is not implement yet";
		public static final String TECHNICAL_POSTGRESQL_NOT_IMPLEMENT = "DAOFactory for PostgreSQL is not implement yet";
		public static final String TECHNICAL_MYSQL_NOT_IMPLEMENT = "DAOFactory for Mysql is not implement yet";
		public static final String TECHNICAL_UNEXPECTED_DAOFACTORY = "Unexpected DAOFActory ";

	}

	public static class SqlConnectionHelper {
		private SqlConnectionHelper() {
			super();
		}

		public static final String TECHNICAL_CONNECTION_IS_NULL = "Connection is null";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED = "Connection is closed";
		public static final String TECHNICAL_CONNECTION_ALREADY_IS_CLOSED = "Connection already is closed";
		public static final String TECHNICAL_PROBLEM_CLOSING_CONNECTION = "there was a problem trying to close the connection. Please verify the technical details";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_INIT_TRANSACTION = "Connection is closed to start a new transaction";
		public static final String TECHNICAL_PROBLEM_TO_INIT_TRANSACTION_CONNECTION = "Connection is null";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_COMMIT_TRANSACTION = "Connection is closed to commit the current transaction";
		public static final String TECHNICAL_TRY_COMMIT_TRANSACTION = "There was a problem tryng to commit transaction. Please verify";
		public static final String TECHNICAL_TRY_INIT_TRANSACTION = "There was a problem tryng to current transaction. Please verify the technical error";
		public static final String TECHNICAL_TRY_ROLLBACK_TRANSACTION = "Connection is closed for commit transaction";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_ROLLBACK_TRANSACTION = "Connection already is closed";
		}

	public static class SQLServerDAOFactory {
		private SQLServerDAOFactory() {
			super();
		}

		public static final String TECHNICAL_CONNECTION_IS_NULL = "Connection is null";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED = "Connection is closed";
		public static final String TECHNICAL_CONNECTION_ALREADY_IS_CLOSED = "Connection already is closed";
		public static final String TECHNICAL_PROBLEM_CLOSING_CONNECTION = "there was a problem trying to close the connection. Please verify the technical details";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_INIT_TRANSACTION = "Connection already is closed";
		public static final String TECHNICAL_PROBLEM_TO_INIT_TRANSACTION_CONNECTION = "Connection is null";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_COMMIT_TRANSACTION = "Connection is closed for commit transaction";
		public static final String TECHNICAL_TRY_COMMIT_TRANSACTION = "Connection is closed for commit transaction";
		public static final String TECHNICAL_TRY_INIT_TRANSACTION = "Connection is closed for commit transaction";
		public static final String TECHNICAL_TRY_ROLLBACK_TRANSACTION = "Connection is closed for commit transaction";
		public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_ROLLBACK_TRANSACTION = "Connection already is closed";
		public static final String TECHNICAL_PROBLEM_INIT_TRANSACTION = "There was a problem  to star transaction";
		
	}

	public static class BudgetSqlServerDAO {
		private BudgetSqlServerDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_BUDGET = "There was a Problem trying to create desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_BUDGET = "There was a Problem trying to create desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_PROBLEM_UPDATE_BUDGET = "There was a Problem trying to update desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_BUDGET = "There was a Problem trying to update desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_PROBLEM_DELETE_BUDGET = "There was a Problem trying to delete desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_BUDGET = "There was a Problem trying to delete desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_PROBLEM_FIND_BUDGET = "There was a Problem trying to find desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FIND_BUDGET = "There was a Problem trying to find desired budget in SQLServerDAOFactory";
	}
	
	public static class YearSqlServerDAO {
		private YearSqlServerDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_YEAR = "There was a Problem trying to create desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_YEAR = "There was a Problem trying to create desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_PROBLEM_UPDATE_YEAR = "There was a Problem trying to update desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_YEAR = "There was a Problem trying to update desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_PROBLEM_DELETE_YEAR= "There was a Problem trying to delete desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_YEAR = "There was a Problem trying to delete desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_PROBLEM_FIND_YEAR = "There was a Problem trying to find desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FIND_YEAR = "There was a Problem trying to find desired budget in SQLServerDAOFactory";
	}
	
	public static class PersonSqlServerDAO {
		private PersonSqlServerDAO() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_PERSON = "There was a Problem trying to create desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_PERSON = "There was a Problem trying to create desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_PROBLEM_UPDATE_PERSON = "There was a Problem trying to update desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_PERSON = "There was a Problem trying to update desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_PROBLEM_DELETE_PERSON = "There was a Problem trying to delete desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_DELETE_PERSON = "There was a Problem trying to delete desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_PROBLEM_FIND_PERSON = "There was a Problem trying to find desired budget in SQLServerDAOFactory";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FIND_PERSON = "There was a Problem trying to find desired budget in SQLServerDAOFactory";
	}

}
