package Logica;

import java.util.ArrayList;
import java.util.Calendar;
import Entidades.Clase;
import Entidades.GrupoSanguineo;
import Entidades.Licencia;
import Entidades.Titular;

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
		Titular titular=new Titular("41160819","Toso","Matias","BV",Calendar.getInstance(),GrupoSanguineo.A,true,false);
		
		ArrayList<Clase> clases = new ArrayList<Clase>();
		clases.add(Clase.A);
		clases.add(Clase.C);
		//
		Calendar c = Calendar.getInstance();
		
		c.add(Calendar.DAY_OF_MONTH, 50);
		//
		//titular.setLicencia(new Licencia(clases,c,titular,"-"));
		return titular;
		
	}
	
}
