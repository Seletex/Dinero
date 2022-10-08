package edu.uco.budget.domain;

import java.util.UUID;

import static edu.uco.budget.crosscutting.helper.NumberHelper.isLessThan;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;

public final class YearDTO {

	public static final byte ZERO = 0;

	private UUID id;
	private short yearNumber;

	public YearDTO() {
	}

	public YearDTO(final UUID id, final short yearNumber) {

		this.id = id;
		this.yearNumber = yearNumber;
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

	public final void setYearNumber(short yearNumber) {
		this.yearNumber = isLessThan(yearNumber, ZERO) ? ZERO : yearNumber;
	}

}
