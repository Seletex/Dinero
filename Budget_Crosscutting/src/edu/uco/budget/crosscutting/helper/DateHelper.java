package edu.uco.budget.crosscutting.helper;


import java.time.LocalDate;

public final class DateHelper {
	
	public static final byte ZERO = 0;
	
	private DateHelper() {
		super();

	}
	
	public static final short getNextYear() {
		return (short)LocalDate.now().plusYears(1).getYear();
	}
	
}
