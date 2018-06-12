package mastermind;

import java.util.ArrayList;
import java.util.LinkedHashMap;

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
public abstract class Jugador {
	
	/**
	 * Almacena un mapa para comparar los colores, ademas de 2 metodos comunes a jugador y maquina(crearCombinacionSecreta y rellenarCombinacion)
	 */
	//Clase comun de jugador y maquina
	
//	Combinacion combinacionSecreta;
//	Combinacion combinacionIntento;
	Dificultad dificultad;
	protected Tablero tablero;
	LinkedHashMap<Integer, Integer> mapaComparacion = new LinkedHashMap<Integer, Integer>();
	ArrayList<Integer> listaColoresCombinacion = new ArrayList<Integer>();
	
	
	
	Jugador(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	
	protected abstract Combinacion crearCombinacionSecreta();
	protected abstract Combinacion rellenarCombinacion();

	//si las combinaciones son iguales devolvera true
	protected boolean comprobarGanador(Combinacion combinacionIntento, Combinacion combinacionSecreta) {
		boolean igual = false;

		if (combinacionSecreta.equals(combinacionIntento)) {
			igual = true;
		}
		
		return igual;
	}
	
	public Tablero getTablero() {
		return tablero;
	}
}
