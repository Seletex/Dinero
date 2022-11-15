package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventario.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

import edu.uco.inventario.crosscutting.helper.UUIDHelper;

public class TipoUnidadDTO {
	private UUID id;
	private String nombre;
	private UnidadMedidaDTO medida;

	public TipoUnidadDTO() {
		setId(getNewUUID());
		setNombre(EMPTY);
		setMedida(UnidadMedidaDTO.create(getNewUUID(), EMPTY));
	}

	public TipoUnidadDTO(final UUID id, final String nombre,
			final UnidadMedidaDTO medida) {
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

	public static final TipoUnidadDTO create(final String nombre,
			final UnidadMedidaDTO medida) {
		return new TipoUnidadDTO(UUID.randomUUID(), nombre, medida);
	}

	public static final TipoUnidadDTO create(final String id, final String nombre,
			final UnidadMedidaDTO medida) {
		return new TipoUnidadDTO(getUUIDFromString(id), nombre, medida);
	}

	public static final TipoUnidadDTO create(final UUID id, final String nombre,
			final UnidadMedidaDTO medida) {
		return new TipoUnidadDTO(getDefaultUUID(id), nombre, medida);
	}

	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

	public final boolean notExist() {
		return UUIDHelper.isDefualtUUID(id);
		// 50 minute
	}
}
