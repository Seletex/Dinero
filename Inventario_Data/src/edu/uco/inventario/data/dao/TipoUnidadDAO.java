package edu.uco.inventario.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.domain.TipoUnidadDTO;

public interface TipoUnidadDAO {

	void create(TipoUnidadDTO tipoUnidadDTO);

	List<TipoUnidadDTO> find(TipoUnidadDTO tipoUnidadDTO);

	void update(TipoUnidadDTO tipoUnidadDTO);

	void delete(UUID id);
}
