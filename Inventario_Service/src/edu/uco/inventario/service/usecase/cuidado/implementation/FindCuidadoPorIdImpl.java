package edu.uco.inventario.service.usecase.cuidado.implementation;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.CuidadoDTO;
import edu.uco.inventario.service.usecase.cuidado.FindCuidadoPorId;

public class FindCuidadoPorIdImpl implements FindCuidadoPorId {

	private final DAOFactory factory;

	public FindCuidadoPorIdImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public CuidadoDTO execute(final UUID id) {
		CuidadoDTO result = new CuidadoDTO();
		final CuidadoDTO usuario = CuidadoDTO.create(id);
		List<CuidadoDTO> results = factory.getCuidadoDAO().find(usuario);

		results = factory.getCuidadoDAO().find(usuario);

		if (!results.isEmpty()) {
			result = results.get(0);
		}
		return result;
	}
}
