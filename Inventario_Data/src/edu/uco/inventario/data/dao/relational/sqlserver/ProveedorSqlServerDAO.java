package edu.uco.inventario.data.dao.relational.sqlserver;

import static edu.uco.inventario.crosscutting.helper.StringHelper.getUUIDAsString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.inventario.crosscutting.exception.data.DataCustomException;
import edu.uco.inventario.crosscutting.helper.ObjectHelper;
import edu.uco.inventario.crosscutting.helper.UUIDHelper;
import edu.uco.inventario.crosscutting.messages.Messages;
import edu.uco.inventario.data.dao.ProveedorDAO;
import edu.uco.inventario.data.dao.relational.DAORelational;
import edu.uco.inventario.domain.ProveedorDTO;

public class ProveedorSqlServerDAO extends DAORelational implements ProveedorDAO {

	public ProveedorSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(ProveedorDTO person) {
		final var sql = "INSERT INTO ALMACEN(  id,   descripcion, ) VALUES (?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, person.getIdAsString());
			preparedStatement.setString(2, person.getNombre());
			preparedStatement.setString(3, person.getConctacto());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			String message = Messages.PersonSqlServerDAO.TECHNICAL_PROBLEM_CREATE_PERSON
					.concat(person.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			String message = Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_PERSON
					.concat(person.getIdAsString());
			DataCustomException.createTechnicalException(message, exception);

		}
	}

	@Override
	public final List<ProveedorDTO> find(ProveedorDTO budget) {

		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, budget, paramenters);
		createOrderBy(sqlBuilder);
		return prepareAndExecuteQuery(sqlBuilder, paramenters);

		
	}

	private final List<ProveedorDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder,
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
		sqlBuilder.append("SELECT         Cui.id As IdAlmacen, ");
		sqlBuilder.append("               Cui.idDescripcion As IdDecripcion ");
		
		sqlBuilder.append(" FROM Proveedorr Cui");
	

	}

	private final void createWhere(final StringBuilder sqlBuilder,
			final ProveedorDTO budget, final List<Object> parameters) {
		@SuppressWarnings("unused")
		boolean setWhere = true;
		if (!ObjectHelper.isNull(budget)) {
			if (!UUIDHelper.isDefualtUUID(budget.getId())) {
				sqlBuilder.append("WHERE Cui.id = ? ");
				setWhere = false;
				parameters.add(budget.getIdAsString());
			}

			

		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY Cui.nombre ASC ");

	}

	private final List<ProveedorDTO> executeQuery(PreparedStatement preparedStatement) {
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

	private final ProveedorDTO fillCuidadoDTO(final ResultSet resultSet) {
		try {

			return ProveedorDTO.create(resultSet.getString("IdNombre"),  resultSet.getString("IdDescripcion")
					);
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

	private final List<ProveedorDTO> fillResults(final ResultSet resultSet) {
		try {
			var results = new ArrayList<ProveedorDTO>();
			while (resultSet.next()) {

				results.add(fillCuidadoDTO(resultSet));
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


	@Override
	public final void update(ProveedorDTO usuario) {
		final var sql = "UPDATE CUIDADO SET idNombre=?, IdDescripcion WHERE id=?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, usuario.getIdAsString());
			preparedStatement.setString(2, usuario.getNombre());
			preparedStatement.setString(3, usuario.getConctacto());
			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			final var message = Messages.PersonSqlServerDAO.TECHNICAL_PROBLEM_UPDATE_PERSON
					.concat(usuario.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			final var message = Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_PERSON
					.concat(usuario.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		}
	}

	@Override
	public final void delete(UUID id) {
		final var sql = "DELETE INTO CUIDADO WHERE id=?";
		final var idAsString = getUUIDAsString(id);

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, idAsString);

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			final var message = Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_PERSON;
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {

			final var message = Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_PERSON;
			throw DataCustomException.createTechnicalException(message, exception);
		}
	}
}
