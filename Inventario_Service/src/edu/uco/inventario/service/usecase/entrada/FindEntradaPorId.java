package edu.uco.inventario.service.usecase.entrada;

import java.util.UUID;

import edu.uco.inventario.domain.EntradaDTO;

public interface FindEntradaPorId {
	EntradaDTO execute(UUID id);
}
