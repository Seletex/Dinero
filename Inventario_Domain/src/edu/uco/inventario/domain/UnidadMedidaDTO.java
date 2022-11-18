package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventario.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

import edu.uco.inventario.crosscutting.helper.UUIDHelper;

public class UnidadMedidaDTO {
	private UUID id;
	private String nombre;

	public UnidadMedidaDTO() {
		setId(getNewUUID());
		setNombre(EMPTY);
	}

	public UnidadMedidaDTO(final UUID id, final String nombre) {

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

	public static final UnidadMedidaDTO create(final String nombre) {
		return new UnidadMedidaDTO(UUID.randomUUID(), nombre);
	}

	public static final UnidadMedidaDTO create(final String id, final String nombre) {
		return new UnidadMedidaDTO(getUUIDFromString(id), nombre);
	}

	public static final UnidadMedidaDTO create(final UUID id, final String nombre) {
		return new UnidadMedidaDTO(getDefaultUUID(id), nombre);
	}

	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

	public final boolean notExist() {
		return UUIDHelper.isDefualtUUID(id);
		// 50 minute
	}
	
	public static final UnidadMedidaDTO create() {
		return new UnidadMedidaDTO(UUID.randomUUID(), EMPTY);
	}
	
	public static final UnidadMedidaDTO create(final UUID id) {
		return new UnidadMedidaDTO(getDefaultUUID(id), EMPTY);
	}
}
