package edu.uco.inventario.data.daofactory;

import java.sql.Connection;

import edu.uco.inventario.crosscutting.helper.SqlConnectionHelper;
import edu.uco.inventario.crosscutting.messages.Messages;
import edu.uco.inventario.data.dao.AlmacenDAO;
import edu.uco.inventario.data.dao.CiudadDAO;
import edu.uco.inventario.data.dao.CuidadoDAO;
import edu.uco.inventario.data.dao.DepartamentoDAO;
import edu.uco.inventario.data.dao.EntradaDAO;
import edu.uco.inventario.data.dao.EstanteriaDAO;
import edu.uco.inventario.data.dao.PaisDAO;
import edu.uco.inventario.data.dao.PedidoDAO;
import edu.uco.inventario.data.dao.ProductoDAO;
import edu.uco.inventario.data.dao.ProveedorDAO;
import edu.uco.inventario.data.dao.SalidaDAO;
import edu.uco.inventario.data.dao.SeccionDAO;
import edu.uco.inventario.data.dao.TipoUnidadDAO;
import edu.uco.inventario.data.dao.UnidadMedidaDAO;
import edu.uco.inventario.data.dao.UsuarioDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.AlmacenSqlServerDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.CiudadSqlServerDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.CuidadoSqlServerDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.DepartamentoSqlServerDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.EntradaSqlServerDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.EstanteriaSqlServerDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.PaisSqlServerDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.PedidoSqlServerDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.ProductoSqlServerDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.ProveedorSqlServerDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.SalidaSqlServerDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.SeccionSqlServerDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.TipoUnidadSqlServerDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.UnidadMedidoSqlServerDAO;
import edu.uco.inventario.data.dao.relational.sqlserver.UsuarioSqlServerDAO;
import edu.uco.inventario.data.enumeration.DAOFactoryType;

public class DAOFactory {

	Connection connection = null;

	public static final DAOFactory getDAOFactory(final DAOFactoryType factory) {

		DAOFactory daoFactory = null;

		switch (factory) {
		case SQL_SERVER:
			daoFactory = new SqlServerDAOFactory();
			break;
		case CASSANDRA:
			throw new RuntimeException(
					Messages.DAOFactory.TECHNICAL_CASSANDRA_NOT_IMPLEMENT);

		case MARIADB:
			throw new RuntimeException(
					Messages.DAOFactory.TECHNICAL_MARIADB_NOT_IMPLEMENT);

		case MONGODB:
			throw new RuntimeException(
					Messages.DAOFactory.TECHNICAL_MONDGODB_NOT_IMPLEMENT);

		case MYSQL:
			throw new RuntimeException(Messages.DAOFactory.TECHNICAL_MYSQL_NOT_IMPLEMENT);

		case POSTGRESQL:
			throw new RuntimeException(
					Messages.DAOFactory.TECHNICAL_POSTGRESQL_NOT_IMPLEMENT);

		default:
			throw new RuntimeException(
					Messages.DAOFactory.TECHNICAL_UNEXPECTED_DAOFACTORY);
		}

		return daoFactory;
	}

	protected void openConexion() {
		connection = null;
	}

	public void initTransaction() {
	}

	public void confirmTransaction() {
		SqlConnectionHelper.closeConnection(connection);
	}

	public void cancelTransaction() {

	}

	public void closeConnection() {

	}

	public UsuarioDAO getUsuarioDAO() {

		return new UsuarioSqlServerDAO(connection);
	}
	public AlmacenDAO getAlmacenDAO() {

		return new AlmacenSqlServerDAO(connection);
	}
	public CiudadDAO getUCiudadDAO() {

		return new CiudadSqlServerDAO(connection);
	}
	public CuidadoDAO getCuidadoDAO() {

		return new CuidadoSqlServerDAO(connection);
	}
	
	public DepartamentoDAO getDepartamentoDAO() {

		return new DepartamentoSqlServerDAO(connection);
	}
	public EntradaDAO getEntradaDAO() {

		return new EntradaSqlServerDAO(connection);
	}
	
	public EstanteriaDAO getEstanteriaDAO() {

		return new EstanteriaSqlServerDAO(connection);
	}
	
	public PaisDAO getPaisDAO() {

		return new PaisSqlServerDAO(connection);
	}
	
	public PedidoDAO getPedidoDAO() {

		return new PedidoSqlServerDAO(connection);
	}
	
	public ProductoDAO getProductoDAO() {

		return new ProductoSqlServerDAO(connection);
	}
	
	public ProveedorDAO getProveedorDAO() {

		return new ProveedorSqlServerDAO(connection);
	}
	
	public SalidaDAO getSalidaDAO() {

		return new SalidaSqlServerDAO(connection);
	}
	public SeccionDAO getSeccionDAO() {

		return new SeccionSqlServerDAO(connection);
	}
	public TipoUnidadDAO getTipoUnidadDAO() {

		return new TipoUnidadSqlServerDAO(connection);
	}
	public UnidadMedidaDAO getUnidadMedidaDAO() {

		return new UnidadMedidoSqlServerDAO(connection);
	}

}
