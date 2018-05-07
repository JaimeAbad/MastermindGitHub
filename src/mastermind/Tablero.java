package mastermind;

import java.util.ArrayList;

/**
 * Que almacena la clase
 * 
 * @author Jaime Abad
 * @version 1.0
 * @since 1.0
 *
 */
//@version: es la versión actual del proyecto
//@since: en qué versión se incluyó la clase, método, etc
public class Tablero implements Dibujable{
	
	/**
	 * Almacena la dificultad, 2 instancias de Combinacion y 2 arrayList, uno para la lista de intentos y otro de la lista de resultados
	 */
	
	Dificultad dificultad;
	Combinacion combinacion, combinacionSecreta;
	ArrayList<Combinacion> listaResultados = new ArrayList<Combinacion>();
	ArrayList<Combinacion> listaIntentos = new ArrayList<Combinacion>();
	
	
	/**
	 * Almacena la combinacion secreta
	 * @param combinacionSecreta La combinacion secreta que crea el usuari que no juega o el rival
	 */
	Tablero(Combinacion combinacionSecreta){
		this.combinacionSecreta = combinacionSecreta;
	}
	
	/**
	 * Devuelve la combinacion intento
	 * @param combinacion se le pasa una combinacion intento
	 * @return 	La combinacion
	 * @see 	Combinacion
	 */
	public Combinacion añadirCombinacion(Combinacion combinacion) {
		listaIntentos.add(combinacion);
		return combinacion;
	}
	/**
	 * Devuelve la combinacion resultado
	 * @param comb se le pasa una combinacion resultado
	 * @return 	La combinacion
	 * @see 	Combinacion
	 */
	public Combinacion añadirRespuesta(Combinacion comb) {
		listaResultados.add(combinacion);
		return combinacion;
	}
	

	
//	public String toString() {
//		return String.format("%s%s", listaIntentos,listaResultados);
//	}
	/**
	 * Dibuja las listas que contiene las combinaciones de intentos y resultado
	 * @see 	void
	 */

	@Override
	public void dibujar() {
		System.out.printf("%s | %s\n", listaIntentos, listaResultados);
	}

	
}
