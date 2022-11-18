package edu.uco.inventario.crosscutting.helper;


import java.time.LocalDate;
import java.time.LocalDateTime;

public final class DateHelper {
	
	public static final byte ZERO = 0;
	
	private DateHelper() {
		super();

	}
	
	public static final short getNextYear() {
		return (short)LocalDate.now().plusYears(1).getYear();
	}
	

	public static final int fechaHelper() {
		return LocalDateTime.now().plusSeconds(1).getSecond();
	}
	
	public static final LocalDate TIME_AT_CREATION() {
		return LocalDateTime.now().plusNanos(1).toLocalDate();
		
	}
	
}
