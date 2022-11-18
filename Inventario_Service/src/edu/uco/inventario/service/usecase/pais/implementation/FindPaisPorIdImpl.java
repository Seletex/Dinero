package edu.uco.inventario.service.usecase.pais.implementation;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.PaisDTO;
import edu.uco.inventario.service.usecase.pais.FindPaisPorId;

public class FindPaisPorIdImpl implements FindPaisPorId {

	private final DAOFactory factory;

	public FindPaisPorIdImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public PaisDTO execute(final UUID id) {
		PaisDTO result = new PaisDTO();
		final PaisDTO usuario = PaisDTO.create(id);
		List<PaisDTO> results = factory.getPaisDAO().find(usuario);

		results = factory.getPaisDAO().find(usuario);

		if (!results.isEmpty()) {
			result = results.get(0);
		}
		return result;
	}
}
