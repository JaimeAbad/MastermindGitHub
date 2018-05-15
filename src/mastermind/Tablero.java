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
public class Tablero implements Dibujable{
	
	/**
	 * Almacena la dificultad, 2 instancias de Combinacion y 2 arrayList, uno para la lista de intentos y otro de la lista de resultados
	 */
	
	Dificultad dificultad;
	Combinacion combinacion, combinacionSecreta;
	ArrayList<Combinacion> listaResultados = new ArrayList<Combinacion>();
	ArrayList<Combinacion> listaIntentos = new ArrayList<Combinacion>();
	
	
	/**
	 * Almacena la combinacion secreta
	 * @param combinacionSecreta La combinacion secreta que crea el usuari que no juega o el rival
	 */
	Tablero(){
		
	}
	Tablero(Combinacion combinacionSecreta){
		this.combinacionSecreta = combinacionSecreta;
	}
	
	/**
	 * Devuelve la combinacion intento
	 * @param combinacion se le pasa una combinacion intento
	 * @return 	La combinacion
	 * @see 	Combinacion
	 */
	public Combinacion añadirCombinacion(Combinacion combinacion) {
		listaIntentos.add(combinacion);
		return combinacion;
	}
	/**
	 * Devuelve la combinacion resultado
	 * @param comb se le pasa una combinacion resultado
	 * @return 	La combinacion
	 * @see 	Combinacion
	 */
	public Combinacion añadirRespuesta(Combinacion combinacion) {
		listaResultados.add(combinacion);
		return combinacion;
	}
	

	
//	public String toString() {
//		return String.format("%s%s", listaIntentos,listaResultados);
//	}
	/**
	 * Dibuja las listas que contiene las combinaciones de intentos y resultado
	 * @see 	void
	 */

	@Override
	public void dibujar() {
		for(int i=0;i<listaIntentos.size();i++) {
			listaIntentos.get(i).dibujar();
			System.out.printf(" | ");
			listaResultados.get(i).dibujar();
		}
		
	}
	
	public static void main(String[] args) {
	Dificultad dificultad  = Dificultad.INDIVIDUAL;
	Combinacion c = new Combinacion(dificultad);
	Combinacion cRespuesta = new Combinacion(dificultad);
	
	Tablero t = new Tablero();
	c.añadirFicha(1,0);
	c.añadirFicha(2,1);
	c.añadirFicha(3,2);
	c.añadirFicha(4,3);
	t.añadirCombinacion(c);
	cRespuesta.añadirFicha(0,0);
	cRespuesta.añadirFicha(0,1);
	cRespuesta.añadirFicha(1,2);
	cRespuesta.añadirFicha(2,3);
	t.añadirRespuesta(cRespuesta);
	
	t.dibujar();

}



	
}
