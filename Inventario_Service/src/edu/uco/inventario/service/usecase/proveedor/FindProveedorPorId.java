package edu.uco.inventario.service.usecase.proveedor;

import java.util.UUID;

import edu.uco.inventario.domain.ProveedorDTO;

public interface FindProveedorPorId {
	ProveedorDTO execute(UUID id);
}
