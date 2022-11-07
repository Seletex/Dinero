package edu.uco.inventory.domain;

import static edu.uco.inventory.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventory.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getNewUUID;

import java.util.UUID;

public class UnidadMedidaDTO {
	private UUID id;
	private String nombre;

	public UnidadMedidaDTO() {
		setId(getNewUUID());
		setNombre(EMPTY);
	}

	public UnidadMedidaDTO(final UUID id, final String nombre) {

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

	public static final UnidadMedidaDTO create(UUID id, String nombre) {
		return new UnidadMedidaDTO(id, nombre);
	}
}
