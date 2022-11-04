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

	public static class UUIDHelper{
		private UUIDHelper() {
			super();
		}
		public static final String TECHNICAL_UUID_FROM_STRING_INVALID = "The UUID to convert doesnot have a valid format";
		public static final String TECHNICAL_UUID_FROM_STRING_UNEXPECTED_ERROR = "There was an unexpected excption trying to convert a UUID from String";
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
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FIND_BUDGET = "There was a Problem recovering from the select";
		public static final String TECHNICAL_PROBLEM_FILL_RESULTS = "There was an unexpected problem to recovering trying  from the select";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS = "There was an unexpected problem to recovering trying  from the select";
		public static final String TECHNICAL_PROBLEM_FILL_BUDGET_DTO = "There was an unexpected problem to recovering trying  from the select";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_BUDGET_DTO = "There was an unexpected problem to recovering trying  from the select";
		public static final String TECHNICAL_PROBLEM_FILL_YEAR_DTO = "There was an unexpected problem to recovering trying  from the select";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_YEAR_DTO = "There was an unexpected problem to recovering trying  from the select";
		public static final String TECHNICAL_PROBLEM_FILL_PERSON_DTO = "There was an unexpected problem to recovering trying  from the select";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_PERSON_DTO = "There was an unexpected problem to recovering trying  from the select";
		public static final String PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem";
		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "Trying to execute query to find the specific budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific budget";
		public static final String TECHNICAL_PROBLEM_SET_PARAMETER_VALUES_QUERY = "Trying to execute query to set the paramenter values to the query";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMETER_VALUES_QUERY = "There was an unexpected problem trying to set the paramenter values to the query";
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to to prepare the sql statement";
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
		public static final String PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem";
		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "Trying to execute query to find the specific budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific budget";
		public static final String TECHNICAL_PROBLEM_SET_PARAMETER_VALUES_QUERY = "Trying to execute query to set the paramenter values to the query";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMETER_VALUES_QUERY = "There was an unexpected problem trying to set the paramenter values to the query";
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to to prepare the sql statement";
		public static final String TECHNICAL_PROBLEM_FILL_RESULTS = "There was an unexpected problem to recovering trying  from the select";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS = "There was an unexpected problem to recovering trying  from the select";
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
		public static final String TECHNICAL_PROBLEM_FILL_PERSON_DTO = "There was an unexpected problem to recovering trying  from the select";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_PERSON_DTO = "There was an unexpected problem to recovering trying  from the select";
		public static final String PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem";
		public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "Trying to execute query to find the specific budget";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY = "There was an unexpected problem trying to execute query to find the specific budget";
		public static final String TECHNICAL_PROBLEM_SET_PARAMETER_VALUES_QUERY = "Trying to execute query to set the paramenter values to the query";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMETER_VALUES_QUERY = "There was an unexpected problem trying to set the paramenter values to the query";
		public static final String TECHNICAL_PROBLEM_PREPARED_STATEMENT = "There was a problem trying to prepare the sql statement ";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT = "There was an unexpected problem trying to to prepare the sql statement";
		public static final String TECHNICAL_PROBLEM_FILL_RESULTS = "There was an unexpected problem to recovering trying  from the select";
		public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS = "There was an unexpected problem to recovering trying  from the select";
	}

}
