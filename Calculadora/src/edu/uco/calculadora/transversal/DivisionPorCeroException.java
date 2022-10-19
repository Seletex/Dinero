package edu.uco.calculadora.transversal;

public class DivisionPorCeroException extends Exception{
	private static final long serialVersionUID = 4722307917014565183L;
	private Exception exceptionRaiz;
	private String mensajeTecnico;
	private String mensajeUsuario;

	private DivisionPorCeroException(Exception exceptionRaiz, String mensajeTecnico, String mensajeUsuario) {
		super();
		this.exceptionRaiz = exceptionRaiz;
		this.mensajeTecnico = mensajeTecnico;
		this.mensajeUsuario = mensajeUsuario;
	}

	public static DivisionPorCeroException create(String mensaje) {
		return new DivisionPorCeroException(new Exception(), mensaje, mensaje);
	}

	public static DivisionPorCeroException create(String mensajeTecnico, Exception exception) {
		return new DivisionPorCeroException(new Exception(), mensajeTecnico, mensajeTecnico);
	}

	public static DivisionPorCeroException create(String mensajeTecnico, Exception exception, String mensajeUsuario) {
		return new DivisionPorCeroException(new Exception(), mensajeTecnico, mensajeUsuario);
	}

	public final Exception getExceptionRaiz() {
		return exceptionRaiz;
	}

	public final void setExceptionRaiz(Exception exceptionRaiz) {
		this.exceptionRaiz = exceptionRaiz;
	}

	public final String getMensajeTecnico() {
		return mensajeTecnico;
	}

	public final void setMensajeTecnico(String mensajeTecnico) {
		this.mensajeTecnico = mensajeTecnico;
	}

	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public final void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}
}
