package edu.uco.budget.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.BudgetDTO;

public class BudgetSqlServerDAO extends DAORelational  implements BudgetDAO {

	public BudgetSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(BudgetDTO budget) {
		
	}

	@Override
	public final List<BudgetDTO> find(BudgetDTO budget) {

		return null;
	}

	@Override
	public final void update(BudgetDTO budget) {

	}

	@Override
	public final void delete(UUID id) {
 }

}
