package edu.uco.inventario.service.usecase.tipounidad.implementation;

import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;

import java.util.List;
import java.util.UUID;

import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.domain.TipoUnidadDTO;
import edu.uco.inventario.domain.UnidadMedidaDTO;
import edu.uco.inventario.service.usecase.tipounidad.FindTipoUnidadPorId;

public class FindTipoUnidadPorIdImpl implements FindTipoUnidadPorId {

	private final DAOFactory factory;

	public FindTipoUnidadPorIdImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public TipoUnidadDTO execute(final UUID id) {
		UnidadMedidaDTO unidadMedidaDTO = new UnidadMedidaDTO();
		TipoUnidadDTO result = new TipoUnidadDTO();
		final TipoUnidadDTO usuario = TipoUnidadDTO.create("", EMPTY, unidadMedidaDTO);
		List<TipoUnidadDTO> results = factory.getTipoUnidadDAO().find(usuario);

		results = factory.getTipoUnidadDAO().find(usuario);

		if (!results.isEmpty()) {
			result = results.get(0);
		}
		return result;
	}

}
