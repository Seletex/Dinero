package edu.uco.inventory.domain.builder;

import static edu.uco.inventory.domain.PaisDTO.create;

import java.util.UUID;

import edu.uco.inventory.domain.PaisDTO;

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

	public final PaisDTOBuilder setYearNumber(final String nombre) {
		this.nombre = nombre;
		return this;
	}

	public PaisDTO build() {
		return create(id, nombre);
	}

}
