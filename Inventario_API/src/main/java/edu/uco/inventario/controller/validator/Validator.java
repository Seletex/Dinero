package edu.uco.inventario.controller.validator;

import java.util.List;

import edu.uco.inventario.crosscutting.messages.MessageUser;

public interface Validator<T> {

	
	List<MessageUser> validate(T dto);
}
