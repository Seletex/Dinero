package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventario.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
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
		setAlmacen(AlmacenDTO.create(getNewUUID(), EMPTY, null, null, null));
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

	public static final SeccionDTO create(final UUID id, final String nombre,
			final AlmacenDTO almacen, final String descripcion) {
		return new SeccionDTO(id, nombre, almacen, descripcion);
	}
}
