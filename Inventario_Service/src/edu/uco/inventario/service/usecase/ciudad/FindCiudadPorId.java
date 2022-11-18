package edu.uco.inventario.service.usecase.ciudad;

import java.util.UUID;

import edu.uco.inventario.domain.CiudadDTO;

public interface FindCiudadPorId {
	CiudadDTO execute(UUID id);
}
