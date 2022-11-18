package edu.uco.inventario.service.usecase.almacen;

import java.util.UUID;

import edu.uco.inventario.domain.AlmacenDTO;

public interface FindAlmacenPorId {
	AlmacenDTO execute(UUID id);
}
