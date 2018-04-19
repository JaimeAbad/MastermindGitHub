package mastermind;

public abstract class Usuario {
	//Clase comun de jugador y maquina

	protected abstract Combinacion crearCombinacionSecreta(int color);
	protected abstract void rellenarCombinacion();
	protected abstract Combinacion devolverResultado(Combinacion combinacion);
	
}
