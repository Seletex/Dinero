package edu.uco.inventario.domain;

import static edu.uco.inventario.domain.builder.CiudadDTOBuilder.getCiudadDTOBuilder;
import static edu.uco.inventario.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventario.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;



public class AlmacenDTO {
	private UUID id;
	private String nombre;
	private String descripcion;
	private String direccion;
	private CiudadDTO ciudad;

	public AlmacenDTO() {
		setId(getNewUUID());
		setNombre(EMPTY);
		setCiudad(getCiudadDTOBuilder().build());
		setDescripcion(EMPTY);
		setDireccion(EMPTY);
	}

	public AlmacenDTO(final UUID id, final String nombre, final CiudadDTO ciudad, final String descripcion, final String direccion) {
		setId(id);
		setNombre(nombre);
		setCiudad(ciudad);
		setDescripcion(descripcion);
		setDireccion(direccion);
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final void setDescripcion(String descripcion) {
		this.descripcion = applyTrim(descripcion);
	}

	public final String getDireccion() {
		return direccion;
	}

	public final void setDireccion(String direccion) {
		this.direccion = applyTrim(direccion);
	}

	public final CiudadDTO getCiudad() {
		return ciudad;
	}	

	public final void setCiudad(CiudadDTO ciudad) {
		this.ciudad = getDefaultIfNull(ciudad, getCiudadDTOBuilder().build());
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
	
	public static final AlmacenDTO create( final String nombre, final CiudadDTO ciudad, final String descripcion, final String direccion) {
		return new AlmacenDTO(UUID.randomUUID(), nombre, ciudad, descripcion, direccion);
	}
	
	public static final AlmacenDTO create(final String id, final String nombre, final CiudadDTO ciudad, final String descripcion, final String direccion) {
		return new AlmacenDTO(getUUIDFromString(id), nombre, ciudad, descripcion, direccion);
	}
	
	public static final AlmacenDTO create(final UUID id, final String nombre, final CiudadDTO ciudad, final String descripcion, final String direccion) {
		return new AlmacenDTO(getDefaultUUID(id), nombre, ciudad, descripcion, direccion);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	
	

}
