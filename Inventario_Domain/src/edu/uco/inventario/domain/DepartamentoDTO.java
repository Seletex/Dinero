package edu.uco.inventario.domain;


import static edu.uco.inventario.domain.builder.PaisDTOBuilder.getPaisDTOBuilder;
import static edu.uco.inventario.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventario.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;



public class DepartamentoDTO {

	private UUID id;
	private String nombre;
	private PaisDTO pais;

	public DepartamentoDTO() {
		setId(getNewUUID());
		setNombre(EMPTY);
		setPais(PaisDTO.create(getNewUUID(), EMPTY));
	}

	public DepartamentoDTO(final UUID id, final String nombre, final PaisDTO pais) {
		setId(id);
		setNombre(nombre);
		setPais(pais);
	}

	public final PaisDTO getPais() {
		return pais;
	}

	public final void setPais(PaisDTO pais) {
		this.pais = getDefaultIfNull(pais, getPaisDTOBuilder().build());
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
	
	
	public static final DepartamentoDTO create( final String nombre,
			final PaisDTO pais) {
		return new DepartamentoDTO(UUID.randomUUID(), nombre, pais);
	}
	
	public static final DepartamentoDTO create(final String id, final String nombre,
			final PaisDTO pais) {
		return new DepartamentoDTO(getUUIDFromString(id), nombre, pais);
	}
	
	public static final DepartamentoDTO create(final UUID id, final String nombre,
			final PaisDTO pais) {
		return new DepartamentoDTO(getDefaultUUID(id), nombre, pais);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

}
