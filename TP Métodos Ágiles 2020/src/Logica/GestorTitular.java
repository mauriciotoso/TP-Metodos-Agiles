package Logica;

import java.util.Calendar;
import BDD.GestorBDD;
import Entidades.*;


public class GestorTitular {
	
	private static GestorTitular gestorTitular;
	
	private GestorTitular() {
		
	}
	
	public static GestorTitular getInstance() {
		if(gestorTitular == null) {
			gestorTitular = new GestorTitular();
		}
		return gestorTitular;
	}

	public Titular buscarTitular(String dniTitular) {		
		System.out.println(dniTitular);
		return GestorBDD.getInstance().getTitular(dniTitular);
	}

	public boolean verificarDNI(String dni) {
		boolean noExiste=true;
		noExiste= GestorBDD.getInstance().verificarDNITitular(dni);
		
		return noExiste;
	}
	
	public void crearTitular(String dni, String apellido, String nombre, String calle, String nro, String depto, String piso, Calendar fecha,
			String grupoSanguineo, String factorRH, boolean esDonante) {
		boolean factor;
		String direccion = new String();
		direccion += calle;
		direccion +=" ";
		direccion +=nro;
		GrupoSanguineo.valueOf(grupoSanguineo);
		if(depto.isEmpty()) depto+="-";
		if(piso.isEmpty()) piso+="-";
		if(factorRH.compareTo("POSITIVO")==0) {
			factor = true;
		}else {
			factor = false;
		}
		Titular titular = new Titular(dni, apellido, nombre, direccion, depto, piso, fecha,GrupoSanguineo.valueOf(grupoSanguineo),factor,esDonante);
		
		GestorBDD.getInstance().guardarTitular(titular);
		
	}
	
}
