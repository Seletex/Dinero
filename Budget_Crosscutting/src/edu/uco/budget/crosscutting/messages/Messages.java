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
	}

}
