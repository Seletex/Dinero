package edu.uco.inventario.service.usecase.departamento.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.DepartamentoDTO;
import edu.uco.inventario.service.usecase.departamento.CreateDepartamentoUseCase;

public class CreateDepartamentoUseCaseImpl implements CreateDepartamentoUseCase {

	private DAOFactory factory;

	@Override
	public void execute(DepartamentoDTO person) {
		factory.getDepartamentoDAO();

	}

	public CreateDepartamentoUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
}
