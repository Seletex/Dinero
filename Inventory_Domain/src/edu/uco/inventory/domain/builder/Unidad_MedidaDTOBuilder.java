package edu.uco.inventory.domain.builder;

import static edu.uco.inventory.domain.CiudadoDTO.create;

import java.util.UUID;

import edu.uco.inventory.domain.CiudadoDTO;

public class Unidad_MedidaDTOBuilder {
	private UUID id;
	private String descripcion;

	private Unidad_MedidaDTOBuilder() {
		super();
	}

	public static final Unidad_MedidaDTOBuilder getUnidad_MedidaDTOBuilder() {
		return new Unidad_MedidaDTOBuilder();
	}

	public final Unidad_MedidaDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final Unidad_MedidaDTOBuilder setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public CiudadoDTO build() {
		return create(id, descripcion);
	}
	
}
