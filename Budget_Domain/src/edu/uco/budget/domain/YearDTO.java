package edu.uco.budget.domain;

import java.util.UUID;
import static edu.uco.budget.crosscutting.helper.NumberHelper.isLessThan;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.budget.crosscutting.helper.NumberHelper.ZERO;

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

	public static final YearDTO create(UUID id, int i) {
		return new YearDTO(UUID.randomUUID(), i);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

}
