package mastermind;

public class Pruebas {

	Dificultad dificultad;
	
	Pruebas(Dificultad dificultad){
		this.dificultad = dificultad;
	}
	public String toString() {
		return String.format("%d %d %d", dificultad.getCasilla(), dificultad.getColores(), dificultad.getIntentos());
	}
	public static void main(String[] args) {

//		String[] pruebaCombinacion = new String[4];
//		int posicion;
//		boolean relleno = false;
////		pruebaCombinacion[0] = "ROJO";
////		pruebaCombinacion[1] = "VERDE";
////		pruebaCombinacion[2] = "AZUL";
////		pruebaCombinacion[3] = "MORADO";
//		
//		System.out.println("Introduce la posicion: ");
//		posicion = Teclado.leerEntero();
//		
//		//INVESTIGAR COMO SABER CUANDO UN ARRAY TIENE DATOS EN TODAS SUS POSICIONES
//		for(int i = 0; i<pruebaCombinacion.length;i++) {
//			if(posicion == i) {
//				pruebaCombinacion[posicion] ="  " + Constantes.AZUL;
//				//System.out.println("  " + Constantes.FONDO_AZUL); este es el que mas se parece
//			
//			}else {
//				//aqui debera ir la excepcion que vuelva a pedir el numero de la posicion
//				System.out.println("Has introducido una posicion inexacta o inexistente");
//			}
//			
//		}
		
		
		
//		Dificultad dificultad = null;
//		Combinacion combinacion[];
//		int i;
//		combinacion = new Combinacion[dificultad.INDIVIDUAL.getCasilla()];
//	
//			for(i=0;i<combinacion.length;i++) {
//				if(combinacion[i] != null) {
//					System.out.println("50mil" + combinacion);
//				}
//				
//			}
		
		
		Jugador jugador1 = new Jugador();
		
		//jugador1.rellenarCombinacion(Dificultad.INDIVIDUAL);
		
		System.out.println();
		
		
		
		
		
		
		
//		int modo;
//		//menu para pedir el nivel de dificultad q tendra el juego
//		// ejemplo para moldear la interfaz que imprima la pantalla "%-16s %-36s %s    %s"
//		
//		Menu menudazo = new Menu();
//		try {
//			menudazo.dameMenu();
//		}catch(NumeroIncorrectoException E) {
//			
//		}
//		
//		
//		
//		
//		System.out.println(" 1. INSTRUCCIONES\n 2. INDIVIDUAL\n 3. EXPERTO\n 4. AUTOMATICO");
//		modo = Teclado.leerEntero();
//		if(modo==1) {
//			System.out.println("Instrucciones MasterMind");
//		}
//		if(modo==2) {
//			Pruebas prueba1 = new Pruebas(Dificultad.INDIVIDUAL);
//			System.out.println(prueba1.toString());
//		}
//		/*Las 2 lineas de abajo son la 1º prueba para mostrar los datos guardados en la dificultad individual*/
//		Pruebas prueba1 = new Pruebas(Dificultad.INDIVIDUAL);
//		System.out.println(prueba1.toString());
	}

}
