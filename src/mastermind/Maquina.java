package mastermind;

import java.util.ArrayList;
import java.util.Random;


public class Maquina extends Usuario{
	
	Tablero tableroMaquina;
	Dificultad dificultad;
	Combinacion combinacionRespuesta;
	Maquina(Dificultad dificultad){
		this.dificultad = dificultad;
		if(dificultad == Dificultad.EXPERTO) {
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

	@Override
	protected void rellenarCombinacion() {/*IA, hay que tener en cuenta la dificultad*/
		/*una vez creada la combinacion la meteremos en el arrayList, igual que hace el usuario para cuando sea maquina vs maquina*/
		
		
		
		
	}

	public void obtenerResultado(ArrayList<Integer> listaColoresCombinacion) {
		
		int negro=0;
		int blanco=0;
		int rojo=0;
		Combinacion combinacionResultado = new Combinacion(dificultad);
		/*nombreMap.get(K clave); // Devuelve el valor de la clave que se le pasa como parámetro 
		 *la clave va a ser la posicion en la lista del que estemos buscando y 
		 * si lo que devuelve es igual a lo que hay en la lista en esa posicion coincide color y posicino*/
		for(int i=0;i<listaColoresCombinacion.size();i++) {
			/*nombreMap.get(K clave); // Devuelve el valor de la clave que se le pasa como parámetro*/
			for(int j=0;j<mapaComparacion.size();j++) {
				
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





}
