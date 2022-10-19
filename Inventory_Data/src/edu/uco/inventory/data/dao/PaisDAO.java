package edu.uco.inventory.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.inventory.domain.PaisDTO;

public interface PaisDAO {
	void create(PaisDTO person);

	List<PaisDTO> find(PaisDTO person);

	void update(PaisDTO person);

	void delete(UUID id);
}
