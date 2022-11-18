package edu.uco.inventario.service.usecase.cuidado;

import java.util.UUID;

import edu.uco.inventario.domain.CuidadoDTO;

public interface FindCuidadoPorId {
	CuidadoDTO execute(UUID id);
}
