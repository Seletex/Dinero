package edu.uco.calculadora.transversal;

public class NumeroNegativoException extends RuntimeException {

	private static final long serialVersionUID = 4722307917014565183L;
	private Exception exceptionRaiz;
	private String mensajeTecnico;
	private String mensajeUsuario;

	private NumeroNegativoException(Exception exceptionRaiz, String mensajeTecnico, String mensajeUsuario) {
		super();
		this.exceptionRaiz = exceptionRaiz;
		this.mensajeTecnico = mensajeTecnico;
		this.mensajeUsuario = mensajeUsuario;
	}

	public static NumeroNegativoException create(String mensaje) {
		return new NumeroNegativoException(new Exception(), mensaje, mensaje);
	}

	public static NumeroNegativoException create(String mensajeTecnico, Exception exception) {
		return new NumeroNegativoException(new Exception(), mensajeTecnico, mensajeTecnico);
	}

	public static NumeroNegativoException create(String mensajeTecnico, Exception exception, String mensajeUsuario) {
		return new NumeroNegativoException(new Exception(), mensajeTecnico, mensajeUsuario);
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
	
	

//se hace en crosscutting

}
