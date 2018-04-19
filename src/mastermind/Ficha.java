package mastermind;

public class Ficha extends Constantes{


	
	private String color;
	Dificultad dificultad;
	private static String[] fichasFacilMedio =  {FONDO_NEGRO+"  " + RESET,
			FONDO_ROJO+"  "+RESET,
			FONDO_VERDE+"  "+RESET,
			FONDO_AMARILLO+"  "+RESET,
			FONDO_AZUL+"  "+RESET,
			FONDO_MORADO+"  "+RESET,
			FONDO_CELESTE+"  "+RESET,
			FONDO_BLANCO+"  "+RESET};
	private static String[] fichasDificil = {FONDO_NEGRO+"  " + RESET,
			FONDO_ROJO+"  "+RESET,
			FONDO_VERDE+"  "+RESET,
			FONDO_AMARILLO+"  "+RESET,
			FONDO_AZUL+"  "+RESET,
			FONDO_MORADO+"  "+RESET,
			FONDO_CELESTE+"  "+RESET,
			FONDO_BLANCO+"  "+RESET,
			FONDO_GRIS+"  "+RESET,
			FONDO_ROJOCLARO+"  "+RESET};
	
	Ficha(Dificultad dificultad, int posicion){
		this.dificultad = dificultad;
		if(dificultad == Dificultad.INDIVIDUAL || dificultad == Dificultad.EXPERTO) {
			color = fichasFacilMedio[posicion];
		}else {
			color = fichasDificil[posicion];
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return String.format("%s", color);
	}
	

	
	
//	public static void main(String[] args) {
//		
////		Ficha fichita = new Ficha();
////		int color, color2, color1;
////		System.out.println(fichita.toString());
////		System.out.println("Introduce un color");
////		color = Teclado.leerEntero();
////		System.out.println("Introduce un color");
////		color1 = Teclado.leerEntero();
////		System.out.println("Introduce un color");
////		color2 = Teclado.leerEntero();
////		System.out.println(fichita.dameFicha(color) + fichita.dameFicha(color1) + fichita.dameFicha(color2));
//		
////		Ficha ficha = new Ficha();
////		System.out.println(ficha.dameFicha(5));
//		Dificultad d = Dificultad.INDIVIDUAL;
//		Ficha fic = new Ficha(d,0);
//		
//		System.out.println(fic.getColor());
//	} 
	
}
