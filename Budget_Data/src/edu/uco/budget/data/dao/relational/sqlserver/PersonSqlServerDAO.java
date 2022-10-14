package edu.uco.budget.data.dao.relational.sqlserver;

import java.util.List;
import java.util.UUID;

import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.domain.PersonDTO;

public class PersonSqlServerDAO implements PersonDAO {

	@Override
	public final void create(PersonDTO person) {

	}

	@Override
	public final List<PersonDTO> find(PersonDTO person) {
		return null;
	}

	@Override
	public final void update(PersonDTO person) {

	}

	@Override
	public final void delete(UUID id) {

	}

}
