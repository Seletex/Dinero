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
import edu.uco.inventario.data.dao.CiudadDAO;
import edu.uco.inventario.data.dao.relational.DAORelational;
import edu.uco.inventario.domain.CiudadDTO;
import edu.uco.inventario.domain.DepartamentoDTO;
import edu.uco.inventario.domain.PaisDTO;

public class CiudadSqlServerDAO extends DAORelational implements CiudadDAO {

	public CiudadSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final List<CiudadDTO> find(CiudadDTO budget) {

		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, budget, paramenters);
		createOrderBy(sqlBuilder);
		return prepareAndExecuteQuery(sqlBuilder, paramenters);

		// private final void createWheres(final StringBuilder sqlBuilder,final
		// BudgetDTO budget, final List<Object> parameters) {

		// }

	}

	private final List<CiudadDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder,
			final List<Object> parameters) {
		try (final var preparedStatement = getConnection()
				.prepareStatement(sqlBuilder.toString())) {

			setParameterValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);
		} catch (final DataCustomException exception) {
			throw exception;

		} catch (final SQLException exception) {

			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_PREPARED_STATEMENT,
					exception);
		} catch (final Exception exception) {

			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STATEMENT,
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
					Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_SET_PARAMETER_VALUES_QUERY,
					exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMETER_VALUES_QUERY,
					exception);
		}

	}

	private final void createSelectFrom(final StringBuilder sqlBuilder) {
		sqlBuilder.append("SELECT         Ciu.id As IdCiudad, ");
		sqlBuilder.append("               Ciu.idDepartamento As IdDepartamento, ");
		sqlBuilder.append("         Dep.nombre As NombreDepartamento ");
		sqlBuilder.append(" FROM Ciudad Ciu");
		sqlBuilder.append(" INNER JOIN Ciudad Ciu ");
		sqlBuilder.append(" ON  Ciu.idDepartamento = Dep.id ");

	}

	private final void createWhere(final StringBuilder sqlBuilder, final CiudadDTO budget,
			final List<Object> parameters) {
		boolean setWhere = true;
		if (!ObjectHelper.isNull(budget)) {
			if (!UUIDHelper.isDefualtUUID(budget.getId())) {
				sqlBuilder.append("WHERE Ciu.id = ? ");
				setWhere = false;
				parameters.add(budget.getIdAsString());
			}

			if (!UUIDHelper.isDefualtUUID(budget.getDepartamento().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ")
						.append("WHERE Ciu.idDepartamento = ? ");
				parameters.add(budget.getDepartamento().getIdAsString());
			}

		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY Pa.nombre ASC ");

	}

	private final List<CiudadDTO> executeQuery(PreparedStatement preparedStatement) {
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

	private final CiudadDTO fillCiudadDTO(final ResultSet resultSet) {
		try {

			return CiudadDTO.create(resultSet.getString("idNombre"),
					fillDepartamentoDTO(resultSet));
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_FILL_BUDGET_DTO,
					exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_BUDGET_DTO,
					exception);
		}
	}

	private final List<CiudadDTO> fillResults(final ResultSet resultSet) {
		try {
			var results = new ArrayList<CiudadDTO>();
			while (resultSet.next()) {

				results.add(fillCiudadDTO(resultSet));
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

	private final DepartamentoDTO fillDepartamentoDTO(final ResultSet resultSet) {
		try {
			return DepartamentoDTO.create(resultSet.getString("IdDepartamento"),
					resultSet.getString("NombreDepartamento"),
					(PaisDTO) resultSet.getObject("NombrePais"));
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_FILL_PERSON_DTO,
					exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_PERSON_DTO,
					exception);
		}
	}

}
