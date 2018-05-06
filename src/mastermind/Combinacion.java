package mastermind;

import java.util.Arrays;

public class Combinacion implements Dibujable{


	Ficha[] combinacion;
	private Ficha f ;
	Dificultad dificultad;
	
	Combinacion(Dificultad dificultad){
		this.dificultad = dificultad;
		combinacion = new Ficha[dificultad.getCasilla()];
	}
	//se pedira por teclado el color que se qiere introducir en la 1 posicion, los colores estan en una lista del 1 al 10
	//este metodo añade la ficha que se e introduzca a la posicion que toque
	public Ficha[] añadirFicha(int color) {
		boolean ocupada = false;
		f = new Ficha(dificultad, color);
		/*trampa para que no me devuelva el hashcode*/
		//System.out.println(f.getColor());
		
		for(int i=0;i<dificultad.getCasilla();i++) {//recorre la combinacion y donde no halla color lo añade
			if(ocupada==false) {
				combinacion[i] = f;
				ocupada=true;
			}else {
				
			}
			
		}
		
		return combinacion;
	}
	
	public boolean equals(Object obj) {
		boolean resultado = false;
		if (obj instanceof Combinacion && Arrays.equals(combinacion, ((Combinacion) obj).combinacion)){
			resultado = true;
		}
			
		return resultado;
	}
	//recorre la combinacion y llama al dibujar de cada ficha
	public void dibujar() {
		for(int i = 0; i<dificultad.getCasilla();i++) {
			if(combinacion[i]!= null) {
				System.out.printf("%s ",combinacion[i].getColor());
			}
			
		}
	}
	


}
