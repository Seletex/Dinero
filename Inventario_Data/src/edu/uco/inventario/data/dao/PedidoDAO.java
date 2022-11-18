package edu.uco.inventario.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.domain.PedidoDTO;

public interface PedidoDAO {

	void create(PedidoDTO pedidoDTO);

	List<PedidoDTO> find(PedidoDTO pedidoDTO);

	void update(PedidoDTO pedidoDTO);

	void delete(UUID id);
}
