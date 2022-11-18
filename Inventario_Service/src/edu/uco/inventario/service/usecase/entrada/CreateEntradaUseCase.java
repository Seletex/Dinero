package edu.uco.inventario.service.usecase.entrada;

import edu.uco.inventario.domain.EntradaDTO;

public interface CreateEntradaUseCase {
	void execute(EntradaDTO person);
}
