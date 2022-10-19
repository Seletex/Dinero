package edu.uco.inventory.domain;

import static edu.uco.inventory.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventory.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getNewUUID;

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
		setNombre(EMPTY);
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

	public static final PaisDTO create(UUID id, String nombre) {
		return new PaisDTO(id, nombre);
	}

}
