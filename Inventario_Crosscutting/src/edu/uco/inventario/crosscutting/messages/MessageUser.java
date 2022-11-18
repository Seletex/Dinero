package edu.uco.inventario.crosscutting.messages;

import edu.uco.inventario.crosscutting.helper.ObjectHelper;
import edu.uco.inventario.crosscutting.helper.StringHelper;
import edu.uco.inventario.crosscutting.messages.enumeration.MessageLevel;
import edu.uco.inventario.crosscutting.messages.enumeration.UsuarioLevel;

public class MessageUser {
	
	private String contenido;
	private MessageLevel level;
	

	private UsuarioLevel usuarioMessage;
	
	public MessageUser() {
		setLevel(MessageLevel.FATAL);
		setUsuarioMessage(UsuarioLevel.EMPLEADO);
		setContenido(StringHelper.EMPTY);
	}
	
	public MessageUser(UsuarioLevel usuarioLevel,String contenido,MessageLevel level) {
		super();
		setLevel(level);
		setUsuarioMessage(usuarioLevel);
		setContenido(contenido);
	}
	
	public static MessageUser createFatalEmpleadoMessageUser(final String content) {
		return new MessageUser(UsuarioLevel.EMPLEADO,content,MessageLevel.FATAL);
	}
	public static MessageUser createErrorEmpleadoMessageUser(final String content) {
		return new MessageUser(UsuarioLevel.EMPLEADO,content,MessageLevel.ERROR);
	}
	public static MessageUser createInfoEmpleadoMessageUser(final String content) {
		return new MessageUser(UsuarioLevel.EMPLEADO,content,MessageLevel.INFO);
	}
	public static MessageUser createSuccessEmpleadoMessageUser(final String content) {
		return new MessageUser(UsuarioLevel.EMPLEADO,content,MessageLevel.SUCCESS);
	}
	public static MessageUser createWarningEmpleadoMessageUser(final String content) {
		return new MessageUser(UsuarioLevel.EMPLEADO,content,MessageLevel.WARNING);
	}
	public static MessageUser createImpossibleEmpleadoMessageUser(final String content) {
		return new MessageUser(UsuarioLevel.EMPLEADO,content,MessageLevel.IMPOSSIBLE);
	}
	
	public static MessageUser createFatalSupervisorMessageUser(final String content) {
		return new MessageUser(UsuarioLevel.SUPERVISOR,content,MessageLevel.FATAL);
	}
	public static MessageUser createErrorSupervisorMessageUser(final String content) {
		return new MessageUser(UsuarioLevel.SUPERVISOR,content,MessageLevel.ERROR);
	}
	public static MessageUser createInfoSupervisorMessageUser(final String content) {
		return new MessageUser(UsuarioLevel.SUPERVISOR,content,MessageLevel.INFO);
	}
	public static MessageUser createSuccessSupervisorMessageUser(final String content) {
		return new MessageUser(UsuarioLevel.SUPERVISOR,content,MessageLevel.SUCCESS);
	}
	public static MessageUser createWarningSupervisorMessageUser(final String content) {
		return new MessageUser(UsuarioLevel.SUPERVISOR,content,MessageLevel.WARNING);
	}
	public static MessageUser createImpossibleSupervisorMessageUser(final String content) {
		return new MessageUser(UsuarioLevel.SUPERVISOR,content,MessageLevel.IMPOSSIBLE);
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
	

	public final String getContenido() {
		return contenido;
	}

	public final void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public final UsuarioLevel getUsuarioMessage() {
		return usuarioMessage;
	}

	public final void setUsuarioMessage(UsuarioLevel empleado) {
		this.usuarioMessage = ObjectHelper.getDefaultIfNull(empleado, UsuarioLevel.EMPLEADO);
	}
	
	public final MessageLevel getLevel() {
		return level;
	}

	public final void setLevel(MessageLevel level) {
		this.level = ObjectHelper.getDefaultIfNull(level, MessageLevel.FATAL);
	}
	
	

}
