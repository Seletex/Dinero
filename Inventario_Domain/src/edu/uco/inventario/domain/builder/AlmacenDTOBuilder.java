package edu.uco.inventario.domain.builder;

import static edu.uco.inventario.domain.AlmacenDTO.create;

import java.util.UUID;

import edu.uco.inventario.domain.AlmacenDTO;
import edu.uco.inventario.domain.CiudadDTO;


public class AlmacenDTOBuilder {
	private UUID id;
	private String nombre;
	private String descripcion;
	private String direccion;
	private CiudadDTO ciudad;
	
	private AlmacenDTOBuilder() {
		super();
	}

	public static final AlmacenDTOBuilder getAlmacenDTOBuilder() {
		return new AlmacenDTOBuilder();
	}

	public final AlmacenDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final AlmacenDTOBuilder setNombre(final String nombre) {
		this.nombre = nombre;
		return this;
	}

	public final AlmacenDTOBuilder setCiudad(final CiudadDTO ciudad) {
		this.ciudad = ciudad;
		return this;
	}

	public final AlmacenDTOBuilder setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public final AlmacenDTOBuilder setDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}

	public AlmacenDTO build() {
		return create(id, nombre, ciudad,descripcion,direccion);
	}

	
}
