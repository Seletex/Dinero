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
import edu.uco.inventario.data.dao.ProductoDAO;
import edu.uco.inventario.data.dao.relational.DAORelational;
import edu.uco.inventario.domain.CuidadoDTO;
import edu.uco.inventario.domain.ProductoDTO;
import edu.uco.inventario.domain.ProveedorDTO;
import edu.uco.inventario.domain.TipoUnidadDTO;
import edu.uco.inventario.domain.UnidadMedidaDTO;

public class ProductoSqlServerDAO extends DAORelational implements ProductoDAO {

	public ProductoSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(ProductoDTO person) {
		final var sql = "INSERT INTO Producto(  id,   nombre,   descripcion,  proveedor, cantidad,contenido,,cuidado,unidad) VALUES (?, ?, ?,?,?,?,?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, person.getIdAsString());
			preparedStatement.setString(2, person.getNombre());
			preparedStatement.setString(3, person.getDescripcion());
			preparedStatement.setString(4, person.getProveedor().getIdAsString());
			preparedStatement.setShort(5, person.getCantidad());
			preparedStatement.setString(6, person.getContenido());
			preparedStatement.setString(7, person.getCuidado().getIdAsString());
			preparedStatement.setString(8, person.getUnidad().getIdAsString());

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
	public final List<ProductoDTO> find(ProductoDTO budget) {

		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, budget, paramenters);
		createOrderBy(sqlBuilder);
		return prepareAndExecuteQuery(sqlBuilder, paramenters);

	}

	private final List<ProductoDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder,
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
		sqlBuilder.append(" FROM Producto Prod");
		sqlBuilder.append(" INNER JOIN Proveedor Prov ");
		sqlBuilder.append(" ON  Prod.idProveedor = Prov.id ");
		sqlBuilder.append(" INNER JOIN Cuidado Cui ");
		sqlBuilder.append(" ON  Prod.idSeccion = Cui.id ");

		sqlBuilder.append(" INNER JOIN TipoUnidad Tipo ");
		sqlBuilder.append(" ON  Prod.idProducto = Tipo.id ");

	}

	private final void createWhere(final StringBuilder sqlBuilder,
			final ProductoDTO budget, final List<Object> parameters) {
		boolean setWhere = true;
		if (!ObjectHelper.isNull(budget)) {
			if (!UUIDHelper.isDefualtUUID(budget.getId())) {
				sqlBuilder.append("WHERE Alm.id = ? ");
				setWhere = false;
				parameters.add(budget.getIdAsString());
			}

			if (!UUIDHelper.isDefualtUUID(budget.getCuidado().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ")
						.append("WHERE Alm.idCiudad = ? ");
				parameters.add(budget.getCuidado().getIdAsString());
			}
			if (!UUIDHelper.isDefualtUUID(budget.getProveedor().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ")
						.append("WHERE Alm.idCiudad = ? ");
				parameters.add(budget.getProveedor().getIdAsString());
			}

			if (!UUIDHelper.isDefualtUUID(budget.getUnidad().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ")
						.append("WHERE Alm.idCiudad = ? ");
				parameters.add(budget.getUnidad().getIdAsString());
			}

		}
	}

	private final void createOrderBy(final StringBuilder sqlBuilder) {

		sqlBuilder.append("ORDER BY Prov.nombre ASC, ");
		sqlBuilder.append("ORDER BY Tipo.nombre ASC, ");
		sqlBuilder.append("ORDER BY Cui.nombre ASC, ");
	}

	private final List<ProductoDTO> executeQuery(PreparedStatement preparedStatement) {
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

	private final ProductoDTO fillProductoDTO(final ResultSet resultSet) {
		try {

			return ProductoDTO.create(resultSet.getString("IdNombre"),
					resultSet.getString("IdDescripcion"), fillProveedorDTO(resultSet),
					Short.parseShort(resultSet.getString("IdCantidad")),
					resultSet.getString("IdContenido"), fillCuidadoDTO(resultSet),
					fillTipoUnidadDTO(resultSet));
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

	private final List<ProductoDTO> fillResults(final ResultSet resultSet) {
		try {
			var results = new ArrayList<ProductoDTO>();
			while (resultSet.next()) {

				results.add(fillProductoDTO(resultSet));
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

	private final CuidadoDTO fillCuidadoDTO(final ResultSet resultSet) {
		try {
			return CuidadoDTO.create(resultSet.getString("IdCiudad"),
					resultSet.getString("IdDescripcion"));
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

	private final TipoUnidadDTO fillTipoUnidadDTO(final ResultSet resultSet) {
		try {
			return TipoUnidadDTO.create(resultSet.getString("IdCiudad"),
					(UnidadMedidaDTO) resultSet.getObject("NombreTipoUnidad"));
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

	@Override
	public final void update(ProductoDTO person) {
		final var sql = "UPDATE ESTANTERIA SET idNombre=?, IdDescripcion=?, idContenido=? WHERE id=?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, person.getIdAsString());
			preparedStatement.setString(2, person.getNombre());
			preparedStatement.setString(3, person.getDescripcion());
			preparedStatement.setString(4, person.getProveedor().getIdAsString());
			preparedStatement.setShort(5, person.getCantidad());
			preparedStatement.setString(6, person.getContenido());
			preparedStatement.setString(7, person.getCuidado().getIdAsString());
			preparedStatement.setString(8, person.getUnidad().getIdAsString());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			final var message = Messages.PersonSqlServerDAO.TECHNICAL_PROBLEM_UPDATE_PERSON
					.concat(person.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			final var message = Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_PERSON
					.concat(person.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		}
	}

	@Override
	public final void delete(UUID id) {
		final var sql = "DELETE INTO PRODUCTO WHERE id=?";
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
