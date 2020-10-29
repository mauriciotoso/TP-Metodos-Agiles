package Logica;

public class GestorLicencia {

	
	private static GestorLicencia gestorLicencia;
	
	private GestorLicencia() {
		
	}
	
	public static GestorLicencia getInstance() {
		if(gestorLicencia == null) {
			gestorLicencia = new GestorLicencia();
		}
		return gestorLicencia;
	}

}
