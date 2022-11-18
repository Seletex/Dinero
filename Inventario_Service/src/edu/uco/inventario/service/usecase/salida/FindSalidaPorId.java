package edu.uco.inventario.service.usecase.salida;

import java.util.UUID;

import edu.uco.inventario.domain.SalidaDTO;

public interface FindSalidaPorId {
	SalidaDTO execute(UUID id);
}
