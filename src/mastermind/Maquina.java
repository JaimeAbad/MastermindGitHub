package mastermind;

import java.util.ArrayList;
import java.util.Random;


public class Maquina extends Usuario{
	
	Tablero tableroMaquina;
	Dificultad dificultad;
	Combinacion combinacionRespuesta;
	Maquina(Dificultad dificultad){
		this.dificultad = dificultad;
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
		}else if(dificultad == Dificultad.AUTOMATICO) {
			dificultad.getCasilla();
			dificultad.getIntentos();
			dificultad.getColores();
			dificultad.isRepeticion();
		}else {
			
		}
	}

	//esta combinacion es la que se le pasara al tablero del jugador
	@Override
	protected Combinacion crearCombinacionSecreta() {
		int random;
		Random rnd = new Random();
		Combinacion combinacion = new Combinacion(dificultad);
		
		for(int i=0; i<combinacion.dificultad.getCasilla(); i++) {
			random = rnd.nextInt(dificultad.getColores());
			mapaComparacion.put(i, random);
			combinacion.añadirFicha(random);
		}
		return combinacion;
	}

	//clase IA, devolvera la lista de combinacion
	@Override
	protected void rellenarCombinacion(/*Combinacion combinacionOculta*/) {/*IA, hay que tener en cuenta la dificultad y pasarle la combinacionResultado*/
		int random;
		Random rnd = new Random();
		Combinacion combinacion = new Combinacion(dificultad);
		//este arraylist en lugar de String sera de Combinacion
		ArrayList<Combinacion> listaCombinaciones = new ArrayList<Combinacion>();
		ArrayList<Ficha> listaColoresEncontrados = new ArrayList<Ficha>();
		ArrayList<Ficha> listaColoresDescartados= new ArrayList<Ficha>();
		//bucle principal, se crean combinaciones hasta que se acaben los intentos, QUITARLO PARA QUE VAYA DE 1 EN 1
		for(int i=0;i<dificultad.getIntentos();i++) {
					
			/*una vez creada la combinacion la meteremos en el arrayList, igual que hace el usuario para cuando sea maquina vs maquina*/
			
			if(listaCombinaciones.size()==0) {//si se da esta condicion quiere decir que es el primer intento, ya que no hya nada en la lista aun
				for(int j=0; j<dificultad.getCasilla(); j++) {/*1º Intento: aleatorio*/
					random = rnd.nextInt(dificultad.getColores());
					combinacion.añadirFicha(random);
				}
			}else {
				/*aqui sera el intento 2 o mas, por lo tanto, se coge la combinacion anterior y se cambian tanto colores como rojos halla
				 * en la combinacion respuesta*/
				
				/*desglosamos el ultimo resultado, es decir, el de la ultima combinacion*/
				Combinacion res;
				res = tableroMaquina.listaResultados.get(tableroMaquina.listaResultados.size()-1);/*ultima combinacionResultado*/
				int rojo = 0, negro = 0, blanco = 0;
				Ficha colorBlanco = new Ficha(dificultad, 1);
				Ficha colorRojo = new Ficha(dificultad, 2);
				
				/*obtenemos el numero de rojos, negros y blancos que hay en el resultado de la combinacion anterior*/
				for(int k=0; k<res.dificultad.getCasilla();k++) {
					if(res.combinacion[k]== colorRojo) {
						rojo ++ ;
					}else if(res.combinacion[k]== colorBlanco) {
						blanco ++;
					}else {
						negro ++ ; 
					}
				}
				
				//obtenemos la ultima combinacion, a partir de la cual vamos a trabajar
				Ficha colorAuxiliar;
				Combinacion ultimaCombinacion;
				ultimaCombinacion = listaCombinaciones.get(listaCombinaciones.size()-1);/*ultima combinacion*/
				/*segun el resultado, añadir colores usados a la lista correspondiente y crear la nueva*/
				if(rojo == dificultad.getCasilla()) {/*si todos rojos: */
					/*todos los colores de la lista anterior a la ListaColoresDescartados*/
					for(int k=0;k<ultimaCombinacion.dificultad.getCasilla();k++) {
						listaColoresDescartados.add(ultimaCombinacion.combinacion[k]);
					}
					
					//recorrer el array de colores y ver si estan en la lista de descartes, si es que no añadirlos a la de kant 
					for(int k=0;k<ultimaCombinacion.dificultad.getCasilla();k++) {
						colorAuxiliar = new Ficha(dificultad,k);
						if(listaColoresDescartados.contains(colorAuxiliar) == false) {
							listaColoresEncontrados.add(colorAuxiliar);
						}
					}
				
					/*una vez sabidos los colores que estan y los que no, generamos otra nueva combinacion*/
					for(int k =0 ; k<dificultad.getCasilla();k++) {
						/*obtenemos un numero al azar de entre los colores de la lista*/
						random = rnd.nextInt(listaColoresEncontrados.size());
						/*le pasamos a la combinacion en la posicion de k el color que hemos obtenido aleatoriamente*/
						combinacion.combinacion[k] = listaColoresEncontrados.get(random);/*una ficha al azar de este arrayLisy*/;
					}/*una vez terminado este for habra una combinacion creada*/
					
				}else if(blanco == dificultad.getCasilla()) {/*si todos blancos: */
					/*todos los colores de la lista anterior a la ListaColores */
					for(int k=0;k<ultimaCombinacion.dificultad.getCasilla();k++) {
						listaColoresEncontrados.add(ultimaCombinacion.combinacion[k]);
					}
					
					//aqui recorreria el array de colores y añadiria los que no estan en la lista de encontrados a la de no encontrados
//					for(int k=0;k<ultimaCombinacion.dificultad.getCasilla();k++) {
//						colorAuxiliar = new Ficha(dificultad,k);
//						if(listaColoresEncontrados.contains(colorAuxiliar) == false) {
//							listaColoresDescartados.add(colorAuxiliar);
//						}
//					}
				
					/*una vez sabidos los colores que estan y los que no, generamos otra nueva combinacion a partir de los colores que sabemos
					 * que estam*/
					for(int k =0 ; k<dificultad.getCasilla();k++) {
						/*obtenemos un numero al azar de entre los colores de la lista*/
						random = rnd.nextInt(listaColoresEncontrados.size());
						/*le pasamos a la combinacion en la posicion de k el color que hemos obtenido aleatoriamente*/
						combinacion.combinacion[k] = listaColoresEncontrados.get(random);/*una ficha al azar de este arrayLisy*/;
					}/*una vez terminado este for habra una combinacion creada*/
				}else if(negro == dificultad.getCasilla()) {
					/*partida finalizada
					 * aunque pensar en comparar las combinaciones antes para no tener que hacerlo, aunqe
					 * creo que no se puede pq en ningun momento se tiene acceso a la combinacionSecreta*/
					System.out.println("CONGRATS!!!!!  YOU WIN!!!!!");
				}else if(rojo == 0) {
					/*si el resultado es entre blancos y negros: */
				}else if(rojo == 1) {
					/*si solo hay un rojo, crear la misma combinacion y cambiar el ultimo color
					 * MIRAR PENULTIMA FOTO DE JUGADA*/
				}else if(rojo == 2) {
					/*si solo hay un rojo, crear la misma combinacion y cambiar el ultimo color
					 * MIRAR ULTIMA FOTO DE JUGADA*/
				}
				
				
			}/*fin del else donde comienza la 2º o n jugada*/
			
			
			tableroMaquina.añadirCombinacion(combinacion);
		}

}

	public void obtenerResultado(ArrayList<Integer> listaColoresCombinacion) {
		
		int negro=0;
		int blanco=0;
		int rojo=0;
		Combinacion combinacionResultado = new Combinacion(dificultad);
		/*nombreMap.get(K clave); // Devuelve el valor de la clave que se le pasa como parámetro 
		 *la clave va a ser la posicion en la lista del que estemos buscando y 
		 * si lo que devuelve es igual a lo que hay en la lista en esa posicion coincide color y posicino*/
		for(int i=0;i<dificultad.getCasilla();i++) {
			/*nombreMap.get(K clave); // Devuelve el valor de la clave que se le pasa como parámetro*/
			for(int j=0;j<dificultad.getCasilla();j++) {
				
				//recorre el mapa y devuelve el contenido de la lista en la posicion i
				if(mapaComparacion.get(j) == listaColoresCombinacion.get(i) && i==j) {
					negro++;
					
				}else if(mapaComparacion.get(j) == listaColoresCombinacion.get(i) && i==j) {
					blanco++;
					
				}else {
				
				}
				
			}
			
		}
		
		rojo = combinacionResultado.dificultad.getCasilla() - negro - blanco;
		for(int i=0;i< negro;i++) {
			combinacionResultado.añadirFicha(0);//el 0 es el color negro
		}
		for(int i=0;i< blanco;i++) {
			combinacionResultado.añadirFicha(1);//el 1 es el color blanco
		}
		for(int i=0;i< rojo;i++) {
			combinacionResultado.añadirFicha(2);//el 3 es el color rojo
		}
		//cuando se cree la combinacion del resultado se añade al tablero que lo mete en la lista de resultados
		tableroMaquina.añadirRespuesta(combinacionResultado);
		/*cuando se comparen y se sepa la combinacionResultado se pasara al arrayList listaResultado*/
	}

//	public Combinacion IA() {
//	int random;
//Random rnd = new Random();
//Combinacion combinacion = new Combinacion(dificultad);
//
//
////bucle principal, se crean combinaciones hasta que se acaben los intentos
//for(int i=0;i<dificultad.getIntentos();i++) {
//
//
///*una vez creada la combinacion la meteremos en el arrayList, igual que hace el usuario para cuando sea maquina vs maquina*/
///*1º Intento: aleatorio*/
//for(int j=0; j<dificultad.getCasilla(); j++) {
//random = rnd.nextInt(dificultad.getColores());
//combinacion.añadirFicha(random);
//}
//tableroMaquina.añadirCombinacion(combinacion);
//}
//	}


	
	
	//BUEN EJEMPLO
//	public String prueba(int n) {
//		
//		Ficha f = new Ficha(Dificultad.INDIVIDUAL,n);
//
//		
//		return String.format("%s",f.getColor());//poner el getColor para que no salga el hashcode
//	}
//
//
//	public static void main(String[] args) {
//		Maquina m = new Maquina(Dificultad.INDIVIDUAL);
//		for(int i=0;i<5;i++) {
//			System.out.println(m.prueba(i));
//		}
//		
//	}
}
