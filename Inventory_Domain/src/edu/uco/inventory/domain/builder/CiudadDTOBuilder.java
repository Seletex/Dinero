package edu.uco.inventory.domain.builder;

import static edu.uco.inventory.domain.CiudadDTO.create;

import java.util.UUID;


import edu.uco.inventory.domain.CiudadDTO;
import edu.uco.inventory.domain.DepartamentoDTO;

public class CiudadDTOBuilder {

	   
	private  String nombre;
	private DepartamentoDTO departamento;
	private UUID id; // se usa en set id pero me pide que lo borre

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
