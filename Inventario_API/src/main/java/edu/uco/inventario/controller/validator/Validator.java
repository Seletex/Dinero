package edu.uco.inventario.controller.validator;

import java.util.List;

import edu.uco.inventario.crosscutting.messages.Message;

public interface Validator<T> {

	
	List<Message> validate(T dto);
}
