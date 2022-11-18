package edu.uco.inventario.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.domain.SeccionDTO;

public interface SeccionDAO {

	void create(SeccionDTO seccionDTO);

	List<SeccionDTO> find(SeccionDTO seccionDTO);

	void update(SeccionDTO seccionDTO);

	void delete(UUID id);

}
