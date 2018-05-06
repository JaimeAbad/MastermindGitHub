package mastermind;

import java.util.ArrayList;


public class Tablero implements Dibujable{
	
	Dificultad dificultad;
	Combinacion combinacion, combinacionSecreta;
	ArrayList<Combinacion> listaResultados = new ArrayList<Combinacion>();
	ArrayList<Combinacion> listaIntentos = new ArrayList<Combinacion>();
	
	Tablero(Combinacion combinacionSecreta){
		this.combinacionSecreta = combinacionSecreta;
	}
	
	
	public Combinacion añadirCombinacion(Combinacion comb) {
		listaIntentos.add(combinacion);
		return combinacion;
	}
	
	public Combinacion añadirRespuesta(Combinacion comb) {
		listaResultados.add(combinacion);
		return combinacion;
	}
	

	
	public String toString() {
		return String.format("%s%s", listaIntentos,listaResultados);
	}


	@Override
	public void dibujar() {
		System.out.printf("%s | %s", listaIntentos, listaResultados);
	}

	
}
