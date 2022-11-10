package edu.uco.inventory.domain.builder;


import static edu.uco.inventory.domain.CuidadoDTO.create;

import java.util.UUID;

import edu.uco.inventory.domain.CuidadoDTO;


public class CuidadoDTOBuilder {

	private UUID id;
	private String descripcion;

	private CuidadoDTOBuilder() {
		super();
	}

	public static final CuidadoDTOBuilder getCuidadoDTOBuilder() {
		return new CuidadoDTOBuilder();
	}

	public final CuidadoDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final CuidadoDTOBuilder setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public CuidadoDTO build() {
		return create(id, descripcion);
	}
	
	
}
