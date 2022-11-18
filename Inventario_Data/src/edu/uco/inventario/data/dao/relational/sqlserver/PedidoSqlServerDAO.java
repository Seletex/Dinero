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
import edu.uco.inventario.data.dao.PedidoDAO;
import edu.uco.inventario.data.dao.relational.DAORelational;
import edu.uco.inventario.domain.CuidadoDTO;
import edu.uco.inventario.domain.PedidoDTO;
import edu.uco.inventario.domain.ProductoDTO;
import edu.uco.inventario.domain.ProveedorDTO;
import edu.uco.inventario.domain.TipoUnidadDTO;

public class PedidoSqlServerDAO extends DAORelational implements PedidoDAO {

	public PedidoSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(PedidoDTO person) {
		final var sql = "INSERT INTO ESTANTERIA(  id,   producto,  proveedor, cantidad) VALUES (?, ?, ?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, person.getIdAsString());
			preparedStatement.setString(2, person.getProducto().getIdAsString());
			preparedStatement.setString(3, person.getProveedorDTO().getIdAsString());
			preparedStatement.setShort(4, person.getCantidad());

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
	public final List<PedidoDTO> find(PedidoDTO budget) {

		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, budget, paramenters);
		createOrderBy(sqlBuilder);
		return prepareAndExecuteQuery(sqlBuilder, paramenters);

	}

	private final List<PedidoDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder,
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
		sqlBuilder.append("SELECT         Ped.id As IdPedido, ");
		sqlBuilder.append("               Prov.idNombre As NombreProveedor, ");
		sqlBuilder.append("               Prod.nombre As NombreProducto, ");
		sqlBuilder.append("               Ped.idCantidad As IdCantidad ");
	

		sqlBuilder.append(" FROM Pedido Ped");
		sqlBuilder.append(" INNER JOIN Proveedor Prov ");
		sqlBuilder.append(" ON  Ped.idProveedor = Prov.id ");

		sqlBuilder.append(" INNER JOIN Producto Prod ");
		sqlBuilder.append(" ON  Ped.idProducto = Prod.id ");

	}

	private final void createWhere(final StringBuilder sqlBuilder, final PedidoDTO budget,
			final List<Object> parameters) {
		boolean setWhere = true;
		if (!ObjectHelper.isNull(budget)) {
			if (!UUIDHelper.isDefualtUUID(budget.getId())) {
				sqlBuilder.append("WHERE Ped.id = ? ");
				setWhere = false;
				parameters.add(budget.getIdAsString());
			}
			if (!UUIDHelper.isDefualtUUID(budget.getProducto().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ")
						.append("WHERE Prod.idNombre = ? ");
				parameters.add(budget.getProducto().getIdAsString());
			}

			if (!UUIDHelper.isDefualtUUID(budget.getProveedorDTO().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ")
						.append("WHERE Prov.idNombre = ? ");
				parameters.add(budget.getProveedorDTO().getIdAsString());
			}

		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY Prov.nombre ASC, ");
		sqlBuilder.append("ORDER BY Prod.nombre ASC ");
	}

	private final List<PedidoDTO> executeQuery(PreparedStatement preparedStatement) {
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

	private final PedidoDTO fillEstanteriaDTO(final ResultSet resultSet) {
		try {

			return PedidoDTO.create(resultSet.getString("idEstranteria"),
					fillProductoDTO(resultSet), fillProveedorDTO(resultSet),

					Short.parseShort(resultSet.getString("idCantidad")));
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

	private final List<PedidoDTO> fillResults(final ResultSet resultSet) {
		try {
			var results = new ArrayList<PedidoDTO>();
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

	private final ProveedorDTO fillProveedorDTO(final ResultSet resultSet) {
		try {
			return ProveedorDTO.create(resultSet.getString("IdNombre"),
					resultSet.getString("IdContacto"));

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
	public final void update(PedidoDTO usuario) {
		final var sql = "UPDATE ESTANTERIA SET idProducto=?, idProveedor=?, IdCantidad=? WHERE id=?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, usuario.getIdAsString());
			preparedStatement.setString(2, usuario.getProducto().getIdAsString());
			preparedStatement.setString(3, usuario.getProveedorDTO().getIdAsString());
			preparedStatement.setShort(4, usuario.getCantidad());

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
		final var sql = "DELETE INTO PEDIDO WHERE id=?";
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
