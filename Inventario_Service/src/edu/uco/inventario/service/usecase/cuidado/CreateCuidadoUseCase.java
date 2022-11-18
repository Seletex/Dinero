package edu.uco.inventario.service.usecase.cuidado;

import edu.uco.inventario.domain.CuidadoDTO;

public interface CreateCuidadoUseCase {
	void execute(CuidadoDTO person);
}
