package edu.uco.budget.domain;

import static edu.uco.budget.crosscutting.helper.NumberHelper.ZERO;
import static edu.uco.budget.crosscutting.helper.NumberHelper.isLessThan;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

public final class YearDTO {

	private UUID id;
	private short yearNumber;

	public YearDTO() {
		setId(getNewUUID());
		setYearNumber(ZERO);
	}

	public YearDTO(final UUID id, final int i) {

		setId(id);
		setYearNumber(i);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final short getYearNumber() {
		return yearNumber;
	}

	public final void setYearNumber(int i) {
		this.yearNumber = (short) (isLessThan(i, ZERO) ? ZERO : i);
	}

	public static final YearDTO create(final UUID id, final int yearNumber) {
		return new YearDTO(UUID.randomUUID(), yearNumber);
	}
	
	public static final YearDTO create(final String id, final int yearNumber) {
		return new YearDTO(getUUIDFromString(id), yearNumber);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

	
	

}
