package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import mastermind.Combinacion;

import mastermind.Dificultad;

class JUnitTest {
	
	
	@DisplayName("Pruebas para el método obtenerResultado que devuelve la combinacion resultado")
	@Test
	void obtenerResultado() {
		Dificultad d = Dificultad.INDIVIDUAL;
		Combinacion intento = new Combinacion(d);
		intento.añadirFicha(1, 0);
		intento.añadirFicha(2, 1);
		intento.añadirFicha(3, 2);
		intento.añadirFicha(4, 3);
		
		assertEquals("poner combinacion", "metodo");/*el primer parametro sera una combinacion creada por mi,
		 sera el resultado y la que devuelva el metodo debe coincidir con esa*/
		//assertNotEquals(6, leerNumeroMayorDos());//El test irá bien si no se introduce
		System.out.println("Seguramente tendre que hacer otro metodo en maquina que devuelva el resultado, pero en el que le pase"
				+ "la combinacion intento y la secreta y devuelva el resultado.");
	}

}
