package edu.uco.inventory.crosscutting.exception.data;

import static edu.uco.inventory.crosscutting.helper.StringHelper.EMPTY;

import edu.uco.inventory.crosscutting.exception.BudgetCustomException;
import edu.uco.inventory.crosscutting.exception.enumeration.LayerException;

public class DataCustomException extends BudgetCustomException{

	protected DataCustomException(String userMessage, String technicalMessage, Throwable rootException,
			LayerException layer) {
		super(userMessage, technicalMessage, rootException, layer);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 6955662894932198270L;
	
	private DataCustomException(final String userMessage,final String technicalMessage, final Exception rootException) {
		super(userMessage,technicalMessage,rootException,LayerException.CROSSCUTTING);
	}
	
	public static final DataCustomException createUserException(final String userMessage) {
		return new DataCustomException(userMessage,userMessage, new Exception());
	}
	
	public static final DataCustomException createTechnicalException(final String technicalMessage) {
		return new DataCustomException(EMPTY,technicalMessage, new Exception());
	}
	
	public static final DataCustomException createTechnicalException(final String technicalMessage,final Exception rootException) {
		return new DataCustomException(EMPTY,technicalMessage,rootException);
	}
	
	public static final BudgetCustomException create(final String userMessage,final String technicalMessage) {
		return new DataCustomException(userMessage,technicalMessage, new Exception());
	}
	
	public static final DataCustomException create(final String userMessage,final String technicalMessage,final Exception rootException) {
		return new DataCustomException(userMessage,technicalMessage, rootException);
	}
}
