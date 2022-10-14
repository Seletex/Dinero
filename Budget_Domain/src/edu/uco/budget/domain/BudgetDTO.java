package edu.uco.budget.domain;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.budget.crosscutting.helper.StringHelper.EMPTY;



import java.util.UUID;

public final class BudgetDTO {

	private UUID id;
	private PersonDTO persona;
	private YearDTO year;



	public BudgetDTO(final UUID id, final PersonDTO persona, final YearDTO year) {
		setId(id);
		setPersona(persona);
		setYear(year);
		
	}

	public BudgetDTO() {
		setId(getNewUUID());
		
		setPersona(PersonDTO.create(getId(), EMPTY, EMPTY, EMPTY, EMPTY, EMPTY));
		setYear(YearDTO.create(getNewUUID(), 0));
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

	public final YearDTO getYear() {
		return year;
	}

	public final void setYear(final YearDTO year) {
		this.year = (year);
	}



	public static final BudgetDTO create(final UUID id, final PersonDTO persona, final YearDTO year) {
		return new BudgetDTO(id, persona, year);
	}

}                                                                                                                                      //a partir de 6:30 empieza el compartido de este preyecto y los comprate Steven
