package edu.uco.inventario.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.domain.EstanteriaDTO;

public interface EstanteriaDAO {

	void create(EstanteriaDTO estanteriaDTO);

	List<EstanteriaDTO> find(EstanteriaDTO estanteriaDTO);

	void update(EstanteriaDTO estanteriaDTO);

	void delete(UUID id);
}
