package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventario.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.inventario.domain.builder.AlmacenDTOBuilder.getAlmacenDTOBuilder;

import java.util.UUID;

public class SeccionDTO {

	private UUID id;
	private String nombre;
	private String descripcion;
	private AlmacenDTO almacen;

	public SeccionDTO() {
		setId(getNewUUID());
		setNombre(EMPTY);
		setAlmacen(getAlmacenDTOBuilder().build());
		setDescripcion(EMPTY);

	}

	public SeccionDTO(final UUID id, final String nombre, final AlmacenDTO almacen,
			final String descripcion) {
		setId(id);
		setNombre(nombre);
		setAlmacen(almacen);
		setDescripcion(descripcion);

	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final void setDescripcion(String descripcion) {
		this.descripcion = applyTrim(descripcion);
	}

	public final void setAlmacen(AlmacenDTO almacen) {
		this.almacen = getDefaultIfNull(almacen, getAlmacenDTOBuilder().build());
	}

	public final AlmacenDTO getAlmacen() {
		return almacen;
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(String nombre) {
		this.nombre = applyTrim(nombre);
	}

	
	
	public static final SeccionDTO create(final String nombre,
			final AlmacenDTO almacen, final String descripcion) {
		return new SeccionDTO(UUID.randomUUID(), nombre, almacen, descripcion);
	}
	
	public static final SeccionDTO create(final String id, final String nombre,
			final AlmacenDTO almacen, final String descripcion) {
		return new SeccionDTO(getUUIDFromString(id),nombre, almacen, descripcion);
	}
	
	public static final SeccionDTO create(final UUID id, final String nombre,
			final AlmacenDTO almacen, final String descripcion) {
		return new SeccionDTO(getDefaultUUID(id), nombre, almacen, descripcion);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
}
