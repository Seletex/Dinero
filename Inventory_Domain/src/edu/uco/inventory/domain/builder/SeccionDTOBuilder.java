package edu.uco.inventory.domain.builder;


import static edu.uco.inventory.domain.SeccionDTO.create;

import java.util.UUID;

import edu.uco.inventory.domain.AlmacenDTO;

import edu.uco.inventory.domain.SeccionDTO;

public class SeccionDTOBuilder {
	private UUID id;
	private String nombre;
	private String descripcion;
	
	private AlmacenDTO almacen;
	
	private SeccionDTOBuilder() {
		super();
	}

	public static final SeccionDTOBuilder getSeccionDTOBuilder() {
		return new SeccionDTOBuilder();
	}

	public final SeccionDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final SeccionDTOBuilder setNombre(final String nombre) {
		this.nombre = nombre;
		return this;
	}

	public final SeccionDTOBuilder setAlmacen(final AlmacenDTO almacen) {
		this.almacen = almacen;
		return this;
	}

	public final SeccionDTOBuilder setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}	

	public SeccionDTO build() {
		return create(id, nombre, almacen,descripcion);
	}
}
