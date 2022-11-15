package edu.uco.inventario.crosscutting.exception.service;

import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;

import edu.uco.inventario.crosscutting.exception.BudgetCustomException;
import edu.uco.inventario.crosscutting.exception.enumeration.LayerException;

public class ServiceCustomException extends BudgetCustomException {

	protected ServiceCustomException(String userMessage, String technicalMessage,
			Throwable rootException, LayerException layer) {
		super(userMessage, technicalMessage, rootException, layer);
		
	}

	private static final long serialVersionUID = 6955662894932198270L;

	private ServiceCustomException(final String userMessage,
			final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, LayerException.SERVICE);
	}

	public static final ServiceCustomException createUserException(
			final String userMessage) {
		return new ServiceCustomException(userMessage, userMessage, new Exception());
	}

	public static final ServiceCustomException createTechnicalException(
			final String technicalMessage) {
		return new ServiceCustomException(EMPTY, technicalMessage, new Exception());
	}

	public static final ServiceCustomException createTechnicalException(
			final String technicalMessage, final Exception rootException) {
		return new ServiceCustomException(EMPTY, technicalMessage, rootException);
	}

	public static final ServiceCustomException createBusinessException(
			final String businessMessage, final Exception rootException) {
		return new ServiceCustomException(businessMessage, EMPTY, rootException);
	}

	public static final ServiceCustomException create(final String userMessage,
			final String technicalMessage) {
		return new ServiceCustomException(userMessage, technicalMessage, new Exception());
	}

	public static final ServiceCustomException create(final String userMessage,
			final String technicalMessage, final Exception rootException) {
		return new ServiceCustomException(userMessage, technicalMessage, rootException);
	}

	public static final BudgetCustomException wrapException(final String message,
			final BudgetCustomException exception) {
		if (exception.isTchnicalException()) {
			return ServiceCustomException.createBusinessException(message, exception);
		}
		return exception;

	}
}
