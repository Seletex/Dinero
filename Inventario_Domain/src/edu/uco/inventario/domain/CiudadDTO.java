package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.inventario.domain.builder.DepartamentoDTOBuilder.getDepartamentoDTOBuilder;
import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventario.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;



import java.util.UUID;

import edu.uco.inventario.crosscutting.helper.UUIDHelper;



public class CiudadDTO {

	private UUID id;
	private String nombre;
	private DepartamentoDTO departamento;

	public CiudadDTO() {
		setId(getNewUUID());
		setNombre(EMPTY);
		setDepartamento(getDepartamentoDTOBuilder().build());
	}

	public CiudadDTO(final UUID id, final String nombre,
			final DepartamentoDTO departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
	}

	public final DepartamentoDTO getDepartamento() {
		return departamento;
	}

	public final void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = getDefaultIfNull(departamento,
				getDepartamentoDTOBuilder().build());
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

	public static final CiudadDTO create( final String nombre,
			final DepartamentoDTO departamento) {
		return new CiudadDTO(UUID.randomUUID(), nombre, departamento);
	}
	
	public static final CiudadDTO create(final String id, final String nombre,
			final DepartamentoDTO departamento) {
		return new CiudadDTO(getUUIDFromString(id), nombre, departamento);
	}
	
	public static final CiudadDTO create(final UUID id, final String nombre,
			final DepartamentoDTO departamento) {
		return new CiudadDTO(getDefaultUUID(id), nombre, departamento);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	
	public final boolean notExist() {
		return UUIDHelper.isDefualtUUID(id);
		//50 minute
	}
	
	
}
