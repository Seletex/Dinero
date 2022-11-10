package edu.uco.inventory.domain;

import static edu.uco.inventory.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventory.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getNewUUID;

import java.util.UUID;

public class UsuarioDTO {
	
	private UUID id;
	private String nombre;
	private String apellido;
	
	
	public UsuarioDTO() {
		setId(getNewUUID());
		setNombre(EMPTY);
		setApellido(EMPTY);
	}

	public UsuarioDTO(final UUID id, final String nombre,
			final String apellido) {
		setId(id);
		setNombre(nombre);
		setApellido(apellido);
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
	
	

}
