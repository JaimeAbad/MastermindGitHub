package mastermind;

import java.util.ArrayList;
import java.util.Random;

/**
 * Almacena el objeto del usuario maquina que va a jugar
 * 
 * @author Jaime Abad
 * @version 1.0
 * @since 1.0
 *
 */
//@version: es la versión actual del proyecto
//@since: en qué versión se incluyó la clase, método, etc
public class Maquina extends Jugador{
	
	/**
	 * Almacena un objeto tablero, la dificultad y una instancia de Jugador 
	 * 
	 */
	Usuario jugador;
	/**
	 * Construye un nuevo objeto Maquina que contiene los datos de ésta según el modo en el que esté
	 * @param dificultad La dificultad en la que está en ese momento
	 */
	Maquina(Dificultad dificultad){
		super(dificultad);

	}
	
	public Combinacion rellenarCombinacion() {
		Combinacion combi = new Combinacion(dificultad);
		int random;
		Random rnd = new Random();
		
		for(int i = 0 ; i<combi.dificultad.getCasilla();i++) {
			random = rnd.nextInt(dificultad.getColores());
			combi.añadirFicha(random, i);
		}
		
		return combi;
	}
	/**
	 * Rellena la combinación secreta que tendrá que adivinar el jugador:
	 *  se crean colores aleatorios y se añaden a la combinacion, controlamos que no se repitan para los modos en los que no puede
	 *   tambien le pasamos el color al mapa jnto con la posicion en la que está
	 * y una vez creada la combinacion completamente se la pasamos al tablero
	 * @return	combinacion
	 */
	@Override
	protected Combinacion crearCombinacionSecreta() {
		int random;
		Random rnd = new Random();
		ArrayList<Integer> listaColorUtilizado= new ArrayList<Integer>();
		Combinacion combinacionSecreta = new Combinacion(dificultad);
		
		if(dificultad == Dificultad.AUTOMATICO) {
			
			for(int i=0; i<combinacionSecreta.dificultad.getCasilla(); i++) {
				random = rnd.nextInt(dificultad.getColores());
				combinacionSecreta.añadirFicha(random,i);
				mapaComparacion.put(i, random);
			}
			
			
		}else {
			for (int i = 0; i <4; i++) {
		    	int aleatorio = 0;
		    	boolean generado = false;
		    	while (!generado) {
		        	int posible = rnd.nextInt(8);
		        	if (!listaColorUtilizado.contains(posible)) {
		            	listaColorUtilizado.add(posible);
		            	combinacionSecreta.añadirFicha(posible,i);
						mapaComparacion.put(i, posible);
		            	aleatorio = posible;
		            	generado = true;
		        	}
		    	}
		    	
			}
		}
		
		return combinacionSecreta;
	}

	/**
	 * Rellena una combinación: obtiene aleatoriamente un color y crea combinaciones de estos unicamente,
	 * asi hasta que descubra todos los colores de la combinacion, a partir de ahi, creara combinaciones con estos colores,
	 * controlando que no se repitan las combinaciones
	 * una vez creada la combinacion completamente se la pasamos al tablero
	 */
//	public Combinacion crearCombinacionPrueba() {
//		
//		int random;
//		Random rnd = new Random();
//		Combinacion combinacionIntento = new Combinacion(dificultad);
//		ArrayList<Ficha> listaAuxiliar = new ArrayList<Ficha>();
//		ArrayList<Ficha> listaColoresEncontrados = new ArrayList<Ficha>();
//		ArrayList<Ficha> listaColoresDescartados= new ArrayList<Ficha>();
//		Ficha aux;
//		
////		if(listaAuxiliar.size()==0 || listaAuxiliar == null) {
////			/*1º Intento: empieza probando una combinacion de un solo color de los posibles al azar*/
////			random = rnd.nextInt(dificultad.getColores());
////			aux = new Ficha(dificultad, random);
////			listaAuxiliar.add(aux);
////			for(int j=0; j<dificultad.getCasilla(); j++) {
////				combinacion.añadirFicha(random,j);
////				listaColoresCombinacion.add(random);
////			}
////			tableroMaquina = new Tablero();
////			tableroMaquina.añadirCombinacion(combinacion);
////		/*2º intento aleatorio pero controlando repeticion, la cantidad de combinaciones que se hacen dependera de la partida*/
////		}else {
////			
////		
////		/*en el while: mientras este en este bucle probar combinaciones de colores individuales
////		 * despues del while: probar combinaciones con los colores de la lista de encontrados*/
////			while(listaColoresEncontrados.size()<dificultad.getCasilla()) {
////			/*hacer un numero aleatorio que sera el color con el que se rellena la combinacion, añadirlo a la lista auxiliar
////			 * asi despues si ese color esta en la lista no lo volveremos a comprobar*/
////			//miramos si es el primer intento
////			/*tableroMaquina.listaIntentos.size()==0 || tableroMaquina.listaIntentos == null*/
////				Combinacion res = new Combinacion(dificultad);
////				//if(tableroMaquina.listaResultados.size() == 0) {
////					//res = tableroMaquina.listaResultados.get(tableroMaquina.listaResultados.size()) ; 
////				//}else {
////					res = tableroMaquina.listaResultados.get(tableroMaquina.listaResultados.size()-1) ;/*cogemos la ultima combinacionResultado*/
////				//}
////				
////				int rojo = 0, negro = 0, blanco = 0;
////				Ficha colorBlanco = new Ficha(dificultad, 1);
////				Ficha colorRojo = new Ficha(dificultad, 2);
////				
////				/*obtenemos el numero de rojos, negros y blancos que hay en el resultado de la combinacion anterior*/
////				for(int k=0; k<res.dificultad.getCasilla();k++) {
////					if(res.combinacion[k]== colorRojo) {
////						rojo ++ ;
////					}else if(res.combinacion[k]== colorBlanco) {
////						blanco ++;
////					}else {
////						negro ++ ; 
////					}
////				}
////				
////				//si es todo rojo querra decir que no esta
////				if(rojo == dificultad.getCasilla()) {
////					//si esto se da se coge el ultimo color de la lista auxiliar y se añade a la lista de descartes
////					aux = listaAuxiliar.get(listaAuxiliar.size()-1);
////					listaColoresDescartados.add(aux);
////				//si hay dos blancos o mas, añadiremos ese color tantas vecs como blancos halla
////				}else if(blanco>=2) {
////					aux = listaAuxiliar.get(listaAuxiliar.size()-1);
////					for(int i=0;i<blanco;i++) {
////						listaColoresEncontrados.add(aux);
////					}
////				//si hay dos negros o mas, añadiremos ese color tantas veces como negros halla
////				}else if(negro>=2) {
////					aux = listaAuxiliar.get(listaAuxiliar.size()-1);
////					for(int i=0;i<negro;i++) {
////						listaColoresEncontrados.add(aux);
////					}
////				}
////				
////				
////				/*prueba otro color de los posibles al azar, si ya se ha probado coge otro color*/
////				boolean contiene = false;
////				do {
////					random = rnd.nextInt(dificultad.getColores());
////					aux = new Ficha(dificultad, random);
////					
////					if(listaAuxiliar.contains(aux)) {
////						contiene = true;
////					}else {
////						listaAuxiliar.add(aux);
////						for(int j=0; j<dificultad.getCasilla(); j++) {
////							combinacion.añadirFicha(random,j);
////							listaColoresCombinacion.add(random);
////						}
////					}
////				}while(!contiene);
////				
////				tableroMaquina.añadirCombinacion(combinacion);	
////		
////		
////		}//acaba el while
////	}//acaba el else
////		
////		/*una vez el tamaño de la lista es igual al tamaño de las casillas posibles
////		 * con esto sabemos que todos los colores de la combinacion estan en la lista, por lo tanto,
////		 * empezaremos a generar combinaciones al azar a partir de esos colores
////		 * y controlaremos que las combinaciones no se repitan*/
////		boolean repe = false;
////		boolean posVacia = false;
////		ArrayList<Integer> listaPosicionesOcupadas = new ArrayList<Integer>();
////		do {
////			//sacamos colores ordenadamente de la lista
////			for(int i=0;i<dificultad.getCasilla();i++) {
////				//comprobar que no se repita la posicion, es decir, que la posicion no esta ocupada
////				do {
////					//sacar un aleatorio entre 0 y el numero de casillas, es decir, nos dara una posicion al azar
////					random = rnd.nextInt(dificultad.getCasilla());
////					if(listaPosicionesOcupadas.contains(random)) {
////						posVacia = true;
////					}else {
////						listaPosicionesOcupadas.add(random);
////					}
////				}while(posVacia==true);
////				
////				//colocar el color que corresponda a i en la posicion que nos de el aleatorio
////				combinacion.combinacion[random] = listaColoresEncontrados.get(i);
////			}
////			//comprobamos que la combinacion no este ya en la lista, en ese caso crea otra
////			if(tableroMaquina.listaIntentos.contains(combinacion)) {
////				repe = true;
////			}else {
////				tableroMaquina.añadirCombinacion(combinacion);
////			}
////		}while(repe == true);
////		
////
////		//quitar
////		tableroMaquina.añadirCombinacion(combinacion);
//		
////		combinacion.añadirFicha(0, 0);
////		combinacion.añadirFicha(2, 1);
////		combinacion.añadirFicha(0, 2);
////		combinacion.añadirFicha(6, 3);
//		return combinacionIntento;
//
//	}
	
	private ArrayList<Integer> convertirALista(Combinacion combinacion) {
		int color = 0;
		for(int i = 0;i<combinacion.combinacion.length;i++) {
			switch (combinacion.combinacion[i].getColor()) {
			case "\u001B[30m"+'\u2b24'+ "\u001B[0m":
				color = 0 ;
				break;
			case "\u001B[37m"+'\u2b24'+"\u001B[0m":
				color = 1;
				break;
			case "\u001B[31m"+'\u2b24'+"\u001B[0m":
				color = 2;
				break;
			case "\u001B[32m"+'\u2b24'+"\u001B[0m":
				color = 3;
				break;
			case "\u001B[33m"+'\u2b24'+"\u001B[0m":
				color = 4;
				break;
			case "\u001B[34m"+'\u2b24'+"\u001B[0m":
				color = 5;
				break;
			case "\u001B[35m"+'\u2b24'+"\u001B[0m":
				color = 6;
				break;
			case "\u001B[36m"+'\u2b24'+"\u001B[0m":
				color = 7;
				break;
			case "\u001B[90m"+'\u2b24'+"\u001B[0m":
				color = 8;
				break;
			case "\u001B[91m"+'\u2b24'+"\u001B[0m":
				color = 9;
				break;
			default:
				break;
			}
			listaColoresCombinacion.add(i, color);
		}
		return listaColoresCombinacion;
	}
	
	/**
	 * Rellena una combinacion que será el resultado de la secreta y la del jugador: 
	 * pedimos que cree una combinacion del tamaño de la otra con  los colores correspondientes  al resultado,
	 * una vez creada se pasa al tablero del jugador
	 */
	
	/*debe recibir combinacion que sera la de la maquina o del usuario*/
	public Combinacion obtenerResultado(Combinacion ultimaCombinacion) {
		
		
		/*PROBAR A RECORRER LA LISTA Y BUSCAR EN EL MAPA EN VEZ DE RECORRER EL MAPA COMO AHORA*/
		
		
		
		
		
		boolean encontrado = false;
		int negro=0;
		int blanco=0;
		int rojo=0;
		Combinacion combinacionResultado = new Combinacion(dificultad);
		/*nombreMap.get(K clave); // Devuelve el valor de la clave que se le pasa como parámetro 
		 *la clave va a ser la posicion en la lista del que estemos buscando y 
		 * si lo que devuelve es igual a lo que hay en la lista en esa posicion coincide color y posicino*/
			/*nombreMap.get(K clave); // Devuelve el valor de la clave que se le pasa como parámetro*/
		
		
		
		//METE LA COMBINACION DE FICHAS EN LA LISTA CONVIRTIENDOLA ANTES A NUMEROS
		listaColoresCombinacion = convertirALista(ultimaCombinacion);


		//BUSCA NEGROS
//		do {
			for(int j=0;j<dificultad.getCasilla();j++) {
				//busca en el mapa el valor de la lista en la posicion j, si esta y ademas esta en la posicion j estara en el mismo lugar
				/*hacer dos bucles fro con i y j y estaas condiciones
				 * if(mapaComparacion.get(i)==listaColoresCombinacion.get(j) && i==j)
				 * else if(mapaComparacion.get(i)==listaColoresCombinacion.get(j) && i!=j)*/
				if(mapaComparacion.get(j)==listaColoresCombinacion.get(j)) {
					negro++;
					mapaComparacion.remove(j,listaColoresCombinacion.get(j));
					listaColoresCombinacion.remove(j);
				}else {
					blanco++;
				}
//				if(mapaComparacion.containsValue(listaColoresCombinacion.get(j)) && mapaComparacion.containsKey(j)) {
//					negro++;
//					mapaComparacion.remove(j,listaColoresCombinacion.get(j));
//					listaColoresCombinacion.remove(j);
//					//se incrementa el contador de negros y se borra la clave y el valor del mapa y el de la lista
//				}
			}
//			encontrado = true;//una vez recorridas todas las posiciones, ya tiene todos los negros, por lo tanto salimos
//		}while(encontrado);//este while es para que busque los negros
			
			//BUSCA LOS BLANCOS
//			for(int j=0;j<mapaComparacion.size();j++) {
//				for(int i=0;i<mapaComparacion.size();i++) {
//					if(mapaComparacion.get(i) == listaColoresCombinacion.get(j)) {
//						blanco++;
//						mapaComparacion.remove(j,listaColoresCombinacion.get(j));
//						listaColoresCombinacion.remove(j);
//					}
////					if(mapaComparacion.containsValue(listaColoresCombinacion.get(j))) {
////						blanco++;
////						mapaComparacion.remove(j,listaColoresCombinacion.get(j));
////						listaColoresCombinacion.remove(j);
////					}
//				}
//			
//			}
			
			
		
		
		for(int i=0;i< negro;i++) {
			combinacionResultado.añadirFicha(0,i);//el 0 es el color negro
		}
		for(int i=0;i< blanco;i++) {
			combinacionResultado.añadirFicha(1,i);//el 1 es el color blanco
		}
		rojo =  dificultad.getCasilla() - negro - blanco;
		for(int i=0;i< rojo;i++) {
			combinacionResultado.añadirFicha(2,i);//el 2 es el color rojo
		}
		/*cuando se comparen y se sepa la combinacionResultado se pasara al arrayList listaResultado*/
		return combinacionResultado;
	}
	

	
//	public Combinacion IAConcurso() {
//		Combinacion combIntento = new Combinacion(dificultad);
//		Combinacion ultimaComb = new Combinacion(dificultad);
//		ArrayList<Combinacion> listaUltimaComb = new ArrayList<Combinacion>();
//		int random;
//		Random rnd = new Random();
//		
//		for (int i = 0; i<dificultad.getCasilla(); i++) {
//			random = rnd.nextInt(dificultad.getColores());
//			combIntento.añadirFicha(random, i);
//		}
//		
//		if(listaUltimaComb != null && !listaUltimaComb.isEmpty()) {
//			ultimaComb = listaUltimaComb.get(listaUltimaComb.size()-1);
//			
//			if(ultimaComb.equals(combIntento) == true) {
//				for (int i = 0; i<dificultad.getCasilla(); i++) {
//					random = rnd.nextInt(dificultad.getColores());
//					combIntento.añadirFicha(random, i);
//				}
//			}
//		}
//		
//		return combIntento;
//	}
	

	
	public static void main(String[] args) {
	Dificultad dificultad  = Dificultad.INDIVIDUAL;
	Maquina m = new Maquina(dificultad);
	Combinacion c = new Combinacion(dificultad);
	Combinacion cSecreta = new Combinacion(dificultad);
	Combinacion cRespuesta = new Combinacion(dificultad);
	
//////	Tablero t = new Tablero();
//////	
//////	for (int i = 0; i < 10; i++) {
//////		c = m.crearCombinacionPrueba();
//////		System.out.println(c);
//////		cRespuesta = m.obtenerResultado();
//////	}
////	Maquina m = new Maquina(dificultad);
////	
////	c = m.crearCombinacionPrueba();
////	
////	c.dibujar();
////	//t.añadirJugada(c, cRespuesta);
////	
////	//t.dibujar();
//		
//		Dificultad dificultad = Dificultad.INDIVIDUAL;
//		Maquina maquina = new Maquina(dificultad);
//		Usuario u = new Usuario(dificultad);
//		Combinacion intento = new Combinacion(dificultad);
//		Combinacion secreta = new Combinacion(dificultad);
//		Combinacion respuesta = new Combinacion(dificultad);
//		Tablero tablero = new Tablero();
//		
//		secreta = u.crearCombinacionSecreta();
//		intento = u.rellenarCombinacion();
//		
//		respuesta = maquina.obtenerResultado();
//		tablero.añadirJugada(intento, respuesta);
//		
//		
//		tablero.dibujar();
	cSecreta = m.crearCombinacionSecreta();
	c = m.rellenarCombinacion();
	cRespuesta = m.obtenerResultado(c);
//	cRespuesta = m.obtenerResultado(c);
//	System.out.println(cRespuesta.combinacion[3].getColor());
//	ArrayList<Integer> combinacionConvertida = new ArrayList<Integer>();
//	combinacionConvertida = m.convertirALista(cRespuesta);
	System.out.printf("SECRETA: ");cSecreta.dibujar();
	System.out.println();
	System.out.printf("INTENTO: ");c.dibujar();
	System.out.println();
	System.out.printf("RESPUESTA: ");cRespuesta.dibujar();
	

	
//	for(int i =0 ; i<combinacionConvertida.size();i++) {
//		System.out.printf("%d" ,combinacionConvertida.get(i));
//	}

		
		
		
		

		
	
}

}
