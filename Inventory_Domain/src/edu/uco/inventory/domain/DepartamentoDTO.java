package edu.uco.inventory.domain;

import static edu.uco.inventory.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventory.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getNewUUID;

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
		this.pais = pais;
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
	
	public static final DepartamentoDTO create(final UUID id, final String nombre, final PaisDTO pais) {
		return new DepartamentoDTO(id, nombre, pais);
	}

}
