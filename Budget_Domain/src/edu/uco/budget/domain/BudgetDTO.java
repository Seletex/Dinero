package edu.uco.budget.domain;

import static edu.uco.budget.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.budget.domain.builder.PersonDTOBuilder.getPersonDTOBuilder;
import static edu.uco.budget.domain.builder.YearDTOBuilder.getYearDTOBuilder;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;

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
		
		setPersona(getPersonDTOBuilder().build());
		setYear(getYearDTOBuilder().build());
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
		this.persona = getDefaultIfNull(persona, getPersonDTOBuilder().build());
	}

	public final YearDTO getYear() {
		return year;
	}

	public final void setYear(final YearDTO year) {
		this.year = getDefaultIfNull(year, getYearDTOBuilder().build());
	}



	public static final BudgetDTO create(final UUID id, final PersonDTO persona, final YearDTO year) {
		
		return new BudgetDTO(UUID.randomUUID(), persona, year);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

}                                                                                                                                      //a partir de 6:30 empieza el compartido de este preyecto y los comprate Steven
