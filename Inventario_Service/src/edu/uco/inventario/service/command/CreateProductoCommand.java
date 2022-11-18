package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.ProductoDTO;

public interface CreateProductoCommand {
	void execute(ProductoDTO usuario);
}
