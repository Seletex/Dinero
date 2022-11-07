package edu.uco.inventory.domain;

import static edu.uco.inventory.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventory.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getNewUUID;

import java.util.UUID;

public class CiudadoDTO {
	private UUID id;
	private String descripcion;

	public CiudadoDTO(UUID id, String descripcion) {
		setId(getNewUUID());
		setDescripcion(EMPTY);
	}

	public CiudadoDTO(final UUID id) {

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

	public static final CiudadoDTO create(UUID id, String descripcion) {
		return new CiudadoDTO(id, descripcion);
	}
}
