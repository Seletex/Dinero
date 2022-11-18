package edu.uco.inventario.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCreation;

import edu.uco.inventario.crosscutting.exception.data.DataCustomException;
import edu.uco.inventario.crosscutting.helper.ObjectHelper;
import edu.uco.inventario.crosscutting.helper.UUIDHelper;
import edu.uco.inventario.crosscutting.messages.Messages;
import edu.uco.inventario.data.dao.SalidaDAO;
import edu.uco.inventario.data.dao.relational.DAORelational;
import edu.uco.inventario.domain.CuidadoDTO;
import edu.uco.inventario.domain.ProductoDTO;
import edu.uco.inventario.domain.ProveedorDTO;
import edu.uco.inventario.domain.SalidaDTO;
import edu.uco.inventario.domain.TipoUnidadDTO;
import edu.uco.inventario.domain.UsuarioDTO;

public class SalidaSqlServerDAO extends DAORelational implements SalidaDAO {

	public SalidaSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(SalidaDTO person) {
		final var sql = "INSERT INTO Producto(  id,   producto,   usuario,  cantidad, fecha) VALUES (?, ?, ?,?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, person.getIdAsString());
			preparedStatement.setString(2, person.getProductoDTO().getIdAsString());
			preparedStatement.setString(3, person.getUsuario().getIdAsString());

			preparedStatement.setShort(4, person.getCantidad());
			preparedStatement.setObject(5, person.getFecha());

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
	public final List<SalidaDTO> find(SalidaDTO budget) {

		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, budget, paramenters);
		createOrderBy(sqlBuilder);
		return prepareAndExecuteQuery(sqlBuilder, paramenters);

	}

	private final List<SalidaDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder,
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
		sqlBuilder.append("SELECT         Prod.id As IdAlmacen, ");
		sqlBuilder.append("               Prod.idNombre As IdNombred, ");
		sqlBuilder.append("               Prod.idDescripcion As IdDescripcion, ");
		sqlBuilder.append("               Prov.idNombre As IdNombred, ");
		sqlBuilder.append("         Prod.idCantidad As IdCantidad ");
		sqlBuilder.append("         Prod.idContenido As IdContenido ");
		sqlBuilder.append("               Cui.idNombre As IdNombred, ");
		sqlBuilder.append("               Tipo.idNombre As IdNombred, ");
		sqlBuilder.append(" FROM Salida Sal");
		sqlBuilder.append(" INNER JOIN Producto Prod ");
		sqlBuilder.append(" ON  Sal.idProducto = Prod.id ");
		sqlBuilder.append(" INNER JOIN usuario Usu ");
		sqlBuilder.append(" ON  Sal.idUsuario = Usu.id ");

	}

	private final void createWhere(final StringBuilder sqlBuilder, final SalidaDTO budget,
			final List<Object> parameters) {
		boolean setWhere = true;
		if (!ObjectHelper.isNull(budget)) {
			if (!UUIDHelper.isDefualtUUID(budget.getId())) {
				sqlBuilder.append("WHERE Alm.id = ? ");
				setWhere = false;
				parameters.add(budget.getIdAsString());
			}

			if (!UUIDHelper.isDefualtUUID(budget.getProductoDTO().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ")
						.append("WHERE Sal.idProducto = ? ");
				parameters.add(budget.getProductoDTO().getIdAsString());
			}
			if (!UUIDHelper.isDefualtUUID(budget.getUsuario().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ")
						.append("WHERE Sal.idUsuario = ? ");
				parameters.add(budget.getUsuario().getIdAsString());
			}

		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY Sal.fecha ASC, ");
		sqlBuilder.append("ORDER BY Usu.nombre ASC ");

	}

	private final List<SalidaDTO> executeQuery(PreparedStatement preparedStatement) {
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

	private final SalidaDTO fillSalidaDTO(final ResultSet resultSet) {
		try {

			return SalidaDTO.create(resultSet.getString("idSalida"),
					fillUsuarioDTO(resultSet),
					Short.parseShort(resultSet.getString("IdCantidad")),
					fillProductoDTO(resultSet),
					(DateTimeAtCreation) resultSet.getObject("idFecha"));
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

	private final List<SalidaDTO> fillResults(final ResultSet resultSet) {
		try {
			var results = new ArrayList<SalidaDTO>();
			while (resultSet.next()) {

				results.add(fillSalidaDTO(resultSet));
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

	private final ProductoDTO fillProductoDTO(final ResultSet resultSet) {
		try {
			return ProductoDTO.create(resultSet.getString("IdNombre"),
					resultSet.getString("IdDescripcion"),
					(ProveedorDTO) resultSet.getObject("NombreProveedor"),
					Short.parseShort(resultSet.getString("IdCantidad")),
					resultSet.getString("IdContenido"),
					(CuidadoDTO) resultSet.getObject("NombreCuidado"),
					(TipoUnidadDTO) resultSet.getObject("NombreTipoUnidad"));
		} catch (SQLException exception) {
			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_FILL_PERSON_DTO,
					exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_PERSON_DTO,
					exception);
		}
	}

	private final UsuarioDTO fillUsuarioDTO(final ResultSet resultSet) {
		try {
			return UsuarioDTO.create(resultSet.getString("IdNombre"),
					resultSet.getString("IdApellido"), resultSet.getString("idCargo"));
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
