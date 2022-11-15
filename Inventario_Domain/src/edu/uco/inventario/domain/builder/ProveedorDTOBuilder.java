package edu.uco.inventario.domain.builder;

import static edu.uco.inventario.domain.ProveedorDTO.create;

import java.util.UUID;

import edu.uco.inventario.domain.ProveedorDTO;

public class ProveedorDTOBuilder {
	private UUID id;
	private String nombre;
	private String conctacto;

	public final ProveedorDTOBuilder setConctacto(String conctacto) {
		this.conctacto = conctacto;
		return this;
	}

	private ProveedorDTOBuilder() {
		super();
	}

	public static final ProveedorDTOBuilder getProveedorDTOBuilder() {
		return new ProveedorDTOBuilder();
	}

	public final ProveedorDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final ProveedorDTOBuilder setYearNumber(final String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ProveedorDTO build() {
		return create(id, nombre, conctacto);
	}

}


