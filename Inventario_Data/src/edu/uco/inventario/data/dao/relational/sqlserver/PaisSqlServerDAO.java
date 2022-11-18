package edu.uco.inventario.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.uco.inventario.crosscutting.exception.data.DataCustomException;
import edu.uco.inventario.crosscutting.helper.ObjectHelper;
import edu.uco.inventario.crosscutting.helper.UUIDHelper;
import edu.uco.inventario.crosscutting.messages.Messages;
import edu.uco.inventario.data.dao.PaisDAO;
import edu.uco.inventario.data.dao.relational.DAORelational;
import edu.uco.inventario.domain.PaisDTO;

public class PaisSqlServerDAO extends DAORelational implements PaisDAO {

	public PaisSqlServerDAO(final Connection connection) {
		super(connection);

	}

	@Override
	public final List<PaisDTO> find(PaisDTO paisDTO) {

		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, paisDTO, paramenters);
		createOrderBy(sqlBuilder);
		return prepareAndExecuteQuery(sqlBuilder, paramenters);
	}

	private final void createSelectFrom(final StringBuilder sqlBuilder) {
		sqlBuilder.append("SELECT         Id As IdPais, ");
		sqlBuilder.append("              nombre As Nombre, ");

		sqlBuilder.append("From Pais");
	}

	private final void createWhere(final StringBuilder sqlBuilder, final PaisDTO usuario,
			final List<Object> parameters) {

		if (!ObjectHelper.isNull(usuario) && !UUIDHelper.isDefualtUUID(usuario.getId())) {

			sqlBuilder.append("WHERE id= ? ");

			parameters.add(usuario.getIdAsString());

		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY nombre ASC ");

	}

	private final List<PaisDTO> executeQuery(PreparedStatement preparedStatement) {
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

	private final List<PaisDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder,
			final List<Object> parameters) {
		try (final var preparedStatement = getConnection()
				.prepareStatement(sqlBuilder.toString())) {

			setParameterValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);
		} catch (final DataCustomException exception) {
			throw exception;

		} catch (final SQLException exception) {

			throw DataCustomException.createTechnicalException(
					Messages.PersonSqlServerDAO.TECHNICAL_PROBLEM_PREPARED_STATEMENT,
					exception);
		} catch (final Exception exception) {

			throw DataCustomException.createTechnicalException(
					Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT,
					exception);
		}
	}

	private final List<PaisDTO> fillResults(final ResultSet resultSet) {
		try {
			var results = new ArrayList<PaisDTO>();
			while (resultSet.next()) {

				results.add(fillPaisDTO(resultSet));
			}
			return results;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(
					Messages.PersonSqlServerDAO.TECHNICAL_PROBLEM_FILL_RESULTS,
					exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS,
					exception);
		}

	}

	private final PaisDTO fillPaisDTO(final ResultSet resultSet) {
		try {
			return PaisDTO.create(resultSet.getString("IdPais"),
					resultSet.getString("IdNombrePais"));

		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(
					Messages.PersonSqlServerDAO.TECHNICAL_PROBLEM_FILL_PERSON_DTO,
					exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_PERSON_DTO,
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
					Messages.PersonSqlServerDAO.TECHNICAL_PROBLEM_SET_PARAMETER_VALUES_QUERY,
					exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMETER_VALUES_QUERY,
					exception);
		}

	}

}
