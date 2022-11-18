package edu.uco.inventario.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.domain.CuidadoDTO;

public interface CuidadoDAO {

	void create(CuidadoDTO cuidadoDTO);

	List<CuidadoDTO> find(CuidadoDTO cuidadoDTO);

	void update(CuidadoDTO cuidadoDTO);

	void delete(UUID id);
}
