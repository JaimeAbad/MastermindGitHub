package mastermind;

public class Menu {

	private int modo;
	private int opcion;
	private String instrucciones = "Instrucciones del mastermind";
	Menu(){
		
		do {
			System.out.println("  __  __           _            __  __ _           _ \r\n" + 
					" |  \\/  |         | |          |  \\/  (_)         | |\r\n" + 
					" | \\  / | __ _ ___| |_ ___ _ __| \\  / |_ _ __   __| |\r\n" + 
					" | |\\/| |/ _` / __| __/ _ | '__| |\\/| | | '_ \\ / _` |\r\n" + 
					" | |  | | (_| \\__ | ||  __| |  | |  | | | | | | (_| |\r\n" + 
					" |_|  |_|\\__,_|___/\\__\\___|_|  |_|  |_|_|_| |_|\\__,_|");
			
			System.out.println(" 1. INSTRUCCIONES\n 2. INDIVIDUAL\n 3. EXPERTO\n 4. AUTOMATICO");
			modo = Teclado.leerEntero();
			
		}while(modo>=5);
		
		if(modo==1) {
			String.format("%s", instrucciones);
		}else if(modo==2) {
			
			System.out.println("¿Quieres jugar o que juegue la maquina?:\n 1- Jugar 2- Maquina");
			opcion = Teclado.leerEntero();
			

		}else if(modo == 3) {
			System.out.println("¿Quien empezará a jugar?:\n 1- Jugador 2- Maquina");
			opcion = Teclado.leerEntero();
		}else {
			System.out.println("Elige la velocidad del juego:\n 1- Lento 2- Rapido");
			opcion = Teclado.leerEntero();
		}
	}
	
	
	
	public static void main(String[] args) {

		Menu menudazo = new Menu();
		System.out.println(menudazo);

		
	}



	public int getModo() {
		return modo;
	}



	public void setModo(int modo) {
		this.modo = modo;
	}



	public int getOpcion() {
		return opcion;
	}



	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}



	public String getInstrucciones() {
		return instrucciones;
	}



	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}

}
