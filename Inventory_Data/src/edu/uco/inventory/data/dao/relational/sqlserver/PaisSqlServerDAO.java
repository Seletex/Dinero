package edu.uco.inventory.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import edu.uco.inventory.data.dao.PaisDAO;
import edu.uco.inventory.data.dao.relational.DAORelational;
import edu.uco.inventory.domain.PaisDTO;

public class PaisSqlServerDAO extends DAORelational implements PaisDAO {

	public PaisSqlServerDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(PaisDTO person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(PaisDTO person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<edu.uco.inventory.domain.PaisDTO> find(PaisDTO person) {
		// TODO Auto-generated method stub
		return null;
	}

}
