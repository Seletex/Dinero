package edu.uco.inventario.data.dao;

import java.util.List;

import edu.uco.inventario.domain.EntradaDTO;

public interface EntradaDAO {

	void create(EntradaDTO entradaDTO);

	List<EntradaDTO> find(EntradaDTO entradaDTO);

}
