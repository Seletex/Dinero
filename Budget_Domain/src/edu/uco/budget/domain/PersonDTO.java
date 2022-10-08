package edu.uco.budget.domain;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.budget.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.budget.crosscutting.helper.StringHelper.applyTrim;

import java.util.UUID;

public final class PersonDTO {

	private UUID id;
	private String idCard;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;

	public PersonDTO() {
		setId(getNewUUID());
		setIdCard(EMPTY);
		setFirstName(EMPTY);
		setSecondName(EMPTY);
		setFirstSurname(EMPTY);
		setSecondName(EMPTY);
		
	}

	public PersonDTO(final UUID id, final String idCard, final String firstName, final String secondName,
			final String firstSurname, final String secondSurname) {

		setId(id);
		setIdCard(idCard);
		setFirstName(firstName);
		setSecondName(secondName);
		setFirstSurname(firstSurname);
		setSecondName(secondSurname);
	}

	public final static PersonDTO create(UUID id, String idCard, String firstName, String secondName, String firstSurname, String secondSurname) {
		return new PersonDTO(id, idCard, firstName, secondName, firstSurname, secondSurname);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final String getIdCard() {
		return idCard;
	}

	public final void setIdCard(final String idCard) {
		this.idCard = applyTrim(idCard);
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(final String firstName) {
		this.firstName = applyTrim(firstName);
	}

	public final String getSecondName() {
		return secondName;
	}

	public final void setSecondName(final String secondName) {
		this.secondName = applyTrim(secondName);
	}

	public final String getFirstSurname() {
		return firstSurname;
	}

	public final void setFirstSurname(final String firstSurname) {
		this.firstSurname = applyTrim(firstSurname);
	}

	public final String getSecondSurname() {
		return secondSurname;
	}

	public final void setSecondSurname(final String secondSurname) {
		this.secondSurname = applyTrim(secondSurname);
	}

}