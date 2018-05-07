package mastermind;

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
public abstract class Usuario {
	//Clase comun de jugador y maquina
	LinkedHashMap<Integer, Integer> mapaComparacion = new LinkedHashMap<Integer, Integer>();
	protected abstract Combinacion crearCombinacionSecreta();
	protected abstract void rellenarCombinacion();
	
}
