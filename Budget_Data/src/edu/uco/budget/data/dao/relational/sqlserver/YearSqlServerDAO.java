package edu.uco.budget.data.dao.relational.sqlserver;

import static edu.uco.budget.crosscutting.helper.StringHelper.getUUIDAsString;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.crosscutting.exception.data.DataCustomException;
import edu.uco.budget.crosscutting.helper.ObjectHelper;
import edu.uco.budget.crosscutting.helper.UUIDHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.YearDTO;

public class YearSqlServerDAO extends DAORelational implements YearDAO {

	public YearSqlServerDAO(final Connection connection) {
		super(connection);
		
	}

	@Override
	public final void create(YearDTO year) {
		final var sql = "INSERT INTO YEAR(id, idYearNumber) VALUES (?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, year.getIdAsString());
			preparedStatement.setLong(2, year.getYearNumber());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			final var message = Messages.YearSqlServerDAO.TECHNICAL_PROBLEM_CREATE_BUDGET
					.concat(year.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {

			String message = Messages.YearSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_BUDGET
					.concat(year.getIdAsString());
			DataCustomException.createTechnicalException(message, exception);
		}

	}

	@Override
	public final List<YearDTO> find(YearDTO year) {
		var results = new ArrayList<YearDTO>();
		boolean setWhere = true;
		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append("SELECT         Id As IdYear, ");
		sqlBuilder.append("              IdYearNumber As Year, ");

		sqlBuilder.append(" FROM Year  ");

		if (!ObjectHelper.isNull(year)) {
			if (!UUIDHelper.isDefualtUUID(year.getId())) {
				sqlBuilder.append("WHERE Bu.id = ? ");
				setWhere = false;
				paramenters.add(year.getIdAsString());
			}

		}

		sqlBuilder.append("ORDER BY Pe.idCard ASC, ");
		sqlBuilder.append("              Ye.year ASC.");

		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {
			for (int index = 0; index < paramenters.size(); index++) {
				preparedStatement.setObject(index + 1, paramenters.get(index));
			}
			try (final var resultSet = preparedStatement.executeQuery()) {
				// fill the list with the results
			}
		} catch (SQLException exception) {
			final var message = Messages.YearSqlServerDAO.TECHNICAL_PROBLEM_FIND_BUDGET.concat(year.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (Exception exception) {
			final var message = Messages.YearSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FIND_BUDGET
					.concat(year.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		}

		return results;
	}

	@Override
	public final void update(YearDTO year) {
		final var sql = "UPDATE YEAR SET idYearNumber=? WHERE id=?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, year.getIdAsString());
			preparedStatement.setLong(2, year.getYearNumber());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			final var message = Messages.YearSqlServerDAO.TECHNICAL_PROBLEM_UPDATE_BUDGET
					.concat(year.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			final var message = Messages.YearSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_BUDGET
					.concat(year.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		}

	}

	@Override
	public final void delete(UUID id) {
		final var sql = "DELETE INTO YEAR WHERE id=?";
		final var idAsString = getUUIDAsString(id);

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, idAsString);

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			final var message = Messages.YearSqlServerDAO.TECHNICAL_PROBLEM_DELETE_BUDGET;
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {

			final var message = Messages.YearSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_BUDGET;
			throw DataCustomException.createTechnicalException(message , exception);
		}
	}

	}


