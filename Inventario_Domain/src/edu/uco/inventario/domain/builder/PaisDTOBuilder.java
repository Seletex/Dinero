package edu.uco.inventario.domain.builder;

import static edu.uco.inventario.domain.PaisDTO.create;

import java.util.UUID;

import edu.uco.inventario.domain.PaisDTO;

public class PaisDTOBuilder {
	
	private UUID id;
	private String nombre;

	private PaisDTOBuilder() {
		super();
	}

	public static final PaisDTOBuilder getPaisDTOBuilder() {
		return new PaisDTOBuilder();
	}

	public final PaisDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final PaisDTOBuilder setNombre(final String nombre) {
		this.nombre = nombre;
		return this;
	}

	public PaisDTO build() {
		return create(id, nombre);
	}

}
