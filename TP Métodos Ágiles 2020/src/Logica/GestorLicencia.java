package Logica;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import BDD.GestorBDD;
import Entidades.Clase;
import Entidades.CostosLicencia;
import Entidades.Licencia;
import Entidades.Titular;

public class GestorLicencia {
	
	private static GestorLicencia gestorLicencia;
	
	private GestorLicencia() {}
	
	public static GestorLicencia getInstance() {
		if(gestorLicencia == null) {
			gestorLicencia = new GestorLicencia();
		}
		return gestorLicencia;
	}
	
	public void crearLicencia(Titular titular, Clase moto,Clase otro, String observaciones) {
		
		Calendar vigencia = GestorLicencia.getInstance().calcularVigencia(titular);
		Licencia licencia = new Licencia(moto,otro,vigencia,titular, observaciones);
		titular.setLicencia(licencia);
		
		GestorBDD.getInstance().guardarLicencia(licencia);
		GestorBDD.getInstance().actualizarLicenciaDeTitular(titular);
		
	}
	
	public Calendar calcularVigencia(Titular titular) {
		
		Calendar fechaActual, fechaVencimiento;
		Integer diferenciaMeses, cantidadAnios;
		Calendar fechaNacimiento = Calendar.getInstance();
		
		int anioOriginal=titular.getFechaNacimiento().get(Calendar.YEAR);
		int mesOriginal=titular.getFechaNacimiento().get(Calendar.MONTH);
		int diaOriginal=titular.getFechaNacimiento().get(Calendar.DATE);
		
		fechaNacimiento.set(anioOriginal,mesOriginal+1,diaOriginal);
		
		fechaActual = Calendar.getInstance();
		Integer edad = CostosLicencia.calcularEdad(fechaNacimiento);
		
		//CALCULAMOS LOS MESES DE DIFERENCIA ENTRE HOY Y EL CUMPLEAï¿½OS
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
		System.out.println(diferenciaMeses);
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
			cantidadAnios = 1;//Aca no deberia ser 1 año??
		}
		
		if(diferenciaMeses <= 6) 
			fechaVencimiento.add(Calendar.YEAR, cantidadAnios);			
		else 
			fechaVencimiento.add(Calendar.YEAR, cantidadAnios - 1);	
		
		return fechaVencimiento;
		
}

	public boolean enRangoRenovacion(Licencia licencia){
		
		Calendar fechaVencimiento=licencia.getFechaVencimiento();
		int anio = fechaVencimiento.get(Calendar.YEAR);
		int mes = fechaVencimiento.get(Calendar.MONTH) + 1;
		int dia = fechaVencimiento.get(Calendar.DATE);
		
		LocalDate fv = LocalDate.of(anio,mes,dia);
		LocalDate fv45menos  = fv.minus(45, ChronoUnit.DAYS);

		Calendar fechaActual = Calendar.getInstance();
		anio = fechaActual.get(Calendar.YEAR);
		mes = fechaActual.get(Calendar.MONTH) + 1;
		dia = fechaActual.get(Calendar.DATE);
		LocalDate actual = LocalDate.of(anio,mes,dia);
		
		Date datefv = Date.from(fv.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date datefv45menos = Date.from(fv45menos.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date dateactual = Date.from(actual.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		return (dateactual.before(datefv)&&dateactual.after(datefv45menos));
	}
	
	public boolean vencida(Licencia licencia){
		if(licencia==null) return false;
		
		Calendar fechaVencimiento=licencia.getFechaVencimiento();
		int anio = fechaVencimiento.get(Calendar.YEAR);
		int mes = fechaVencimiento.get(Calendar.MONTH) + 1;
		int dia = fechaVencimiento.get(Calendar.DATE);
		LocalDate fv = LocalDate.of(anio,mes,dia);
		
		Calendar fechaActual = Calendar.getInstance();
		anio = fechaActual.get(Calendar.YEAR);
		mes = fechaActual.get(Calendar.MONTH) + 1;
		dia = fechaActual.get(Calendar.DATE);
		LocalDate actual = LocalDate.of(anio,mes,dia);
		
		Date datefv = Date.from(fv.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date dateactual = Date.from(actual.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		return (dateactual.after(datefv));
	}
	
	
	public void actualizarLicencia(Licencia licenciaEncontrada) {
		GestorBDD.getInstance().actualizarLicencia(licenciaEncontrada);
		
	}
	
	public ArrayList<Licencia> getLicenciasVencidas(){
		ArrayList<Licencia> licencias = (ArrayList<Licencia>) GestorBDD.getInstance().getLicencias();
		ArrayList<Licencia> licenciasExpiradas = new ArrayList<>(); 
		
		for(Licencia l:licencias) {
			if(GestorLicencia.getInstance().vencida(l)==true) {
				licenciasExpiradas.add(l);
			}
		}
		
		return licenciasExpiradas;
	}
	
	public ArrayList<Licencia> getLicenciasVigentes(){
		ArrayList<Licencia> licencias = (ArrayList<Licencia>) GestorBDD.getInstance().getLicencias();
		ArrayList<Licencia> licenciasVigentes= new ArrayList<>(); 
		
		for(Licencia l:licencias) {
			if(GestorLicencia.getInstance().vencida(l)==false) {
				licenciasVigentes.add(l);
			}
		}
		
		return licenciasVigentes;
	}
	
	public void crearCopia(Licencia licencia) {
		licencia.actualizarCopia();
		GestorBDD.getInstance().actualizarLicencia(licencia);
		
		
	}
	
}
