package mastermind;


public class Jugador extends Usuario{

	//private boolean repeticion = false;
	private int i=0;
	private int color;
	/*esto de abajo no, si no hacerle un Tablero tablero;
	Combinacion combinacion;*/
	Tablero tablero;
	Dificultad dificultad;
	
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
	/*la diferencia entre rellenarCombinacion y crearCombinacionSecreta es que el rellenar lo que hae es crear una combinacion 
	 * y pasarla al metodo añadir combinacion del tablero, que la introducira en el arrayList;
	 * Mientras que en el crear, solo la creara y la devolvera ya que nos hara falta para pasarsela al tablero
	 * 
	 * 
	 * APARTE: mirar donde hacer el mapa */
	protected void rellenarCombinacion() {
		
		Combinacion combinacion = new Combinacion(dificultad);
		do {
			System.out.println("Introduce un color para la posicion" + i + ":");
			color = Teclado.leerEntero();
			combinacion.añadirFicha(color);
			i++;
		}while(i<dificultad.getCasilla());
		
		tablero.añadirCombinacion(combinacion);
		
	}
	
	protected Combinacion crearCombinacionSecreta(int color) {
		
		Combinacion combinacion = new Combinacion(dificultad);
		do {
			System.out.println("Posicion: " + i + " Color :");
			color = Teclado.leerEntero();
			combinacion.añadirFicha(color);
			i++;
		}while(i<dificultad.getCasilla());
		
		return combinacion;
	}
	
	protected Combinacion devolverResultado(Combinacion combinacion) {
		/*negro: color y posicion correctos
		 * blanco: color correcto
		 * rojo: ni color ni posicion*/
		return combinacion;
	}
	
//	public static void main(String[] args) {
////
////		
////		// aqui vamos a sacar quien juega del menu y en el tablero segun quien sea el jugador se obtendra un tablero u otro
////		//o dos si es el modo dificil
//		
//		Jugador j = new Jugador(Dificultad.INDIVIDUAL);
//		//Tablero tablero = new Tablero();
//		j.rellenarCombinacion();
//		//System.out.println(tablero.listaIntentos);

	
	
	
	/*El main sera mas o menos asi
	 * Dificultad dificultad;
	 * Combinacion combinacion;
	 * Jugador j = new Jugador(dificultad);
	 * Maquina m = new Maquina(dificultad);
	 * 
	 * combinacion = m.crearCombinacionSecreta();
	 * Tablero t = new Tablero(combinacion);
	 * 
	 * Con esto ya tendriamos el tablero y la combinacion secreta
	 * 
	 * j.rellenarCombinacion();
	 * primer intento
	 * 
	 * ahora faltaria comparar las combinaciones
	 * 
	 * Seguramente haya que hacer un do while al j.rellenarCombinacion() para que la pida mientras no sean iguales

	 * */
//	}

	


	
	

}
