package edu.uco.inventario.service.command;

import edu.uco.inventario.domain.DepartamentoDTO;

public interface CreateDepartamentoCommand {
	void execute(DepartamentoDTO usuario);
}
