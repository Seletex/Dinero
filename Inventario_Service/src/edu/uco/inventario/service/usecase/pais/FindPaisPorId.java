package edu.uco.inventario.service.usecase.pais;

import java.util.UUID;

import edu.uco.inventario.domain.PaisDTO;

public interface FindPaisPorId {
	PaisDTO execute(UUID id);
}
