package edu.uco.inventario.domain.builder;

import java.util.UUID;


import edu.uco.inventario.domain.TipoUnidadDTO;
import edu.uco.inventario.domain.UnidadMedidaDTO;
import static edu.uco.inventario.domain.TipoUnidadDTO.create;

public class TipoUnidadDTOBuilder {
	
	private UUID id;
	private UnidadMedidaDTO unidadMedidaDTO;
	private String nombre;
	

	public TipoUnidadDTOBuilder() {
		super();
	}

	public final TipoUnidadDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final TipoUnidadDTOBuilder setPersona(final UnidadMedidaDTO persona) {
		this.unidadMedidaDTO = persona;
		return this;
	}

	public final TipoUnidadDTOBuilder setAno(final String nombre) {
		this.nombre = nombre;
		return this;
	}

	

	public TipoUnidadDTO build() {
		return create(id, nombre, unidadMedidaDTO);

	}
	
	public static final TipoUnidadDTOBuilder getTipoUnidadDTOBuilder() {
		return new TipoUnidadDTOBuilder();
	}

}


