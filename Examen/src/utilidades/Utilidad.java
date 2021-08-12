package utilidades;

public class Utilidad {
public void limpiandoPantalla() {
		
		System.out.println("Limpiando pantalla...");

		delay(5000);
		for(int i=0 ; i<10 ; i++) {
			System.out.println("\n");
		}
		System.out.println("\n");

		System.out.println("Pantalla limpia");
		
	}
	

	public void delay(long milis)
	{
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
