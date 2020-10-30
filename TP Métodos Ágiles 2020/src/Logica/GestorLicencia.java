package Logica;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;

import Entidades.Clase;
import Entidades.CostosLicencia;
import Entidades.Licencia;
import Entidades.Titular;

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
	
	public void crearLicencia(Titular titular, ArrayList<Clase> clases) {
		Calendar vigencia = GestorLicencia.getInstance().calcularVigencia(titular);
		Licencia licencia = new Licencia(clases,vigencia,titular);
		titular.setLicencia(licencia);
		
		//Guardamos licencia
		//Actualizamos titular
		System.out.println(new SimpleDateFormat("dd-mm-yyyy").format(vigencia.getTime()));
	}
	
	public Calendar calcularVigencia(Titular titular) {
		Calendar fechaActual, fechaVencimiento;
		Integer diferenciaMeses, cantidadAnios;
		Calendar fechaNacimiento=titular.getFechaNacimiento();
		
		fechaActual = Calendar.getInstance();
		Integer edad = CostosLicencia.calcularEdad(fechaNacimiento);
		
		//CALCULAMOS LOS MESES DE DIFERENCIA ENTRE HOY Y EL CUMPLEA�OS
		if(fechaNacimiento.get(Calendar.MONTH) < fechaActual.get(Calendar.MONTH))
			fechaNacimiento.set(Calendar.YEAR, fechaActual.get(Calendar.YEAR) + 1);
		else
			fechaNacimiento.set(Calendar.YEAR, fechaActual.get(Calendar.YEAR));
		
		fechaVencimiento = fechaNacimiento;
		
		int anio = fechaNacimiento.get(Calendar.YEAR);
		int mes = fechaNacimiento.get(Calendar.MONTH) + 1;
		int dia = fechaNacimiento.get(Calendar.DATE);
		LocalDate fechaNac = LocalDate.of(anio, mes, dia);
		LocalDate fechaAct = LocalDate.now();
		Period diferencia = Period.between(fechaNac, fechaAct);
		
		diferenciaMeses = Math.abs(diferencia.getMonths());
					
		
		//VEMOS CUANTOS ANIOS CORRESPONDE SEGUN EDAD
		if(edad<=21) {
			if(titular.getLicencia()==null) //Buscamos al titular y dsps su licencia
				cantidadAnios = 1;
			else
				cantidadAnios = 3;
		}else if(edad <= 46) {
			cantidadAnios = 5;
		}else if(edad <= 60) {
			cantidadAnios = 4;
		}else if(edad <= 70) {
			cantidadAnios = 3;
		}else {
			cantidadAnios = 3;
		}
		
		if(diferenciaMeses <= 6) 
			fechaVencimiento.add(Calendar.YEAR, cantidadAnios);			
		else 
			fechaVencimiento.add(Calendar.YEAR, cantidadAnios - 1);	
		
		
		
		return fechaVencimiento;
		
}

}
