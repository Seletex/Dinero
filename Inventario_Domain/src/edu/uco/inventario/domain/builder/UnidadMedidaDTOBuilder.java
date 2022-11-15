package edu.uco.inventario.domain.builder;

import static edu.uco.inventario.domain.CuidadoDTO.create;

import java.util.UUID;

import edu.uco.inventario.domain.CuidadoDTO;

public class UnidadMedidaDTOBuilder {
	private UUID id;
	private String descripcion;

	private UnidadMedidaDTOBuilder() {
		super();
	}

	public static final UnidadMedidaDTOBuilder getUnidad_MedidaDTOBuilder() {
		return new UnidadMedidaDTOBuilder();
	}

	public final UnidadMedidaDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final UnidadMedidaDTOBuilder setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public CuidadoDTO build() {
		return create(id, descripcion);
	}
	
}
