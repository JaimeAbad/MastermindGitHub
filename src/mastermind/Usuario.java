package mastermind;

import java.util.LinkedHashMap;

public abstract class Usuario {
	//Clase comun de jugador y maquina
	LinkedHashMap<Integer, Integer> mapaComparacion = new LinkedHashMap<Integer, Integer>();
	protected abstract Combinacion crearCombinacionSecreta();
	protected abstract void rellenarCombinacion();
	
}
