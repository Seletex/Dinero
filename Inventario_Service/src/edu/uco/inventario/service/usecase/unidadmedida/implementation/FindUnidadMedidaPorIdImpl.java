package edu.uco.inventario.service.usecase.unidadmedida.implementation;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.UnidadMedidaDTO;
import edu.uco.inventario.service.usecase.unidadmedida.FindUnidadMedidaUseCase;

public class FindUnidadMedidaPorIdImpl implements FindUnidadMedidaUseCase{

private final DAOFactory factory;
	
	public FindUnidadMedidaPorIdImpl(DAOFactory factory) {
		this.factory=factory;
	}
	
	@Override
	public UnidadMedidaDTO execute(final UUID id){
		UnidadMedidaDTO result = new UnidadMedidaDTO();
		final UnidadMedidaDTO usuario = UnidadMedidaDTO.create(id);
		List<UnidadMedidaDTO> results = factory.getUnidadMedidaDAO().find(usuario);
		
			results = factory.getUnidadMedidaDAO().find(usuario);
		
		if(!results.isEmpty()) {
			result = results.get(0);
		}
		return result;
	}
}
