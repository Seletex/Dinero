package edu.uco.budget.domain.builder;

import java.util.UUID;

import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.domain.YearDTO;
import static edu.uco.budget.domain.BudgetDTO.create;

public final class BudgetDTOBuilder {

	private UUID id;
	private PersonDTO persona;
	private YearDTO año;
	private String descripcion;

	public BudgetDTOBuilder() {
		super();
	}

	public final void setId(final UUID id) {
		this.id = id;
	}

	public final void setPersona(final PersonDTO persona) {
		this.persona = persona;
	}

	public final void setAño(final YearDTO año) {
		this.año = año;
	}

	public final void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public BudgetDTO build() {
		return create(id, persona, año, descripcion);

	}

}
