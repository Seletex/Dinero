package edu.uco.inventario.data.dao;

import java.util.List;

import edu.uco.inventario.domain.SalidaDTO;

public interface SalidaDAO {

	void create(SalidaDTO estanteriaDTO);

	List<SalidaDTO> find(SalidaDTO estanteriaDTO);

	

	
}
