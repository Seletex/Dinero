package edu.uco.calculadora.aplication;

import edu.uco.calculadora.business.Calculadora;

public class PruebaCalculadora {
	
	public static void Main(String[] args) {
		Calculadora miCalculadora = new Calculadora();
		
		try {
			System.out.println(miCalculadora.dividir(1, 0));
		}catch(ArithmeticException exception) {
			throw exception;
		}
	}

}
