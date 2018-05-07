package mastermind;

import java.util.ArrayList;
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
public class Jugador extends Usuario{
	/**
	 * Almacena un entero que utilizaremos para modificarlo, el color, un objeto tablero, la dificultad y una lista
	 * que será de los colores de los cuales está compuesta la combinación
	 */
	
	private int i=0;
	private int color;
	Tablero tablero;
	Dificultad dificultad;
	ArrayList<Integer> listaColoresCombinacion = new ArrayList<Integer>();
	
	/**
	 * Construye un nuevo objeto Jugador que contiene los datos de éste según el modo en el que esté
	 * @param dificultad La dificultad en la que está en ese momento
	 */
	
	Jugador(Dificultad dificultad){
		this.dificultad=dificultad;
		if(dificultad == Dificultad.INDIVIDUAL) {
			dificultad.getCasilla();
			dificultad.getIntentos();
			dificultad.getColores();
			dificultad.isRepeticion();
		}else if(dificultad == Dificultad.EXPERTO) {
			dificultad.getCasilla();
			dificultad.getIntentos();
			dificultad.getColores();
			dificultad.isRepeticion();
		}else {
			
		}
	}
	
	/**
	 * Rellena una combinación: se pide el color al usuario y se añade, tambien le pasamos el color a la lista
	 * y una vez creada la combinacion completamente se la pasamos al tablero
	 */
	/*la diferencia entre rellenarCombinacion y crearCombinacionSecreta es que el rellenar lo que haCe es crear una combinacion 
	 * y pasarla al metodo añadir combinacion del tablero, que la introducira en el arrayList;
	 * Mientras que en el crear, solo la creara y la devolvera ya que nos hara falta para pasarsela al tablero */
	protected void rellenarCombinacion() {
		
		Combinacion combinacion = new Combinacion(dificultad);
		
		System.out.println("0. Negro \n1. Blanco \n2. Rojo \n3. Verde \n4. Amarillo \n5. Azul \n6. Morado \n7. Celeste\n");
		do {
			System.out.println("Introduce un color para la posicion" + i + ":");
			color = Teclado.leerEntero();
			//vamos a rellenar la lista, la cual sera como una combinacion pero posicion a posicion
			//no como el objeto combinacion en conjunto
			//es decir hay una lista para el conjunto de la combinacion y otra que guarda cada color por separado
			listaColoresCombinacion.add(i, color);
			combinacion.añadirFicha(color);
			i++;
		}while(i<dificultad.getCasilla());
		
		tablero.añadirCombinacion(combinacion);
		
	}
	
	
	/**
	 * Rellena la combinación secreta que tendrá que adivinar la maquina:
	 *  se pide el color y se añade, tambien le pasamos el color al mapa jnto con la posicion en la que está
	 * y una vez creada la combinacion completamente se la pasamos al tablero
	 * @return	combinacion
	 */
	//devuelve la combinacion para podeer metersela al tablero, la de arriba no porque el mismo metodo la pasa al tablero
	protected Combinacion crearCombinacionSecreta() {
		
		Combinacion combinacion = new Combinacion(dificultad);
		do {
			//controlar repeticion en modo facil y medio
			System.out.println("Posicion: " + i + " Color :");
			color = Teclado.leerEntero();
			//añadimos el color al mapa para poder recorrer el mapa con el contains en el obtenerResultado
			mapaComparacion.put(i, color);
			//añadimos el color a la combinacion
			combinacion.añadirFicha(color);
			i++;
		}while(i<dificultad.getCasilla());
		
		return combinacion;
	}
	
	/**
	 * Rellena una combinacion que será el resultado de la secreta y la de la maquina: 
	 * pedimos que cree una combinacion del tamaño de la otra con  los colores correspondientes  al resultado,
	 * una vez creada se pasa al tablero de la maquina
	 * @param combinacion La combinacion que es intento
	 */
	//la combinacion que recibe es el intento de la maquina
	protected void obtenerResultado(Combinacion combinacion/*LinkedHashMap<Integer, Integer> mapaComparacion*/) {
		/*negro: color y posicion correctos
		 * blanco: color correcto
		 * rojo: ni color ni posicion*/
		System.out.println("Rellena la combinacion de aciertos para la maquina:\n "
				+ "	0 - Negro: Posicion y color correctos\n"
				+ "	1 - Blanco: Solo color correcto\n"
				+ "	2 - Rojo: Ni color ni posicion correctos");
		
		do {
			System.out.println("Posicion: " + i + " Color :");
			color = Teclado.leerEntero();
			if(color>=3) {
				System.out.println("Posicion: " + i + " Color :");
				color = Teclado.leerEntero();
			}else{
				combinacion.añadirFicha(color);
				i++;
			}
			
		}while(i<dificultad.getCasilla());
		tablero.añadirRespuesta(combinacion);
	}
	

}
