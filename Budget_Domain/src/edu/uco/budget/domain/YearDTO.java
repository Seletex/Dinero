package edu.uco.budget.domain;

import java.util.UUID;

public final class YearDTO {
	
	private UUID id;
	private short yearNumber;
	
	public YearDTO() {		
	}

	public YearDTO(final UUID id, final short yearNumber) {
		
		this.id = id;
		this.yearNumber = yearNumber;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		
		this.id = id;
	}

	public short getYearNumber() {
		return yearNumber;
	}

	public void setYearNumber(short yearNumber) {
		this.yearNumber = yearNumber;
	}
	
	

}
