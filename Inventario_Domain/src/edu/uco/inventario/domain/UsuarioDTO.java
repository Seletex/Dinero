package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventario.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

import edu.uco.inventario.crosscutting.helper.UUIDHelper;

public class UsuarioDTO {
	
	private UUID id;
	private String nombre;
	private String apellido;
	private String cargo;
	
	
	public UsuarioDTO() {
		setId(getNewUUID());
		setNombre(EMPTY);
		setApellido(EMPTY);
		setCargo(EMPTY);
	}

	public final String getCargo() {
		return cargo;
	}

	public final void setCargo(String cargo) {
		applyTrim(cargo);
	}

	public UsuarioDTO(final UUID id, final String nombre,
			final String apellido, final String cargo) {
		setId(id);
		setNombre(nombre);
		setApellido(apellido);
		setCargo(cargo);
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
	public final String getApellido() {
		return apellido;
	}
	public final void setApellido(final String apellido) {
		this.apellido = applyTrim(apellido);
	}
	
	public static final UsuarioDTO create( final String nombre,
			final String apellido, final String cargo) {
		return new UsuarioDTO(UUID.randomUUID(), nombre, apellido, cargo);
	}
	
	public static final UsuarioDTO create(final String id, final String nombre,
			final String apellido, final String cargo) {
		return new UsuarioDTO(getUUIDFromString(id), nombre, apellido, cargo);
	}
	
	public static final UsuarioDTO create(final UUID id, final String nombre,
			final String apellido, final String cargo) {
		return new UsuarioDTO(getDefaultUUID(id), nombre, apellido, cargo);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	
	public final boolean notExist() {
		return UUIDHelper.isDefualtUUID(id);
		//50 minute
	}
	
	

}
