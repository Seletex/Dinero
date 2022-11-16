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
import edu.uco.inventario.data.dao.UsuarioDAO;
import edu.uco.inventario.data.dao.relational.DAORelational;
import edu.uco.inventario.domain.UsuarioDTO;

public class UsuarioSqlServerDAO extends DAORelational implements UsuarioDAO {

	public UsuarioSqlServerDAO(final Connection connection) {
		super(connection);

	}

	@Override
	public final void create(UsuarioDTO person) {
		final var sql = "INSERT INTO BUDGET(  id,   nombre,   apellido,   cargo) VALUES (?, ?, ?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, person.getIdAsString());
			preparedStatement.setString(2, person.getNombre());
			preparedStatement.setString(3, person.getApellido());
			preparedStatement.setString(4, person.getCargo());

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
	public final List<UsuarioDTO> find(UsuarioDTO usuario) {

		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, usuario, paramenters);
		createOrderBy(sqlBuilder);
		return prepareAndExecuteQuery(sqlBuilder, paramenters);
	}

	private final void createSelectFrom(final StringBuilder sqlBuilder) {
		sqlBuilder.append("SELECT         Id As IdUsuario, ");
		sqlBuilder.append("              nombre As Nombre, ");
		sqlBuilder.append("              apellido As Apellido, ");
		sqlBuilder.append("              cargo As Cargo, ");

		sqlBuilder.append("From Usuario");
	}

	private final void createWhere(final StringBuilder sqlBuilder,
			final UsuarioDTO usuario, final List<Object> parameters) {

		if (!ObjectHelper.isNull(usuario) && !UUIDHelper.isDefualtUUID(usuario.getId())) {

			sqlBuilder.append("WHERE id= ? ");

			parameters.add(usuario.getIdAsString());

		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY apellido ASC ");

	}

	private final List<UsuarioDTO> executeQuery(PreparedStatement preparedStatement) {
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

	private final List<UsuarioDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder,
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

	private final List<UsuarioDTO> fillResults(final ResultSet resultSet) {
		try {
			var results = new ArrayList<UsuarioDTO>();
			while (resultSet.next()) {

				results.add(fillUsuarioDTO(resultSet));
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

	private final UsuarioDTO fillUsuarioDTO(final ResultSet resultSet) {
		try {
			return UsuarioDTO.create(resultSet.getString("IdUsuario"),
					resultSet.getString("IdNombreUsuario"),
					resultSet.getString("IdApellidoUsuario"),
					resultSet.getString("IdCargoUsuario"));

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

	@Override
	public final void update(UsuarioDTO usuario) {
		final var sql = "UPDATE USUARIO SET idNombre=?, IdApellido, IdCargo WHERE id=?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, usuario.getIdAsString());
			preparedStatement.setString(2, usuario.getNombre());
			preparedStatement.setString(3, usuario.getApellido());
			preparedStatement.setString(4, usuario.getCargo());

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
		final var sql = "DELETE INTO USUARIO WHERE id=?";
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
