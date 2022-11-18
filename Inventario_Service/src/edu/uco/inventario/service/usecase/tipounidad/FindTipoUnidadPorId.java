package edu.uco.inventario.service.usecase.tipounidad;

import java.util.UUID;

import edu.uco.inventario.domain.TipoUnidadDTO;


public interface FindTipoUnidadPorId {
	TipoUnidadDTO execute(UUID id);
}
