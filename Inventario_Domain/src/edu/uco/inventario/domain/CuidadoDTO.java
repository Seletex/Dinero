package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventario.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

public class CuidadoDTO {
	private UUID id;
	private String descripcion;

	public CuidadoDTO() {
		setId(getNewUUID());
		setDescripcion(EMPTY);
	}

	public CuidadoDTO(UUID id, String descripcion) {

		setId(id);
		setDescripcion(descripcion);
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

	public static final CuidadoDTO create( final String descripcion) {
		return new CuidadoDTO(UUID.randomUUID(), descripcion);
	}
	
	public static final CuidadoDTO create(final String id, final String descripcion) {
		return new CuidadoDTO(getUUIDFromString(id), descripcion);
	}
	
	public static final CuidadoDTO create(final UUID id, final String descripcion) {
		return new CuidadoDTO(getDefaultUUID(id), descripcion);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	
	public static final CuidadoDTO create() {
		return new CuidadoDTO(UUID.randomUUID(), EMPTY);
	}
	
	public static final CuidadoDTO create(final UUID id) {
		return new CuidadoDTO(getDefaultUUID(id), EMPTY);
	}
}
