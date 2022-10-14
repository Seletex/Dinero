package edu.uco.budget.domain.builder;

import java.util.UUID;

import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.domain.YearDTO;
import static edu.uco.budget.domain.BudgetDTO.create;

public final class BudgetDTOBuilder {

	private UUID id;
	private PersonDTO persona;
	private YearDTO year;
	

	public BudgetDTOBuilder() {
		super();
	}

	public final void setId(final UUID id) {
		this.id = id;
	}

	public final void setPersona(final PersonDTO persona) {
		this.persona = persona;
	}

	public final void setAno(final YearDTO year) {
		this.year = year;
	}

	

	public BudgetDTO build() {
		return create(id, persona, year);

	}
	
	public static final BudgetDTOBuilder getBudgetDTOBuilder() {
		return new BudgetDTOBuilder();
	}

}
