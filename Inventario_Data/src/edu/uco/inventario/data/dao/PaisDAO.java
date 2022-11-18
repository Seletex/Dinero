package edu.uco.inventario.data.dao;

import java.util.List;

import edu.uco.inventario.domain.PaisDTO;

public interface PaisDAO {

	List<PaisDTO> find(PaisDTO paisDTO);

}
