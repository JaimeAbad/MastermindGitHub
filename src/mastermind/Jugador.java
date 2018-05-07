package mastermind;

import java.util.ArrayList;
/**
 * Que almacena la clase
 * 
 * @author Jaime Abad
 * @version 1.0
 * @since 1.0
 *
 */
//@version: es la versión actual del proyecto
//@since: en qué versión se incluyó la clase, método, etc
public class Jugador extends Usuario{

	//private boolean repeticion = false;
	private int i=0;
	private int color;
	/*esto de abajo no, si no hacerle un Tablero tablero;
	Combinacion combinacion;*/
	Tablero tablero;
	Dificultad dificultad;
	ArrayList<Integer> listaColoresCombinacion = new ArrayList<Integer>();
	
	//tambien habra que crear el hashMap para comparar la combinacion con la combinacion secreta
	
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
	
	//IMPORTANTE
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
