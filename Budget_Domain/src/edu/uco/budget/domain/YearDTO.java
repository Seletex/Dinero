package edu.uco.budget.domain;

import java.util.UUID;
import static edu.uco.budget.crosscutting.helper.NumberHelper.isLessThan;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.budget.crosscutting.helper.NumberHelper.ZERO;

public final class YearDTO {

	private UUID id;
	private short yearNumber;

	public YearDTO() {
		setId(getNewUUID());
		setYearNumber(ZERO);
	}

	public YearDTO(final UUID id, final short yearNumber) {

		setId(id);
		setYearNumber(yearNumber);
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

	public final static YearDTO create(UUID id, short yearNumber) {
		return new YearDTO(id, yearNumber);
	}

}
