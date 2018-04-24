package mastermind;

public class Partida {

	
	
	Dificultad dificultad;
	Jugador jugador1;
	Maquina maquina1, maquina2;
	Usuario usuario;

	Partida(Dificultad dificultad, Usuario usuario){
	
		this.dificultad = dificultad;
		this.usuario = usuario;
	
		if(dificultad == Dificultad.INDIVIDUAL && usuario == jugador1) {//hay un solo jugador
			jugador1 = new Jugador(dificultad);
		}else if(dificultad == Dificultad.INDIVIDUAL && usuario == maquina1) {// hay un solo jugador maquina
			maquina1 = new Maquina(dificultad);
		}else if(dificultad == Dificultad.EXPERTO && usuario == jugador1){//modo medio comienza jugador
			jugador1 = new Jugador(dificultad);
			maquina1 = new Maquina(dificultad);
		}else if(dificultad == Dificultad.EXPERTO && usuario == maquina1){//modo medio comienza maquina
			maquina1 = new Maquina(dificultad);
			jugador1 = new Jugador(dificultad);
		}else if(dificultad == Dificultad.AUTOMATICO && usuario == maquina1) {//modo dificil comienza maquina1
			maquina1 = new Maquina(dificultad);
			maquina2 = new Maquina(dificultad);
		}else if(dificultad == Dificultad.AUTOMATICO && usuario == maquina2) {//modo dificil comienza maquina2
			maquina2 = new Maquina(dificultad);
			maquina1 = new Maquina(dificultad);
		}
	
		
		
		
		
	}

	
	public String toString() {
		return String.format("Casillas: %d Colores: %s Intentos: %d Repeticion: %s",
				dificultad.getCasilla(), dificultad.getColores(), dificultad.getIntentos(), dificultad.isRepeticion()?"si":"no");
	}
	
	
//	public static void main(String[] args) {
////
////		Menu partida = new Menu();
//
//		
//		/*NOTA IMPORTANTE: NO HACER LOS NEW AQUI, YA QUE SE HACEN EN LA PARTIDA
//		 * INICIALIZAR A NULL */
//		
//		
//		
//		/*Ejemplo correcto*/
//		/*Dificultad d = Dificultad.INDIVIDUAL;
//		Jugador j1 = null;
//		Partida partida = new Partida(d, j1);
//		System.out.println(partida.toString());*/
//		
//		
//		
//		/*para el modo dificil: 
//		 * Dificultad d = Dificultad.AUTOMATICO;
//		 * Maquina maquina1 = new Maquina();
//		 * Maquina maquina2 = new Maquina();
//		 * Partida partida = new Partida(d, el objeto que se pase aqui será el que inicie la jugada);*/
//	}

}
