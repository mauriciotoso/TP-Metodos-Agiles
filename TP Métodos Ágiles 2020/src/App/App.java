package App;

import java.util.Calendar;
import BDD.GestorBDD;
import Entidades.*;

public class App {

	public static void main(String[] args) {
		
		Titular t = new Titular("41160820","Toso","Mauricio","Pasaje Parpal 3055","-","-",Calendar.getInstance(),GrupoSanguineo.A,true,true);
		//Licencia l = new Licencia(null,Clase.B,Calendar.getInstance(),t,"-");
		//t.setLicencia(l);

		GestorBDD.getInstance().guardarTitular(t);
		
		//GestorBDD.getInstance().actualizarLicenciaDeTitular(t);
		
		//System.out.println(lista);
	
	}

}
