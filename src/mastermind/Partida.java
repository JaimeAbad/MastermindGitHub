package mastermind;


/**
 * Almacena la partida
 * 
 * @author Jaime Abad
 * @version 1.0
 * @since 1.0
 *
 */
//@version: es la versión actual del proyecto
//@since: en qué versión se incluyó la clase, método, etc
public class Partida {

	/**
	 * Almacena la dificultad e instancias de jugador, maquina y usuario
	 */
	
	Dificultad dificultad;
	private Jugador jugador1;
	private Jugador jugador2;

	/**
	 * Construye un nuevo objeto Numero a partir del entero especificado
	 * @param dificultad  La dificultad a partir del cual se crea el objeto Partida
	 * @param usuario El usuario que va a jugar o el que va a comenzar jugando
	 */ 
	Partida(Dificultad dificultad, Jugador jugador1, Jugador jugador2){
	
		this.dificultad = dificultad;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		
	}
	

	/**
	 * Devuelve la cadena formada por los datos de la partida
	 * @return 	Las condiciones de la partida en modo cadena
	 * @see 	String
	 */
	public String toString() {
		return String.format("Casillas: %d Colores: %s Intentos: %d Repeticion: %s",
				dificultad.getCasilla(), dificultad.getColores(), dificultad.getIntentos(), dificultad.isRepeticion()?"si":"no");
	}
	
	
	public void iniciarPartida() {
		int intento= 0;
		boolean ganador = false;
		Combinacion combinacion = new Combinacion(dificultad);
		Combinacion combinacionResultado = new Combinacion(dificultad);
		Combinacion combinacionIntento = new Combinacion(dificultad);
		Combinacion combinacionRes = new Combinacion(dificultad);//las dos ultimas para la maquina o la maquina2
		Combinacion combinacionSecreta = new Combinacion(dificultad);
		Combinacion combinacionSecretaAux = new Combinacion(dificultad);
		
		//MODO FÁCIL COMPLETO
		if(dificultad == Dificultad.INDIVIDUAL) {
			if(jugador1 instanceof Usuario) {
				combinacionSecreta = ((Maquina)jugador2).crearCombinacionSecreta();
				System.out.println("La máquina ha creado la combinacion secreta");
				
				do {
					System.out.println("Rellena la combinacion del intento: ");
					combinacionIntento = ((Usuario)jugador1).rellenarCombinacion();
					intento++;
					combinacionResultado = ((Maquina)jugador2).obtenerResultado(combinacionIntento);
					System.out.println("La maquina ha devuelto la respuesta");
					jugador1.getTablero().añadirJugada(combinacionIntento, combinacionResultado);
					jugador1.getTablero().dibujar();
					
					
					if(jugador1.comprobarGanador(combinacionIntento, combinacionSecreta)) {
						System.out.println("¡¡¡¡¡¡¡¡¡¡¡HAS GANADOOO!!!!!!!!!!!");
						ganador = true;
					}else if(intento == dificultad.getIntentos() && !ganador) {
						System.out.println("LOSER ..... ");
					}else {
						System.out.println("Estás más cerca, sigue intentándolo !!");
						
					}
					
					
				
				}while(intento<dificultad.getIntentos() && !ganador);
				
				
			}	
			
			//MODO MEDIO
		}else if(dificultad == Dificultad.EXPERTO) {
			
			combinacionSecreta = ((Maquina)jugador2).crearCombinacionSecreta();
			System.out.println("La máquina ha creado la combinacion secreta para el usuario");
			combinacionSecretaAux = ((Usuario)jugador1).crearCombinacionSecreta();
			System.out.println("El usuario ha creado la combinacion secreta para la maquina");
			
			do {
				System.out.println("El usuario rellenará la combinacion del intento: ");
				combinacionIntento = ((Usuario)jugador1).rellenarCombinacion();
				combinacionResultado = ((Maquina)jugador2).obtenerResultado(combinacionIntento);
				System.out.println("La maquina ha devuelto la respuesta");
				jugador1.getTablero().añadirJugada(combinacionIntento, combinacionResultado);
				jugador1.getTablero().dibujar();
				
				System.out.println("La máqunia rellenará la combinacion del intento");
				combinacion = ((Maquina)jugador2).crearCombinacionPrueba();
				combinacionRes = ((Usuario)jugador1).obtenerResultado(combinacion);
				System.out.println("El usuario ha devuelto la respuesta");
				jugador2.getTablero().añadirJugada(combinacion, combinacionRes);
				jugador2.getTablero().dibujar();
				
				
				
				intento++;
				if(jugador1.comprobarGanador(combinacionIntento, combinacionSecreta) && jugador2.comprobarGanador(combinacion, combinacionSecretaAux)) {
					System.out.println("¡¡¡¡¡¡¡¡¡¡¡TENEMOS EMPATE!!!!!!!!!!!");
					ganador = true;
				}else if(jugador1.comprobarGanador(combinacionIntento, combinacionSecreta) && !jugador2.comprobarGanador(combinacion, combinacionSecretaAux)){
					System.out.println("Ha ganado el jugador 1, EL USUARIO, ENHORABUENA!!!!!!");
					ganador = true;
				}else if(!jugador1.comprobarGanador(combinacionIntento, combinacionSecreta) && jugador2.comprobarGanador(combinacion, combinacionSecretaAux)) {
					System.out.println("Ha ganado el jugador 2, LA MÁQUINA, lo sentimos.....");
					ganador = true;
				}else if(intento == dificultad.getIntentos() && !ganador) {
					System.out.println("LOSER ..... ");
				}else {
					System.out.println("Estáis más cerca, seguid intentándolo !!");
					
				}
				
				
			
			}while(intento<dificultad.getIntentos() && !ganador);


			//MODO DIFICIL
		}else if(dificultad == Dificultad.AUTOMATICO) {
			combinacionSecreta = ((Maquina)jugador2).crearCombinacionSecreta();
			System.out.println("La máquina2 ha creado la combinacion secreta para la maquina1");
			combinacionSecretaAux = ((Maquina)jugador1).crearCombinacionSecreta();
			System.out.println("La maquina1 ha creado la combinacion secreta para la maquina2");
			
			do {
				System.out.println("La máquina 1 rellenará la combinacion del intento: ");
				combinacionIntento = ((Maquina)jugador1).rellenarCombinacion();
				combinacionResultado = ((Maquina)jugador2).obtenerResultado(combinacionIntento);
				System.out.println("La maquina2 ha devuelto la respuesta");
				jugador1.getTablero().añadirJugada(combinacionIntento, combinacionResultado);
				jugador1.getTablero().dibujar();
				
				System.out.println("La máquina2 rellenará la combinacion del intento");
				combinacion = ((Maquina)jugador2).crearCombinacionPrueba();
				combinacionRes = ((Maquina)jugador1).obtenerResultado(combinacion);
				System.out.println("La máquina1 ha devuelto la respuesta");
				jugador2.getTablero().añadirJugada(combinacion, combinacionRes);
				jugador2.getTablero().dibujar();
				
				
				
				intento++;
				if(jugador1.comprobarGanador(combinacionIntento, combinacionSecreta) && jugador2.comprobarGanador(combinacion, combinacionSecretaAux)) {
					System.out.println("¡¡¡¡¡¡¡¡¡¡¡TENEMOS EMPATE!!!!!!!!!!!");
					ganador = true;
				}else if(jugador1.comprobarGanador(combinacionIntento, combinacionSecreta) && !jugador2.comprobarGanador(combinacion, combinacionSecretaAux)){
					System.out.println("Ha ganado el jugador 1, LA MÁQUINA1, ENHORABUENA!!!!!!");
					ganador = true;
				}else if(!jugador1.comprobarGanador(combinacionIntento, combinacionSecreta) && jugador2.comprobarGanador(combinacion, combinacionSecretaAux)) {
					System.out.println("Ha ganado el jugador 2, LA MÁQUINA2, ENHORABUENA!!!!!!");
					ganador = true;
				}else if(intento == dificultad.getIntentos() && !ganador) {
					System.out.println("LOSER ..... ");
				}else {
					System.out.println("Estáis más cerca, seguid intentándolo !!");
					
				}
			
			}while(intento<dificultad.getIntentos() && !ganador);
			
		}
		
	}


}
