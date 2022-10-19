package edu.uco.inventory.domain.builder;

import java.util.UUID;
import edu.uco.inventory.domain.DepartamentoDTO;
import edu.uco.inventory.domain.PaisDTO;
import static edu.uco.inventory.domain.DepartamentoDTO.create;

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
