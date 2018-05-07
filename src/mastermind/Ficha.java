package mastermind;

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

public class Ficha extends Constantes implements Dibujable{


	
	private String color;
	Dificultad dificultad;
	public static final char CIRCULO = '\u2b24';
	public static final char CIRCULO_PEQUEÑO = '\u23fa';
	//en lugar de poner los espacios podemos poner los circulos, pero en lugar del fondo hay que poner el color
	private static String[] fichasFacilMedio =  {NEGRO+CIRCULO+ RESET,
			BLANCO+CIRCULO+RESET,
			ROJO+CIRCULO+RESET,
			VERDE+CIRCULO+RESET,
			AMARILLO+CIRCULO+RESET,
			AZUL+CIRCULO+RESET,
			MORADO+CIRCULO+RESET,
			CELESTE+CIRCULO+RESET};
	private static String[] fichasDificil = {NEGRO+"  " + RESET,
			BLANCO+CIRCULO+RESET,
			ROJO+CIRCULO+RESET,
			VERDE+CIRCULO+RESET,
			AMARILLO+CIRCULO+RESET,
			AZUL+CIRCULO+RESET,
			MORADO+CIRCULO+RESET,
			CELESTE+CIRCULO+RESET,
			GRIS+CIRCULO+RESET,
			ROJOCLARO+CIRCULO+RESET};
	
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
		return String.format("%s%s", color, fichasFacilMedio);
		
	}
	
	//interfaz
	public void dibujar() {
		System.out.printf("%s", getColor());
	}
	
	public boolean equals(Object obj) {
		boolean resultado = false;
		if (obj instanceof Ficha ){
			resultado = true;
		}
			
		return resultado;
	}
	public static void main(String[] args) {
		Ficha f = new Ficha(Dificultad.AUTOMATICO,2);
		f.dibujar();
	}
	
}
