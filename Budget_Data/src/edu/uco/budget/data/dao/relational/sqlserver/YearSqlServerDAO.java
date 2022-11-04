package edu.uco.budget.data.dao.relational.sqlserver;

import static edu.uco.budget.crosscutting.helper.StringHelper.getUUIDAsString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			final var message = Messages.YearSqlServerDAO.TECHNICAL_PROBLEM_CREATE_YEAR
					.concat(year.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {

			String message = Messages.YearSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_YEAR
					.concat(year.getIdAsString());
			DataCustomException.createTechnicalException(message, exception);
		}

	}

	@Override
	public final List<YearDTO> find(YearDTO year) {
		
		
		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, year, paramenters);
		createOrderBy(sqlBuilder);
		return prepareAndExecuteQuery(sqlBuilder,paramenters);

		

		

		

		
	}

	private final List<YearDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder,final List<Object> parameters) {
		try (final var preparedStatement = getConnection()
				.prepareStatement(sqlBuilder.toString())) {

			setParameterValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);
		} catch (final DataCustomException exception) {
			throw exception;

		} catch (final SQLException exception) {

			throw DataCustomException.createTechnicalException(
					Messages.YearSqlServerDAO.TECHNICAL_PROBLEM_PREPARED_STATEMENT,
					exception);
		} catch (final Exception exception) {

			throw DataCustomException.createTechnicalException(
					Messages.YearSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT,
					exception);
		}
	}

	private final void setParameterValues(final PreparedStatement preparedStatement,
			final List<Object> paramenters) {
		try {
			for (int index = 0; index < paramenters.size(); index++) {
				preparedStatement.setObject(index + 1, paramenters.get(index));
			}
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(
					Messages.YearSqlServerDAO.TECHNICAL_PROBLEM_SET_PARAMETER_VALUES_QUERY,
					exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.YearSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMETER_VALUES_QUERY,
					exception);
		}

	}

	private final void createSelectFrom(final StringBuilder sqlBuilder) {
		sqlBuilder.append("SELECT         Id As IdYear, ");
		sqlBuilder.append("              IdYearNumber As Year");

		sqlBuilder.append(" FROM Year  ");
	}

	private final void createWhere(final StringBuilder sqlBuilder, final YearDTO year,
			final List<Object> parameters) {
		if (!ObjectHelper.isNull(year)) {
			if(!UUIDHelper.isDefualtUUID(year.getId())) {
				sqlBuilder.append("WHERE id = ? ");
				parameters.add(year.getIdAsString());
			}

		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY numberYear ASC ");
		
	}

	private final List<YearDTO> executeQuery(PreparedStatement preparedStatement) {
		try (final var resultSet = preparedStatement.executeQuery()) {
			return fillResults(resultSet);
		} catch (final DataCustomException exception) {
			throw exception;

		} catch (final SQLException exception) {

			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_EXECUTE_QUERY,
					exception);
		} catch (final Exception exception) {

			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECUTE_QUERY,
					exception);
		}

	}
	private final List<YearDTO> fillResults(final ResultSet resultSet) {
		try {
			var results = new ArrayList<YearDTO>();
			while (resultSet.next()) {

				results.add(fillYearDTO(resultSet));
			}
			return results;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_FILL_RESULTS,
					exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS,
					exception);
		}

	}
	private final YearDTO fillYearDTO(final ResultSet resultSet) {
		try {
			return YearDTO.create(resultSet.getString("IdYear"),
					resultSet.getInt("NumberYear"));
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_FILL_YEAR_DTO,
					exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_YEAR_DTO,
					exception);
		}
	}
	@Override
	public final void update(YearDTO year) {
		final var sql = "UPDATE YEAR SET idYearNumber=? WHERE id=?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, year.getIdAsString());
			preparedStatement.setLong(2, year.getYearNumber());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			final var message = Messages.YearSqlServerDAO.TECHNICAL_PROBLEM_UPDATE_YEAR
					.concat(year.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			final var message = Messages.YearSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_YEAR
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
			final var message = Messages.YearSqlServerDAO.TECHNICAL_PROBLEM_DELETE_YEAR;
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {

			final var message = Messages.YearSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_YEAR;
			throw DataCustomException.createTechnicalException(message , exception);
		}
	}

	}


