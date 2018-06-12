package mastermind;


/**
 * Almacena el objeto del usuario jugador que va a jugar
 * 
 * @author Jaime Abad
 * @version 1.0
 * @since 1.0
 *
 */
//@version: es la versión actual del proyecto
//@since: en qué versión se incluyó la clase, método, etc
public class Usuario extends Jugador {
	

	/**
	 * Almacena el color, un objeto tablero, la dificultad y una lista
	 * que será de los colores de los cuales está compuesta la combinación
	 */
	
	private int color;
	
	
	/**
	 * Construye un nuevo objeto Jugador que contiene los datos de éste según el modo en el que esté
	 * @param dificultad La dificultad en la que está en ese momento
	 */
	Usuario(Dificultad dificultad) {
		super(dificultad);
	}
	
	/**
	 * Rellena una combinación: se pide el color al usuario y se añade, tambien le pasamos el color a la lista
	 * y una vez creada la combinacion completamente se la pasamos al tablero
	 */
	/*la diferencia entre rellenarCombinacion y crearCombinacionSecreta es que el rellenar lo que haCe es crear una combinacion 
	 * y pasarla al metodo añadir combinacion del tablero, que la introducira en el arrayList;
	 * Mientras que en el crear, solo la creara y la devolvera ya que nos hara falta para pasarsela al tablero */
	protected Combinacion rellenarCombinacion() {
		
		Combinacion combinacion = new Combinacion(dificultad);
		System.out.println("RELLENA LA COMBINACIÓN INTENTO.");
		System.out.println("0. Negro \n1. Blanco \n2. Rojo \n3. Verde \n4. Amarillo \n5. Azul \n6. Morado \n7. Celeste\n");
		
		for(int i = 0;i<dificultad.getCasilla();i++) {
			System.out.println("Introduce un color para la posicion" + i + ":");
			color = Teclado.leerEntero();
			//vamos a rellenar la lista, la cual sera como una combinacion pero posicion a posicion
			//no como el objeto combinacion en conjunto
			//es decir hay una lista para el conjunto de la combinacion y otra que guarda cada color por separado
			listaColoresCombinacion.add(i, color);
			combinacion.añadirFicha(color,i);
		}

		
		return combinacion;
		
	}
	
	
	/**
	 * Rellena la combinación secreta que tendrá que adivinar la maquina:
	 *  se pide el color y se añade, tambien le pasamos el color al mapa jnto con la posicion en la que está
	 * y una vez creada la combinacion completamente se la pasamos al tablero
	 * @return	combinacion
	 */
	//devuelve la combinacion para podeer metersela al tablero, la de arriba no porque el mismo metodo la pasa al tablero
	protected Combinacion crearCombinacionSecreta() {
		
		Combinacion combinacionSecreta = new Combinacion(dificultad);
		System.out.println("RELLENA LA COMBINACIÓN SECRETA PARA LA MÁQUINA.");
		System.out.println("0. Negro \n1. Blanco \n2. Rojo \n3. Verde \n4. Amarillo \n5. Azul \n6. Morado \n7. Celeste\n");
		
		for(int i = 0;i<dificultad.getCasilla();i++) {
			//controlar repeticion en modo facil y medio
			System.out.println("Posicion: " + i + " Color :");
			color = Teclado.leerEntero();
			//añadimos el color al mapa para poder recorrer el mapa con el contains en el obtenerResultado
			mapaComparacion.put(i, color);
			//añadimos el color a la combinacion
			combinacionSecreta.añadirFicha(color,i);
		}
		
		return combinacionSecreta;
	}
	
	
	
	/**
	 * Rellena una combinacion que será el resultado de la secreta y la de la maquina: 
	 * pedimos que cree una combinacion del tamaño de la otra con  los colores correspondientes  al resultado,
	 * una vez creada se pasa al tablero de la maquina
	 * @param combinacion La combinacion que es intento
	 */
	//la combinacion que recibe es el intento de la maquina
	protected Combinacion obtenerResultado(Combinacion combinacion) {
		//muestra la combinacion de la maquina
		System.out.printf("Combinacion intento: ");combinacion.dibujar();
		System.out.println();
//		boolean mastil = false;
		Combinacion combinacionResultado = new Combinacion(dificultad);
		/*negro: color y posicion correctos
		 * blanco: color correcto
		 * rojo: ni color ni posicion*/
		System.out.println("RELLENA LA COMBINACIÓN DE ACIERTOS PARA LA MÁQUINA:\n "
				+ "	0 - Negro: Posicion y color correctos\n"
				+ "	1 - Blanco: Solo color correcto\n"
				+ "	2 - Rojo: Ni color ni posicion correctos");
		
		for(int i = 0;i<dificultad.getCasilla();i++) {
			do {
				System.out.println("Posicion: " + i + " Color: ");
				color = Teclado.leerEntero();
			}while(color>=3);
			combinacionResultado.añadirFicha(color,i);
		}
		return combinacionResultado;
		
		
	}
	
	/*hacer un metodo que devuelva un boolean que sea comprobar ganador, recibe la combinacion secreta y la del intento y si son iguales
	 * devolvera un true, y finalizaremos el programa en la partida*/
	
	
//	public static void main(String[] args) {
//
//		
//	/*	PRUEBA DE UNA JUGADA: VALE
//	 * Dificultad d = Dificultad.INDIVIDUAL;
//		Usuario usuario = new Usuario(d);
//		Combinacion intento = new Combinacion(d);
//		Combinacion resultado = new Combinacion(d);
//		Combinacion secreta = new Combinacion(d);
//		Tablero t = new Tablero();
//		
//		secreta = usuario.crearCombinacionSecreta();
//		intento = usuario.rellenarCombinacion();
//		resultado = usuario.obtenerResultado(intento);
//		t.añadirJugada(intento, resultado);
//		t.dibujar();*/
//		
//		
//}


}
