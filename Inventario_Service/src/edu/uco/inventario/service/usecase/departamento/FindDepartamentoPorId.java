package edu.uco.inventario.service.usecase.departamento;

import java.util.UUID;

import edu.uco.inventario.domain.DepartamentoDTO;

public interface FindDepartamentoPorId {
	DepartamentoDTO execute(UUID id);
}
