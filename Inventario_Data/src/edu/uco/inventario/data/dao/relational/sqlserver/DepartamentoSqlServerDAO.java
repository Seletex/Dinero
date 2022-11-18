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
import edu.uco.inventario.data.dao.DepartamentoDAO;
import edu.uco.inventario.data.dao.relational.DAORelational;
import edu.uco.inventario.domain.DepartamentoDTO;
import edu.uco.inventario.domain.PaisDTO;

public class DepartamentoSqlServerDAO extends DAORelational implements DepartamentoDAO {

	public DepartamentoSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final List<DepartamentoDTO> find(DepartamentoDTO budget) {

		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, budget, paramenters);
		createOrderBy(sqlBuilder);
		return prepareAndExecuteQuery(sqlBuilder, paramenters);

//private final void createWheres(final StringBuilder sqlBuilder,final  BudgetDTO budget, final List<Object> parameters) {

//}

	}

	private final List<DepartamentoDTO> prepareAndExecuteQuery(
			final StringBuilder sqlBuilder, final List<Object> parameters) {
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
		sqlBuilder.append("SELECT         Dep.Id As IdDepartento, ");
		sqlBuilder.append("               Dep.IdPais As IdPais, ");
		sqlBuilder.append("         Dep.nombre As NombreDepartamento ");
		sqlBuilder.append(" FROM Departamento Dep");
		sqlBuilder.append(" INNER JOIN Departamento Dep ");
		sqlBuilder.append(" ON  Ciu.idDepartamento = Dep.id ");

	}

	private final void createWhere(final StringBuilder sqlBuilder,
			final DepartamentoDTO ciudad, final List<Object> parameters) {
		boolean setWhere = true;
		if (!ObjectHelper.isNull(ciudad)) {
			if (!UUIDHelper.isDefualtUUID(ciudad.getId())) {
				sqlBuilder.append("WHERE Dep.id = ? ");
				setWhere = false;
				parameters.add(ciudad.getIdAsString());
			}

			if (!UUIDHelper.isDefualtUUID(ciudad.getPais().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ")
						.append("WHERE Dep.idPais = ? ");
				parameters.add(ciudad.getPais().getIdAsString());
			}

		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY Pa.nombre ASC ");

	}

	private final List<DepartamentoDTO> executeQuery(
			PreparedStatement preparedStatement) {
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

	private final DepartamentoDTO fillDepartamentoDTO(final ResultSet resultSet) {
		try {

			return DepartamentoDTO.create(resultSet.getString("idBudget"),
					fillPaisDTO(resultSet));
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

	private final List<DepartamentoDTO> fillResults(final ResultSet resultSet) {
		try {
			var results = new ArrayList<DepartamentoDTO>();
			while (resultSet.next()) {

				results.add(fillDepartamentoDTO(resultSet));
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

	private final PaisDTO fillPaisDTO(final ResultSet resultSet) {
		try {
			return PaisDTO.create(resultSet.getString("IdPais"),
					resultSet.getString("NombrePais"));
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
