package edu.uco.budget.domain;

import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventario.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

import edu.uco.inventario.crosscutting.helper.UUIDHelper;



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

	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

	public static final PersonDTO create(final String id,final  String idCard,final  String firstName,final  String secondName,final  String firstSurnmame,final 
			String secondSurname) {
		
		return new PersonDTO(getUUIDFromString(id), idCard, firstName, secondName, firstSurnmame, secondSurname);
	}
	
	public static final PersonDTO create(final UUID id,final  String idCard,final  String firstName,final  String secondName,final  String firstSurnmame,final 
			String secondSurname) {
		
		return new PersonDTO(getDefaultUUID(id), idCard, firstName, secondName, firstSurnmame, secondSurname);
	}
	
	public static final PersonDTO create(final String idCard,final String firstName,final String secondName,final String firstSurname,final String secondSurname) {
		return new PersonDTO(UUID.randomUUID(), idCard, firstName, secondName, firstSurname, secondSurname);
	}

	public static final PersonDTO create() {
		return new PersonDTO(UUID.randomUUID(), EMPTY, EMPTY, EMPTY, EMPTY, EMPTY);
	}
	
	public static final PersonDTO create(final UUID id) {
		return new PersonDTO(getDefaultUUID(id), EMPTY, EMPTY, EMPTY, EMPTY, EMPTY);
	}
	
	public final boolean notExist() {
		return UUIDHelper.isDefualtUUID(id);
		//50 minute
	}
}
