package edu.uco.inventario.service.usecase.pedido.implementation;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.PedidoDTO;
import edu.uco.inventario.service.usecase.pedido.CreatePedidoUseCase;

public class CreatePedidoUseCaseImpl implements CreatePedidoUseCase {

	private DAOFactory factory;

	@Override
	public void execute(PedidoDTO person) {
		factory.getPedidoDAO().create(person);

	}

	public CreatePedidoUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
}
