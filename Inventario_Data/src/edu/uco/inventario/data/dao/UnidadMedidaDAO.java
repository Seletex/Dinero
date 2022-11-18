package edu.uco.inventario.data.dao;

import java.util.List;

import edu.uco.inventario.domain.UnidadMedidaDTO;

public interface UnidadMedidaDAO {

	List<UnidadMedidaDTO> find(UnidadMedidaDTO estanteriaDTO);

}
