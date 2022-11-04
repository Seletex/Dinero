package edu.uco.inventory.crosscutting.exception;
import static edu.uco.inventory.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.inventory.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventory.crosscutting.helper.StringHelper.isEmpty;

import edu.uco.inventory.crosscutting.exception.enumeration.LayerException;

public class BudgetCustomException extends RuntimeException {
	
	private static final long serialVersionUID = -1664115099034021355L;
	private String userMessage;
	private LayerException layer;
	
	protected BudgetCustomException(final String userMessage, final String technicalMessage,final Throwable rootException,final LayerException layer) {
		super(applyTrim(technicalMessage),getDefaultIfNull(rootException, new Exception()));
		setUserMessage(userMessage);
		setLayer(layer);
		
		
	}

	public final String getUserMessage() {
		return userMessage;
	}

	private final void setUserMessage(String userMessage) {
		this.userMessage = applyTrim(userMessage);
	}

	public final LayerException getLayer() {
		return layer;
	}

	private final void setLayer(LayerException layer) {
		this.layer = getDefaultIfNull(layer, LayerException.APPLICATION);
	}
	
	public final boolean isTchnicalException() {
		return isEmpty(getUserMessage());
	}

}
