package mastermind;


public class Constantes {

	public static final String RESET = "\u001B[0m";
	public static final String NEGRO = "\u001B[30m";//NEGRO
	public static final String ROJO = "\u001B[31m";
	public static final String VERDE = "\u001B[32m";
	public static final String AMARILLO = "\u001B[33m";
	public static final String AZUL = "\u001B[34m";
	public static final String MORADO = "\u001B[35m";
	public static final String CELESTE = "\u001B[36m";
	public static final String BLANCO = "\u001B[37m";
	
	public static final String FONDO_NEGRO = "\u001B[40m";
	public static final String FONDO_ROJO = "\u001B[41m";
	public static final String FONDO_VERDE = "\u001B[42m";
	public static final String FONDO_AMARILLO = "\u001B[43m";
	public static final String FONDO_AZUL = "\u001B[44m";
	public static final String FONDO_MORADO = "\u001B[45m";
	public static final String FONDO_CELESTE = "\u001B[46m";
	public static final String FONDO_BLANCO = "\u001B[47m";
	public static final String FONDO_GRIS = "\u001B[100m";
	public static final String FONDO_ROJOCLARO = "\u001B[101m";
	
	public static void main(String[] args) {
		
		//PRUEBAS
		final String CELESTE_BLANCO = "\u001B[36;47m"; //Detrás del código del CELESTE(36) se pone ; y el código del fondo blanco(47)
		final String CELESTE_BLANCO_NEGRITA = "\u001B[1;36;47m"; //1 es el código del negrita
		final String CELESTE_BLANCO_SUBRAYADO = "\u001B[4;36;47m"; //4 es el código del subrayado
		final String ROJO_AMARILLO = "\u001B[33;41m";
		
		System.out.println(ROJO + "Este texto es de color rojo" + RESET);
		System.out.println(VERDE + "...y ahora es verde" + RESET);
		System.out.println(FONDO_MORADO + "Fondo morado" + RESET);
		System.out.println(CELESTE_BLANCO + "Fondo blanco con texto celeste" + RESET);
		System.out.println(CELESTE_BLANCO_NEGRITA + "Fondo blanco con texto celeste en negrita" + RESET);
		System.out.println(CELESTE_BLANCO_SUBRAYADO + "Fondo blanco con texto celeste subrayado" + RESET);
		System.out.printf("%s\n",ROJO_AMARILLO +(char)9733 + RESET);//Estrella
		System.out.println(FONDO_ROJO + "  " + RESET); //cuadrado
		
//		String[] colores = new String[10];
//		
//		colores[0] = "\u001B[40m";
//		colores[1] = "\u001B[41m";
//		colores[2] = "\u001B[42m";
//		colores[3] = "\u001B[43m";
//		colores[4] = "\u001B[44m";
//		colores[5] = "\u001B[45m";
//		colores[6] = "\u001B[106m";
//		colores[7] = "\u001B[47m";
//		colores[8] = "\u001B[100m";
//		colores[9] = "\u001B[101m";
//		
//		for(int i=0;i<colores.length;i++) {
//			System.out.println(i+1 + colores[i] +"  " + RESET);
//		}
		
	}
}
