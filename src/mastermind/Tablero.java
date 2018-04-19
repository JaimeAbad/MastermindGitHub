package mastermind;

import java.util.ArrayList;


public class Tablero /*implements Dibujable*/{
	
	
	/*for each de los arrays con los colores de ficha que muestre los colores posibles
	 * o lista con numeros y su correspondiente color---- 0.- NEGRO por ejemplo*/
	
	
	
	/*2 tableros, uno para jugador y uno para maquina*/
	
	Dificultad dificultad;
	Combinacion combinacion, combinacionSecreta;
	
	ArrayList<Combinacion> listaIntentos = new ArrayList<Combinacion>();/*dificultad.getIntentos() es el tamaño maximo del arrayList*/
	/*Iterator it = (Iterator) listaIntentos.iterator();*/ //iterador para mostrar la lista 
	/*hacer mapa para comparar y devolver el resultado*/
	
	Tablero(Combinacion combinacionSecreta){
		this.combinacionSecreta = combinacionSecreta;
	}
	
	//este metodo sobra creo
//	public ArrayList<Combinacion> rellenarTableroConCombinacion(Combinacion combinacion) {
//		
//		return listaIntentos;
//		
//	}
	
	public Combinacion añadirCombinacion(Combinacion comb) {
		listaIntentos.add(combinacion);
		return combinacion;
	}
	
//	public String devolverRespuesta() {
//		al comparar la combinacion y la combinacionSecreta se genera una respuesta de colores
//	}
	
	public String toString() {
		return String.format("%s", listaIntentos);
	}
	
	
}
