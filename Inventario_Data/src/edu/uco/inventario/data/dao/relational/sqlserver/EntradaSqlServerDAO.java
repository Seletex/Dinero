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
import edu.uco.inventario.data.dao.EntradaDAO;
import edu.uco.inventario.data.dao.relational.DAORelational;
import edu.uco.inventario.domain.EntradaDTO;
import edu.uco.inventario.domain.PedidoDTO;
import edu.uco.inventario.domain.ProductoDTO;
import edu.uco.inventario.domain.ProveedorDTO;
import edu.uco.inventario.domain.UsuarioDTO;

public class EntradaSqlServerDAO extends DAORelational implements EntradaDAO {

	public EntradaSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(EntradaDTO person) {
		final var sql = "INSERT INTO ESTANTERIA(  id,   pedido,usuaio,fecha) VALUES (?, ?, ?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, person.getIdAsString());

			preparedStatement.setString(2, person.getPedido().getIdAsString());
			preparedStatement.setString(3, person.getUsuario().getIdAsString());
			preparedStatement.setObject(4, person.getFecha());

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
	public final List<EntradaDTO> find(EntradaDTO budget) {

		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, budget, paramenters);
		createOrderBy(sqlBuilder);
		return prepareAndExecuteQuery(sqlBuilder, paramenters);

	}

	private final List<EntradaDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder,
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
			final EntradaDTO budget, final List<Object> parameters) {
		boolean setWhere = true;
		if (!ObjectHelper.isNull(budget)) {
			if (!UUIDHelper.isDefualtUUID(budget.getId())) {
				sqlBuilder.append("WHERE Es.id = ? ");
				setWhere = false;
				parameters.add(budget.getIdAsString());
			}

			if (!UUIDHelper.isDefualtUUID(budget.getPedido().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ")
						.append("WHERE Se.idNombre = ? ");
				parameters.add(budget.getPedido().getIdAsString());
			}
			if (!UUIDHelper.isDefualtUUID(budget.getUsuario().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ")
						.append("WHERE Prod.idNombre = ? ");
				parameters.add(budget.getUsuario().getIdAsString());
			}

		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY Se.nombre ASC, ");
		sqlBuilder.append("ORDER BY Prod.nombre ASC ");
	}

	private final List<EntradaDTO> executeQuery(PreparedStatement preparedStatement) {
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

	private final EntradaDTO fillEntradaDTO(final ResultSet resultSet) {
		try {
			return EntradaDTO.create(resultSet.getString("IdEstranteria"),
					fillPedidoDTO(resultSet), fillUsuarioDTO(resultSet),
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

	private final List<EntradaDTO> fillResults(final ResultSet resultSet) {
		try {
			var results = new ArrayList<EntradaDTO>();
			while (resultSet.next()) {

				results.add(fillEntradaDTO(resultSet));
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

	private final PedidoDTO fillPedidoDTO(final ResultSet resultSet) {
		try {
			return PedidoDTO.create(resultSet.getString("IdPedido"),
					(ProductoDTO) resultSet.getObject("NombreProducto"),
					(ProveedorDTO) resultSet.getObject("NombreProveedor"),
					resultSet.getShort("IdCantidad"));
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
