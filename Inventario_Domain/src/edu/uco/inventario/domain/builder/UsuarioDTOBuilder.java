package edu.uco.inventario.domain.builder;

import static edu.uco.inventario.domain.UsuarioDTO.create;

import java.util.UUID;

import edu.uco.inventario.domain.UsuarioDTO;

public class UsuarioDTOBuilder {

	private UUID id;
	private String nombre;
	private String apellido;
	private String cargo;

	public final UsuarioDTOBuilder setCargo(String cargo) {
		this.cargo = cargo;
		return this;
	}

	private UsuarioDTOBuilder() {
		super();
	}

	public static final UsuarioDTOBuilder getUsuarioDTOBuilder() {
		return new UsuarioDTOBuilder();
	}

	public final UsuarioDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final UsuarioDTOBuilder setNombre(final String nombre) {
		this.nombre = nombre;
		return this;
	}

	public final UsuarioDTOBuilder setApellido(String apellido) {
		this.apellido = apellido;
		return this;
	}

	public UsuarioDTO build() {
		return create(id, nombre, apellido, cargo);
	}

}
