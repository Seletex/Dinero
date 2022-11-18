package edu.uco.inventario.service.usecase.unidadmedida;

import java.util.UUID;

import edu.uco.inventario.domain.UnidadMedidaDTO;

public interface FindUnidadMedidaUseCase {
	UnidadMedidaDTO execute(UUID id);
}
