package edu.uco.inventario.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.domain.ProductoDTO;


public interface ProductoDAO {


	void create(ProductoDTO productoDTO);

	List<ProductoDTO> find(ProductoDTO productoDTO);

	void update(ProductoDTO productoDTO);

	void delete(UUID id);
}
