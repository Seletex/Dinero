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
import edu.uco.inventario.data.dao.EstanteriaDAO;
import edu.uco.inventario.data.dao.relational.DAORelational;
import edu.uco.inventario.domain.AlmacenDTO;
import edu.uco.inventario.domain.CuidadoDTO;
import edu.uco.inventario.domain.EstanteriaDTO;
import edu.uco.inventario.domain.ProductoDTO;
import edu.uco.inventario.domain.ProveedorDTO;
import edu.uco.inventario.domain.SeccionDTO;
import edu.uco.inventario.domain.TipoUnidadDTO;

public class EstanteriaSqlServerDAO extends DAORelational implements EstanteriaDAO {

	public EstanteriaSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(EstanteriaDTO person) {
		final var sql = "INSERT INTO ESTANTERIA(  id,   pasillo,  letra, numero,seccion,producto) VALUES (?, ?, ?,?,?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, person.getIdAsString());
			preparedStatement.setString(2, person.getPasillo());
			preparedStatement.setString(3, person.getLetra());
			preparedStatement.setString(4, person.getNumero());
			preparedStatement.setString(5, person.getSeccionDTO().getIdAsString());
			preparedStatement.setString(6, person.getProductoDTO().getIdAsString());

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
	public final List<EstanteriaDTO> find(EstanteriaDTO budget) {

		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, budget, paramenters);
		createOrderBy(sqlBuilder);
		return prepareAndExecuteQuery(sqlBuilder, paramenters);

	}

	private final List<EstanteriaDTO> prepareAndExecuteQuery(
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
		sqlBuilder.append("SELECT         Es.id As IdAlmacen, ");
		sqlBuilder.append("               Es.idPasillo As IdPaisllo, ");
		sqlBuilder.append("               Es.idLetra As IdLetra, ");
		sqlBuilder.append("               Es.idNumero As IdNumero, ");
		sqlBuilder.append("               Se.nombre As NombreSeccion, ");
		sqlBuilder.append("               Prod.nombre As NombreProducto ");
		
		sqlBuilder.append(" FROM Estanteria Es");
		sqlBuilder.append(" INNER JOIN Seccion Se ");
		sqlBuilder.append(" ON  Es.idSeccion = Se.id ");
	
		sqlBuilder.append(" INNER JOIN Producto Prod ");
		sqlBuilder.append(" ON  Es.idProducto = Prod.id ");

	}

	private final void createWhere(final StringBuilder sqlBuilder,
			final EstanteriaDTO budget, final List<Object> parameters) {
		boolean setWhere = true;
		if (!ObjectHelper.isNull(budget)) {
			if (!UUIDHelper.isDefualtUUID(budget.getId())) {
				sqlBuilder.append("WHERE Es.id = ? ");
				setWhere = false;
				parameters.add(budget.getIdAsString());
			}

			if (!UUIDHelper.isDefualtUUID(budget.getSeccionDTO().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ")
						.append("WHERE Se.idNombre = ? ");
				parameters.add(budget.getSeccionDTO().getIdAsString());
			}
			if (!UUIDHelper.isDefualtUUID(budget.getProductoDTO().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ")
						.append("WHERE Prod.idNombre = ? ");
				parameters.add(budget.getProductoDTO().getIdAsString());
			}

		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY Se.nombre ASC, ");
		sqlBuilder.append("ORDER BY Prod.nombre ASC ");
	}

	private final List<EstanteriaDTO> executeQuery(PreparedStatement preparedStatement) {
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

	private final EstanteriaDTO fillEstanteriaDTO(final ResultSet resultSet) {
		try {

			return EstanteriaDTO.create(resultSet.getString("IdEstranteria"),
					resultSet.getString("IdLetra"), resultSet.getString("IdPasillo"),
					resultSet.getString("IdNumero"), fillSeccionDTO(resultSet),
					fillProductoDTO(resultSet));
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

	private final List<EstanteriaDTO> fillResults(final ResultSet resultSet) {
		try {
			var results = new ArrayList<EstanteriaDTO>();
			while (resultSet.next()) {

				results.add(fillEstanteriaDTO(resultSet));
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

	private final SeccionDTO fillSeccionDTO(final ResultSet resultSet) {
		try {
			return SeccionDTO.create(resultSet.getString("IdCiudad"),

					(AlmacenDTO) resultSet.getObject("NombreAlmacen"),
					resultSet.getString("NombreCiudad"));
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

	private final ProductoDTO fillProductoDTO(final ResultSet resultSet) {
		try {
			return ProductoDTO.create(resultSet.getString("IdProducto"),
					resultSet.getString("NombreProdcuto"),
					resultSet.getString("DescripcionProdcuto"),
					(ProveedorDTO) resultSet.getObject("NombreProveedor"),
					Short.parseShort(resultSet.getString("CantidadProducto")),
					resultSet.getString("ContenidoProducto"),

					(CuidadoDTO) resultSet.getObject("DescripcionCuidado"),
					(TipoUnidadDTO) resultSet.getObject("NombreTipoUnidad"));
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
	public final void update(EstanteriaDTO usuario) {
		final var sql = "UPDATE ESTANTERIA SET idLetra=?, IdPaisllo, IdNumero, IdDescripcion WHERE id=?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, usuario.getIdAsString());
			preparedStatement.setString(2, usuario.getPasillo());
			preparedStatement.setString(3, usuario.getLetra());
			preparedStatement.setString(4, usuario.getNumero());
			preparedStatement.setString(5, usuario.getDescripcion());
			preparedStatement.setString(6, usuario.getSeccionDTO().getIdAsString());
			preparedStatement.setString(7, usuario.getProductoDTO().getIdAsString());

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
		final var sql = "DELETE INTO ESTANTERIA WHERE id=?";
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
