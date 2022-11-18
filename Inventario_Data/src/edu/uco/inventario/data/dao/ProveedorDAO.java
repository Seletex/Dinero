package edu.uco.inventario.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.domain.ProveedorDTO;

public interface ProveedorDAO {


	void create(ProveedorDTO proveedorDTO);

	List<ProveedorDTO> find(ProveedorDTO proveedorDTO);

	void update(ProveedorDTO proveedorDTO);

	void delete(UUID id);
}
