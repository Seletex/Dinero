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
import edu.uco.inventario.data.dao.SeccionDAO;
import edu.uco.inventario.data.dao.relational.DAORelational;
import edu.uco.inventario.domain.AlmacenDTO;
import edu.uco.inventario.domain.CiudadDTO;
import edu.uco.inventario.domain.SeccionDTO;

public class SeccionSqlServerDAO extends DAORelational implements SeccionDAO {

	public SeccionSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(SeccionDTO person) {
		final var sql = "INSERT INTO SECCION(  id,   nombre,   descripcion, almacen) VALUES (?, ?, ?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, person.getIdAsString());
			preparedStatement.setString(2, person.getNombre());
			preparedStatement.setString(3, person.getDescripcion());

			preparedStatement.setString(4, person.getAlmacen().getIdAsString());

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
	public final List<SeccionDTO> find(SeccionDTO budget) {

		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, budget, paramenters);
		createOrderBy(sqlBuilder);
		return prepareAndExecuteQuery(sqlBuilder, paramenters);

	}

	private final List<SeccionDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder,
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
		sqlBuilder.append("SELECT         Se.id As IdSeccion, ");
		sqlBuilder.append("               Se.idNombre As IdNombre, ");
		sqlBuilder.append("               Se.idDescripcion As IdDescripcion, ");
		sqlBuilder.append("         Alm.nombre As NombreAlmacen ");
		sqlBuilder.append(" FROM Seccion Se");
		sqlBuilder.append(" INNER JOIN Almacen Alm ");
		sqlBuilder.append(" ON  Se.idAlmacen = Alm.id ");

	}

	private final void createWhere(final StringBuilder sqlBuilder,
			final SeccionDTO budget, final List<Object> parameters) {
		boolean setWhere = true;
		if (!ObjectHelper.isNull(budget)) {
			if (!UUIDHelper.isDefualtUUID(budget.getId())) {
				sqlBuilder.append("WHERE Alm.id = ? ");
				setWhere = false;
				parameters.add(budget.getIdAsString());
			}

			if (!UUIDHelper.isDefualtUUID(budget.getAlmacen().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ")
						.append("WHERE Alm.idCiudad = ? ");
				parameters.add(budget.getAlmacen().getIdAsString());
			}

		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY Pa.nombre ASC ");

	}

	private final List<SeccionDTO> executeQuery(PreparedStatement preparedStatement) {
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

	private final SeccionDTO fillSeccionDTO(final ResultSet resultSet) {
		try {

			return SeccionDTO.create(resultSet.getString("IdNombre"),
					fillAlmacenDTO(resultSet), resultSet.getString("IdDescripcion"));
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

	private final List<SeccionDTO> fillResults(final ResultSet resultSet) {
		try {
			var results = new ArrayList<SeccionDTO>();
			while (resultSet.next()) {

				results.add(fillSeccionDTO(resultSet));
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

	private final AlmacenDTO fillAlmacenDTO(final ResultSet resultSet) {
		try {
			return AlmacenDTO.create(resultSet.getString("IdAlmacen"),
					resultSet.getString("NombreAlmacen"),
					(CiudadDTO) resultSet.getObject("NombreAlmacen"),
					resultSet.getString("IdDescripcionAlmacen"),
					resultSet.getString("IdDireccionAlmacen"));
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

	@Override
	public final void update(SeccionDTO usuario) {
		final var sql = "UPDATE SECCION SET idNombre=?, IdDescripcion, IdAlmacen WHERE id=?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, usuario.getIdAsString());
			preparedStatement.setString(2, usuario.getNombre());
			preparedStatement.setString(3, usuario.getDescripcion());
			preparedStatement.setString(4, usuario.getAlmacen().getIdAsString());

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
		final var sql = "DELETE INTO ALMACEN WHERE id=?";
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
