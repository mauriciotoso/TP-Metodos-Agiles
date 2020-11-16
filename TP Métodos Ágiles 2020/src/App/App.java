package App;

import java.util.Calendar;
import BDD.GestorBDD;
import Entidades.*;

public class App {

	public static void main(String[] args) {
		

		Titular t = new Titular("41160820","Toso","Mauricio","Pasaje Parpal 3055","-","-",Calendar.getInstance(),GrupoSanguineo.A,true,true,Sexo.MASCULINO);
		Licencia l = new Licencia(null,Clase.B,Calendar.getInstance(),t,"-");
    
		Titular t = new Titular("1000","Toso","Mauricio","Pasaje Parpal 3055","-","-",Calendar.getInstance(),GrupoSanguineo.A,true,true, Sexo.MASCULINO);
		
		Calendar vencimiento = Calendar.getInstance();
		vencimiento.set(2020,10,30);
		
		Licencia l = new Licencia(null,Clase.B, vencimiento, t, "");
		
		
		t.setLicencia(l);

		GestorBDD.getInstance().guardarTitular(t);
		
		GestorBDD.getInstance().actualizarLicenciaDeTitular(t);
		
		//System.out.println(lista);
		
		/*Calendar fechaprueba = Calendar.getInstance();
		Titular tit = new Titular("93457343", "ksjfk", "hola lskjh", "El Paracao 111", "A","11",fechaprueba , GrupoSanguineo.AB, true, true, Sexo.FEMENINO);
		Licencia licencia = new Licencia(Clase.A,null,fechaprueba,tit, "hola uno dos tre alta observacion ahre skjfsl posdjflw wlkje");
		tit.setLicencia(licencia);
		GestorBDD.getInstance().guardarTitular(tit);
		*/
	
	}

}
