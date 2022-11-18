package edu.uco.inventario.service.usecase.estanteria;

import java.util.UUID;

import edu.uco.inventario.domain.EstanteriaDTO;

public interface FindEstanteriaPorId {
	EstanteriaDTO execute(UUID id);
}
