package edu.uco.inventario.domain.builder;

import static edu.uco.inventario.domain.DepartamentoDTO.create;

import java.util.UUID;

import edu.uco.inventario.domain.DepartamentoDTO;
import edu.uco.inventario.domain.PaisDTO;

public class DepartamentoDTOBuilder {
	private UUID id;
	private String nombre;
	private PaisDTO pais;

	private DepartamentoDTOBuilder(){
		super();
	}
	
	public static final DepartamentoDTOBuilder getDepartamentoDTOBuilder() {
		return new DepartamentoDTOBuilder();
	}

	public final DepartamentoDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final DepartamentoDTOBuilder setNombre(final String nombre) {
		this.nombre = nombre;
		return this;
	}

	public final DepartamentoDTOBuilder setPais(final PaisDTO pais) {
		this.pais = pais;
		return this;
	}
	
	public DepartamentoDTO build() {
		return create(id, nombre, pais);
	}

	
	
	
}
