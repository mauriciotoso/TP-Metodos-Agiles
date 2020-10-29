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
		Integer diferenciaMeses, cantidadA�os;
		
		fechaActual = Calendar.getInstance();
		Integer edad = ClaseLicencia.calcularEdad(fechaNacimiento);
		
		
		//CALCULAMOS LOS MESES DE DIFERENCIA ENTRE HOY Y EL CUMPLEA�OS
		if(fechaNacimiento.get(Calendar.MONTH) < fechaActual.get(Calendar.MONTH))
			fechaNacimiento.set(Calendar.YEAR, fechaActual.get(Calendar.YEAR) + 1);
		else
			fechaNacimiento.set(Calendar.YEAR, fechaActual.get(Calendar.YEAR));
		
		fechaVencimiento = fechaNacimiento;
		
		int a�o = fechaNacimiento.get(Calendar.YEAR);
		int mes = fechaNacimiento.get(Calendar.MONTH) + 1;
		int dia = fechaNacimiento.get(Calendar.DATE);
		LocalDate fechaNac = LocalDate.of(a�o, mes, dia);
		LocalDate fechaAct = LocalDate.now();
		Period diferencia = Period.between(fechaNac, fechaAct);
		
		diferenciaMeses = Math.abs(diferencia.getMonths());
					
		
		//VEMOS CU�NTOS A�OS CORRESPONDE SEG�N EDAD
		if(edad<=21) {
			if(TitularDao.buscarTitular(DNI).getLicencia().isEmpty()) //Buscamos al titular y dsps su licencia
				cantidadA�os = 1;
			else
				cantidadA�os = 3;
		}else if(edad <= 46) {
			cantidadA�os = 5;
		}else if(edad <= 60) {
			cantidadA�os = 4;
		}else if(edad <= 70) {
			cantidadA�os = 3;
		}else if(edad> 70) {
			cantidadA�os = 3;
		}
		
		if(diferenciaMeses <= 6) 
			fechaVencimiento.add(Calendar.YEAR, cantidadA�os);			
		else 
			fechaVencimiento.add(Calendar.YEAR, cantidadA�os - 1);	
		
		
		
		return fechaVencimiento;
		
}
