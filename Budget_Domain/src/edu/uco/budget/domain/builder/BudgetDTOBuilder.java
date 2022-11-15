package edu.uco.budget.domain.builder;

import java.util.UUID;

import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.domain.YearDTO;


public final class BudgetDTOBuilder {

	private UUID id;
	private PersonDTO persona;
	private YearDTO year;
	

	public BudgetDTOBuilder() {
		super();
	}

	public final BudgetDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final BudgetDTOBuilder setPersona(final PersonDTO persona) {
		this.persona = persona;
		return this;
	}

	public final BudgetDTOBuilder setAno(final YearDTO year) {
		this.year = year;
		return this;
	}

	

	public BudgetDTO build() {
		return BudgetDTO.create(id, persona, year);

	}
	
	public static final BudgetDTOBuilder getBudgetDTOBuilder() {
		return new BudgetDTOBuilder();
	}

}
