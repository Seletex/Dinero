package edu.uco.calculadora.business;

import edu.uco.calculadora.transversal.NumeroNegativoException;

public class Calculadora {
	
	public int sumar(int numeroUno, int numeroDos) {
		return numeroUno+numeroDos;
	}
	
	public int restar(int numeroUno, int numeroDos) {
		return numeroUno-numeroDos;
	}
	public int multiplicar(int numeroUno, int numeroDos) {
		return numeroUno*numeroDos;
	}
	public int dividir(int numeroUno, int numeroDos) {
		try{
			if(numeroUno<0) {throw NumeroNegativoException.
				create("No es pisible que denominador sea negativo")				;
			}
			return numeroUno/numeroDos;
		}catch(ArithmeticException exception) {
			System.out.println("Hubo una division por cero");
			throw exception;
		}catch(NumeroNegativoException exception) {
			System.out.println(exception.getMensajeTecnico());
			throw exception;
		}
	}

}
