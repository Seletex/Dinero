package edu.uco.inventory.crosscutting.exception.data;

import edu.uco.inventory.crosscutting.exception.BudgetCustomException;
import edu.uco.inventory.crosscutting.exception.enumeration.LayerException;

import static edu.uco.inventory.crosscutting.helper.StringHelper.EMPTY;

public class CrosscuttingCustomException extends BudgetCustomException{

	private static final long serialVersionUID = 6955662894932198270L;
	
	private CrosscuttingCustomException(final String userMessage,final String technicalMessage, final Exception rootException) {
		super(userMessage,technicalMessage,rootException,LayerException.CROSSCUTTING);
	}
	
	public static final BudgetCustomException createUserException(final String userMessage) {
		return new CrosscuttingCustomException(userMessage,userMessage, new Exception());
	}
	
	public static final BudgetCustomException createTechnicalException(final String technicalMessage) {
		return new CrosscuttingCustomException(EMPTY,technicalMessage, new Exception());
	}
	
	public static final BudgetCustomException createTechnicalException(final String technicalMessage,final Exception rootException) {
		return new CrosscuttingCustomException(EMPTY,technicalMessage,rootException);
	}
	
	public static final BudgetCustomException create(final String userMessage,final String technicalMessage) {
		return new CrosscuttingCustomException(userMessage,technicalMessage, new Exception());
	}
	
	public static final BudgetCustomException create(final String userMessage,final String technicalMessage,final Exception rootException) {
		return new CrosscuttingCustomException(userMessage,technicalMessage, rootException);
	}
}
