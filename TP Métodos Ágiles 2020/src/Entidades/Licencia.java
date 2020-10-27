package Entidades;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;

public class Licencia {
	private Integer DniTitular;
	private ArrayList<Clase> tipoLicencia;
	private Calendar fechaVencimiento;
	
	
	public Calendar calcularVigencia(Calendar fechaNacimiento) {
		Calendar fechaActual, fechaVencimiento;
		Integer diferenciaMeses, cantidadAños;
		
		fechaActual = Calendar.getInstance();
		Integer edad = ClaseLicencia.calcularEdad(fechaNacimiento);
		
		
		//CALCULAMOS LOS MESES DE DIFERENCIA ENTRE HOY Y EL CUMPLEAÑOS
		if(fechaNacimiento.get(Calendar.MONTH) < fechaActual.get(Calendar.MONTH))
			fechaNacimiento.set(Calendar.YEAR, fechaActual.get(Calendar.YEAR) + 1);
		else
			fechaNacimiento.set(Calendar.YEAR, fechaActual.get(Calendar.YEAR));
		
		fechaVencimiento = fechaNacimiento;
		
		int año = fechaNacimiento.get(Calendar.YEAR);
		int mes = fechaNacimiento.get(Calendar.MONTH) + 1;
		int dia = fechaNacimiento.get(Calendar.DATE);
		LocalDate fechaNac = LocalDate.of(año, mes, dia);
		LocalDate fechaAct = LocalDate.now();
		Period diferencia = Period.between(fechaNac, fechaAct);
		
		diferenciaMeses = Math.abs(diferencia.getMonths());
					
		
		//VEMOS CUÁNTOS AÑOS CORRESPONDE SEGÚN EDAD
		if(edad<=21) {
			if(TitularDao.buscarTitular(DNI).getLicencia().isEmpty()) //Buscamos al titular y dsps su licencia
				cantidadAños = 1;
			else
				cantidadAños = 3;
		}else if(edad <= 46) {
			cantidadAños = 5;
		}else if(edad <= 60) {
			cantidadAños = 4;
		}else if(edad <= 70) {
			cantidadAños = 3;
		}else if(edad> 70) {
			cantidadAños = 3;
		}
		
		if(diferenciaMeses <= 6) 
			fechaVencimiento.add(Calendar.YEAR, cantidadAños);			
		else 
			fechaVencimiento.add(Calendar.YEAR, cantidadAños - 1);	
		
		
		
		return fechaVencimiento;
		
}
}
