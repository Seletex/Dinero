package edu.uco.inventario.domain.builder;

import static edu.uco.inventario.domain.CiudadDTO.create;

import java.util.UUID;

import edu.uco.inventario.domain.CiudadDTO;
import edu.uco.inventario.domain.DepartamentoDTO;

public class CiudadDTOBuilder {

	   
	private  String nombre;
	private DepartamentoDTO departamento;
	private UUID id; 

	private CiudadDTOBuilder() {
		super();
	}

	public static final CiudadDTOBuilder getCiudadDTOBuilder() {
		return new CiudadDTOBuilder();
	}

	public final CiudadDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final CiudadDTOBuilder setNombre(final String nombre) {
		this.nombre = nombre;
		return this;
	}

	public final CiudadDTOBuilder setDepartamento(final DepartamentoDTO departamento) {
		this.departamento = departamento;
		return this;
	}

	public CiudadDTO build() {
		return create(id, nombre, departamento);
	}
	
	public static final CiudadDTOBuilder getPersonDTOBuilder() {
		return new CiudadDTOBuilder();
	}
	

	
}
