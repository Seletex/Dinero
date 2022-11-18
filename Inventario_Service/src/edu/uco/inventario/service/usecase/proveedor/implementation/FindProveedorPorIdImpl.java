package edu.uco.inventario.service.usecase.proveedor.implementation;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.ProveedorDTO;
import edu.uco.inventario.service.usecase.proveedor.FindProveedorPorId;

public class FindProveedorPorIdImpl implements FindProveedorPorId {

	private final DAOFactory factory;

	public FindProveedorPorIdImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public ProveedorDTO execute(final UUID id) {
		ProveedorDTO result = new ProveedorDTO();
		final ProveedorDTO usuario = ProveedorDTO.create(id);
		List<ProveedorDTO> results = factory.getProveedorDAO().find(usuario);

		results = factory.getProveedorDAO().find(usuario);

		if (!results.isEmpty()) {
			result = results.get(0);
		}
		return result;
	}
}
