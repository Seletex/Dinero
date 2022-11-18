package edu.uco.inventario.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.domain.AlmacenDTO;

public interface AlmacenDAO {

	void create(AlmacenDTO almacenDTO);

	List<AlmacenDTO> find(AlmacenDTO almacenDTO);

	void update(AlmacenDTO almacenDTO);

	void delete(UUID id);
}
