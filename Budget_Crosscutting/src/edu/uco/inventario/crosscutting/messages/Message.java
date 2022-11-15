package edu.uco.inventario.crosscutting.messages;

import edu.uco.inventario.crosscutting.helper.ObjectHelper;
import edu.uco.inventario.crosscutting.helper.StringHelper;
import edu.uco.inventario.crosscutting.messages.enumeration.MessageLevel;

public class Message {

	private MessageLevel level;
	private String content;
	
	public Message() {
		setLevel(MessageLevel.FATAL);
		setContent(StringHelper.EMPTY);
	}
	
	public Message(MessageLevel level,String content ) {
		super();
		setLevel(level);
		setContent(content);
	}
	
	public static Message createFatalMessage(final String content) {
		return new Message(MessageLevel.FATAL,content);
	}
	public static Message createErrorMessage(final String content) {
		return new Message(MessageLevel.ERROR,content);
	}
	public static Message createInfoMessage(final String content) {
		return new Message(MessageLevel.INFO,content);
	}
	public static Message createSuccessMessage(final String content) {
		return new Message(MessageLevel.SUCCESS,content);
	}
	public static Message createWarningMessage(final String content) {
		return new Message(MessageLevel.WARNING,content);
	}
	

	public final MessageLevel getLevel() {
		return level;
	}

	public final void setLevel(final MessageLevel level) {
		this.level = ObjectHelper.getDefaultIfNull(level, MessageLevel.FATAL);
	}

	public final String getContent() {
		return content;
	}

	public final void setContent(final String content) {
		this.content = StringHelper.applyTrim(content);
	}
	
}
