package edu.uco.budget.controller.response;

import java.util.ArrayList;
import java.util.List;

import edu.uco.inventario.crosscutting.helper.ObjectHelper;
import edu.uco.inventario.crosscutting.messages.Message;

public class Response<T>{
	
	private List<Message> message;
	private List<T> data;
	public Response(List<Message> message, List<T> data) {
		super();
		setMessage(message);
		setData( data);
	}
	
	public Response() {
		
		setMessage(new ArrayList<>());
		setData( new ArrayList<>());
	}

	public final List<Message> getMessages() {
		return message;
	}

	public final void setMessage(List<Message> messages) {
		this.message = ObjectHelper.getDefaultIfNull(messages, new ArrayList<>());
	}

	public final List<T> getData() {
		return data;
	}

	public final void setData(List<T> data) {
		this.data = ObjectHelper.getDefaultIfNull(data, new ArrayList<>());;
	}
	
	public void addFatalMessage(String content) {
		getMessages().add(Message.createFatalMessage(content));
	}
	
	public void addErrorMesssge(String content) {
		getMessages().add(Message.createErrorMessage(content));
	}
	
	public void addWarningMessage(String content) {
		getMessages().add(Message.createWarningMessage(content));
	}
	public void addInfoMessage(String content) {
		getMessages().add(Message.createInfoMessage(content));
	}
	
	public void addSuccessMessage(String content) {
		getMessages().add(Message.createSuccessMessage(content));
	}
	
	
	
	

}
