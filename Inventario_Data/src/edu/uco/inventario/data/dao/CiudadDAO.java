package edu.uco.inventario.data.dao;

import java.util.List;

import edu.uco.inventario.domain.CiudadDTO;

public interface CiudadDAO {

	List<CiudadDTO> find(CiudadDTO ciudadDTO);

}
