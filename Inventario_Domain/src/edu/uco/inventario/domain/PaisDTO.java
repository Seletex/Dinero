package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventario.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

public final class PaisDTO {

	private UUID id;
	private String nombre;

	public PaisDTO() {
		setId(getNewUUID());
		setNombre(EMPTY);
	}

	public PaisDTO(final UUID id, final String nombre) {

		setId(id);
		setNombre(nombre);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(final String nombre) {
		this.nombre = applyTrim(nombre);
	}

	public static final PaisDTO create(final String nombre) {
		return new PaisDTO(UUID.randomUUID(), nombre);
	}

	public static final PaisDTO create(final String id, final String nombre) {
		return new PaisDTO(getUUIDFromString(id), nombre);
	}

	public static final PaisDTO create(final UUID id, final String nombre) {
		return new PaisDTO(getDefaultUUID(id), nombre);
	}

	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

}
