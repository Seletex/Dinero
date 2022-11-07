package edu.uco.inventory.domain;

import static edu.uco.inventory.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventory.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getNewUUID;

import java.util.UUID;

public class TipoUnidadDTO {
	private UUID id;
	private String nombre;
	private UnidadMedidaDTO medida;

	public TipoUnidadDTO() {
		setId(getNewUUID());
		setNombre(EMPTY);
		setMedida(UnidadMedidaDTO.create(getNewUUID(), EMPTY));
	}

	public TipoUnidadDTO(final UUID id, final String nombre, final UnidadMedidaDTO medida) {
		setId(id);
		setNombre(nombre);
		setMedida(medida);
	}

	public final UnidadMedidaDTO getPais() {
		return medida;
	}

	public final void setMedida(UnidadMedidaDTO medida) {
		this.medida = medida;
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
	
	public static final TipoUnidadDTO create(final UUID id, final String nombre, final UnidadMedidaDTO medida) {
		return new TipoUnidadDTO(id, nombre, medida);
	}
}
