package edu.uco.inventario.service.usecase.producto;

import java.util.UUID;

import edu.uco.inventario.domain.ProductoDTO;

public interface FindProductoPorId {
	ProductoDTO execute(UUID id);
}
