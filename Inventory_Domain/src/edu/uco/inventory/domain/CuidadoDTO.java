package edu.uco.inventory.domain;

import static edu.uco.inventory.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventory.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getNewUUID;

import java.util.UUID;

public class CuidadoDTO {
	private UUID id;
	private String descripcion;

	public CuidadoDTO(UUID id, String descripcion) {
		setId(getNewUUID());
		setDescripcion(EMPTY);
	}

	public CuidadoDTO(final UUID id) {

		setId(id);
		setDescripcion(EMPTY);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final void setDescripcion(final String nombre) {
		this.descripcion = applyTrim(nombre);
	}

	public static final CuidadoDTO create(UUID id, String descripcion) {
		return new CuidadoDTO(id, descripcion);
	}
}
