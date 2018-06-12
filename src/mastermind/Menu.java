package mastermind;

import mastermind.Teclado.Rango;

/**
 *	Almacena el menu del juego
 * 
 * @author Jaime Abad
 * @version 1.0
 * @since 1.0
 *
 */
//@version: es la versión actual del proyecto
//@since: en qué versión se incluyó la clase, método, etc
public class Menu {

	/**
	 * modo: Almacena un número de 0 a 4, que indicará la dificultad de la partida
	 * opcion: Almacena un número entre 1 y 2(ambos incluidos) que indicará el usuario que juega
	 */
	private int modo;
	private int opcion;
	Dificultad dificultad;
	
	/**
	 * Construye un nuevo objeto Menu del que se obtienen el modo y la opcion
	 */
	Menu(){
		
	}
	/**
	 * Devuelve el número del modo 
	 * @return 	El número especificado en modo numero
	 * @see int
	 * 
	 */
	public int getModo() {
		return modo;
	}
	/**
	 * Cambia el número del modo 
	 * @param modo La dificultad de la partida
	 * @see 	modo
	 */
	public void setModo(int modo) {
		this.modo = modo;
	}

	/**
	 * Devuelve el número de la opcion
	 * @return 	El número especificado en modo numero
	 *@see int
	 */

	public int getOpcion() {
		return opcion;
	}

	/**
	 * Cambia el número de la opcion 
	 * @param opcion El usuario que juega o comienza
	 * @see 	opcion
	 */

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}


	
	public Partida configurarPartida() {
		Partida partida = null;
		Jugador jugador1, jugador2;

		System.out.println("  __  __           _            __  __ _           _ \r\n" + 
					" |  \\/  |         | |          |  \\/  (_)         | |\r\n" + 
					" | \\  / | __ _ ___| |_ ___ _ __| \\  / |_ _ __   __| |\r\n" + 
					" | |\\/| |/ _` / __| __/ _ | '__| |\\/| | | '_ \\ / _` |\r\n" + 
					" | |  | | (_| \\__ | ||  __| |  | |  | | | | | | (_| |\r\n" + 
					" |_|  |_|\\__,_|___/\\__\\___|_|  |_|  |_|_|_| |_|\\__,_|");
		
		System.out.println();
		System.out.println(" 1. INDIVIDUAL\n 2. EXPERTO\n 3. AUTOMATICO" );

		
		
		switch(Teclado.rango(1, 3, Rango.AMBOS_INCLUIDOS)) {
		case 1:
			dificultad = Dificultad.INDIVIDUAL;
			jugador1 = new Usuario(dificultad);
			jugador2 = new Maquina(dificultad);
			System.out.println("Modo Individual. \n¿Quién quieres que juegue?\n 1. Usuario\n 2. Máquina");
			opcion = Teclado.rango(1, 2, Rango.AMBOS_INCLUIDOS);
			
			if(opcion == 1) {
				partida = new Partida(dificultad, jugador1, jugador2);
			}else {
				partida = new Partida(dificultad, jugador2, jugador1);
			}
			break;
		case 2:
			dificultad = Dificultad.EXPERTO;
			jugador1 = new Usuario(dificultad);
			jugador2 = new Maquina(dificultad);
			System.out.println("Modo Medio.");
			
			partida = new Partida(dificultad, jugador1,jugador2);
			break;
		case 3:
			dificultad = Dificultad.AUTOMATICO;
			jugador1 = new Maquina(dificultad);
			jugador2 = new Maquina(dificultad);
			System.out.println("Modo Dificil.");
			
			partida = new Partida(dificultad, jugador1,jugador2);
			break;
			
		}
		
		return partida;
	}
	

}
