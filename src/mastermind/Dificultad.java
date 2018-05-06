package mastermind;

public enum Dificultad {

	INDIVIDUAL(4,8, false, 10), EXPERTO(5,8,false,15), AUTOMATICO(8,10,true,1000);
	
	private int casilla;
	private int colores;
	private boolean repeticion;
	private int intentos;
	
	Dificultad(int casilla, int colores, boolean repeticion, int intentos){
		this.casilla = casilla;
		this.colores = colores;
		this.repeticion = repeticion;
		this.intentos = intentos;
		
	}

	public int getCasilla() {
		return casilla;
	}
	public int getColores() {
		return colores;
	}
	public boolean isRepeticion() {
		return repeticion;
	}
	public int getIntentos() {
		return intentos;
	}

	
}
