package mastermind;

public class Demo {

	public static void main(String[] args) {

		/*Prueba de jugador: CORRECTA
		 * Dificultad dificultad  = Dificultad.INDIVIDUAL;
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(dificultad);
		
		Combinacion intento = new Combinacion(dificultad);
		Combinacion resultado = new Combinacion(dificultad);
		
		intento = jugador.rellenarCombinacion();
		resultado = jugador.obtenerResultado(intento);
		tablero.añadirJugada(intento, resultado);
		tablero.dibujar();*/
		

		/*PRUEBA rellenar de MAQUINA : funciona
		 * Dificultad dificultad  = Dificultad.AUTOMATICO;
		Combinacion intento = new Combinacion(dificultad);
		Maquina m  = new Maquina(dificultad);
		intento = m.IAConcurso();
		intento.dibujar();*/
		
		
		/*ESTA PRUEBA DEBERIA IR EN LA PARTIDA, CON UN BUCLE QUE DEPENDA DEL METODO COMPROBAR GANADOR DEL BOOLEAN
		 * PRUEBA DE EL JUGADOR Y SUS METODOS: FUNCIONA
		Dificultad dificultad  = Dificultad.INDIVIDUAL;
		Jugador j = new Jugador(dificultad);
		Combinacion intento = new Combinacion(dificultad);
		Combinacion respuesta = new Combinacion(dificultad);
		Tablero tablero = new Tablero();
		boolean igual;
		j.crearCombinacionSecreta();
		intento = j.rellenarCombinacion();
		respuesta = j.obtenerResultado(intento);
		tablero.añadirJugada(intento, respuesta);
		tablero.dibujar();*/
		
		/*PRUEBA DE LA MAQUINA Y SUS METODOS: NO FUNCIONA AUN
		 * 
		Dificultad dificultad = Dificultad.AUTOMATICO;
		Maquina maquina = new Maquina(dificultad);
		Combinacion intento = new Combinacion(dificultad);
		Combinacion respuesta = new Combinacion(dificultad);
		Tablero tablero = new Tablero();
		
		intento = maquina.intentona();
		System.out.println(intento);
		respuesta = maquina.obtenerResultado(intento);
		
		tablero.añadirJugada(intento, respuesta);
		
		tablero.dibujar();*/
		
		
		
		
		
		
		/*	OFICIALMENTE ESTE ES EL MAIN, PONERLE UN BUCLE PARA QUE CUANDO ACABE UNA PARTIDA PIDA SI HACER O NO OTRA*/
//		boolean respuesta;
//		do{
//			Menu m = new Menu();
//			Partida p = m.configurarPartida();
//			p.iniciarPartida();
//			System.out.printf("\n\n");
			
			
//			respuesta = Teclado.leerBoolean("¿Desea jugar otra partida?", "Sí", "No");
//				System.out.printf("\n\n");
//		}while (respuesta);
		
		
		
		
		
		//ESTO ES UNA PRUEBA
//		Dificultad dificultad =Dificultad.INDIVIDUAL;
//		Combinacion combinacionIntento = new Combinacion(dificultad);
//		Combinacion combinacionSecreta= new Combinacion(dificultad);
//		int intento = 7;
//		Usuario jugador1 = new Usuario(dificultad);
//		boolean ganador = false;
//		
//		for (int i = 0; i < dificultad.getCasilla(); i++) {
//			combinacionIntento.añadirFicha(1, i);
//		}
//		for (int i = 0; i < dificultad.getCasilla(); i++) {
//			combinacionSecreta.añadirFicha(2, i);
//		}
//		do {			
//			
//			
//			intento++;
//			if(jugador1.comprobarGanador(combinacionIntento, combinacionSecreta)) {
//				System.out.println("¡¡¡¡¡¡¡¡¡¡¡HAS GANADOOO!!!!!!!!!!!");
//				ganador = true;
//			}else {
//				System.out.println("Estás más cerca, sigue intentándolo !!");
//				
//			}
//			
//			if(intento == dificultad.getIntentos() && !ganador) {
//				System.out.println("LOSER ..... ");
//			}
//		
//		}while(intento<dificultad.getIntentos() && !ganador);
		
		Dificultad d = Dificultad.INDIVIDUAL;
		Usuario u = new Usuario(d);
		Maquina m = new Maquina(d);
		Combinacion secreta = new Combinacion(d);
		Combinacion intento= new Combinacion(d);
		Combinacion resultado= new Combinacion(d);
		Tablero t = new Tablero();
		
		secreta = m.crearCombinacionSecreta();
		secreta.dibujar();
		intento = u.rellenarCombinacion();
		
		resultado = m.obtenerResultado(intento);
		t.añadirJugada(intento, resultado);
		t.dibujar();
	}
}
