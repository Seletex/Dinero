package edu.uco.budget.domain;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.budget.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.budget.crosscutting.helper.StringHelper.applyTrim;


import java.util.UUID;

public final class BudgetDTO {

	private UUID id;
	private PersonDTO persona;
	private YearDTO año;
	private String descripcion;

	public BudgetDTO(final UUID id, final PersonDTO persona, final YearDTO año, final String descripcion) {
		setId(id);
		setPersona(persona);
		setAño(año);
		setDescripcion(descripcion);
	}

	public BudgetDTO() {
		setId(getNewUUID());
		setDescripcion(EMPTY);
		setPersona(PersonDTO.create(getId(), EMPTY, EMPTY, EMPTY, EMPTY, EMPTY));
		setAño(YearDTO.create(getNewUUID(), 0));
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final PersonDTO getPersona() {
		return persona;
	}

	public final void setPersona(final PersonDTO persona) {
		this.persona = persona;
	}

	public final YearDTO getAño() {
		return año;
	}

	public final void setAño(final YearDTO año) {
		this.año = (año);
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final void setDescripcion(final String descripcion) {
		this.descripcion = applyTrim(descripcion);
	}

	public static final BudgetDTO create(final UUID id, final PersonDTO persona, final YearDTO año,
			final String descripcion) {
		return new BudgetDTO(id, persona, año, descripcion);
	}

}
