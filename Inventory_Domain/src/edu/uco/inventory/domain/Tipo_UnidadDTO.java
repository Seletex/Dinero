package edu.uco.inventory.domain;

import static edu.uco.inventory.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventory.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getNewUUID;

import java.util.UUID;

public class Tipo_UnidadDTO {
	private UUID id;
	private String nombre;
	private Unidad_MedidaDTO medida;

	public Tipo_UnidadDTO() {
		setId(getNewUUID());
		setNombre(EMPTY);
		setMedida(Unidad_MedidaDTO.create(getNewUUID(), EMPTY));
	}

	public Tipo_UnidadDTO(final UUID id, final String nombre, final Unidad_MedidaDTO medida) {
		setId(id);
		setNombre(nombre);
		setMedida(medida);
	}

	public final Unidad_MedidaDTO getPais() {
		return medida;
	}

	public final void setMedida(Unidad_MedidaDTO medida) {
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
	
	public static final Tipo_UnidadDTO create(final UUID id, final String nombre, final Unidad_MedidaDTO medida) {
		return new Tipo_UnidadDTO(id, nombre, medida);
	}
}
