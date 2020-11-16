package App;

import java.util.Calendar;
import BDD.GestorBDD;
import Entidades.*;

public class App {

	public static void main(String[] args) {
		
		Titular t = new Titular("1000","Toso","Mauricio","Pasaje Parpal 3055","-","-",Calendar.getInstance(),GrupoSanguineo.A,true,true, Sexo.MASCULINO);
		
		Calendar vencimiento = Calendar.getInstance();
		vencimiento.set(2020,10,30);
		
		Licencia l = new Licencia(null,Clase.B, vencimiento, t, "");
		
				
		t.setLicencia(l);

		GestorBDD.getInstance().guardarTitular(t);
		
		GestorBDD.getInstance().actualizarLicenciaDeTitular(t);
		
		//System.out.println(lista);
	
	}

}
