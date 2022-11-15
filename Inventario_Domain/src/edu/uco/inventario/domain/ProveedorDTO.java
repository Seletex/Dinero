package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventario.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

public class ProveedorDTO {
	
	private UUID id;
	private String nombre;
	private String contacto;
	
	public ProveedorDTO() {
		setId(getNewUUID());
		setNombre(EMPTY);
		setContacto(EMPTY);
	}

	public ProveedorDTO(final UUID id, final String nombre,
			final String contacto) {
		setId(id);
		setNombre(nombre);
		setContacto(contacto);
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
	public final String getConctacto() {
		return contacto;
	}
	public final void setContacto(String contacto) {
		this.contacto = applyTrim(contacto);
	}
	
	public static final ProveedorDTO create( final String nombre,
			final String contacto) {
		return new ProveedorDTO(UUID.randomUUID(), nombre, contacto);
	}
	
	public static final ProveedorDTO create(final String id, final String nombre,
			final String contacto) {
		return new ProveedorDTO(getUUIDFromString(id), nombre, contacto);
	}
	
	public static final ProveedorDTO create(final UUID id, final String nombre,
			final String contacto) {
		return new ProveedorDTO(getDefaultUUID(id), nombre, contacto);
	}
	
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

}
