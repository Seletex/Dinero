package edu.uco.inventario.data.dao;

import java.util.List;

import edu.uco.inventario.domain.DepartamentoDTO;

public interface DepartamentoDAO {




	List<DepartamentoDTO> find(DepartamentoDTO departamentoDTO);


}
