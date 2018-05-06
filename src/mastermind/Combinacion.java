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
	
	
	
	//hashCode y equals, que servirá por si el usuario quiere cambiar el color de una posicion
	
//	public String[] crearCombinacion() {
//		
//		String[] combinacion;
//		int x;
//		boolean completa = false;
//		
//		//REVISAR Y PENSAR
//		if(dificultad == Dificultad.INDIVIDUAL) {
//			final int POSICION_MAX = 4;
//			combinacion = new String[POSICION_MAX];
//			
//			//esto debe ir en el main
//			ficha = Teclado.leerEntero("Elige la ficha que quieres colocar: ");
//			System.out.println("Elige una posicion: 1-2-3-4");
//			x = Teclado.leerEntero();
//			
//			//esta combinacion hay que meterla en el arrayList, ya que cada vez que se haga una es un intento
//			//Combinacion combinacionFacil = new Combinacion(x,ficha);
//		}else if(dificultad == Dificultad.EXPERTO) {
//			final int POSICION_MAX = 5;
//			combinacion = new String[POSICION_MAX];
//			
//			//esto debe ir en el main
//			ficha = Teclado.leerEntero("Elige la ficha que quieres colocar: ");
//			System.out.println("Elige una posicion: 1-2-3-4-5");
//			x = Teclado.leerEntero();
//			
//		}else {
//			final int POSICION_MAX = 8;
//			combinacion = new String[POSICION_MAX];
//			
//			//esto debe ir en el main
//			
//			ficha = Teclado.leerEntero("Elige la ficha que quieres colocar: ");
//			System.out.println("Elige una posicion: 1-2-3-4-5-6-7-8");
//			x = Teclado.leerEntero();
//			
//			
//		}
//		return combinacion;
//	}
	
	//MAIN PRUEBAS
//	public static void main(String[] args) {
////		//Combinacion c = new Combinacion();
////		//System.out.println(c);
////		Combinacion combinacion = new Combinacion(Dificultad.INDIVIDUAL);
//////		for(int i=0;i<combinacion.combinacion.length;i++) {
////		int i=6;
////			combinacion.añadirFicha(i);
////			System.out.println(combinacion);
//////		}
////		
//
//		Dificultad f;
//		f = Dificultad.INDIVIDUAL;
//		Combinacion c = new Combinacion(f);
//			
//		for(int i=0;i<f.getCasilla();i++) {
//			c.añadirFicha(i);
//			c.dibujar();
//		}
//		
//		
//	}

}
