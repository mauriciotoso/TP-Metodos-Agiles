package Entidades;

import java.util.ArrayList;
import java.util.Calendar;

public class Licencia {

	private ArrayList<Clase> tipoLicencia;
	private Calendar fechaVencimiento;
	private Titular titular;
	private String observaciones;

	public Licencia() {
		
	}
	
	public Licencia(ArrayList<Clase> tipoLicencia, Calendar fechaVencimiento, Titular titular,String observaciones) {
		super();
		this.tipoLicencia = tipoLicencia;
		this.fechaVencimiento = fechaVencimiento;
		this.titular = titular;
	}

	public ArrayList<Clase> getTipoLicencia() {
		return tipoLicencia;
	}
	
	public void setTipoLicencia(ArrayList<Clase> tipoLicencia) {
		this.tipoLicencia = tipoLicencia;
	}

	public Calendar getFechaVencimiento() {
		return fechaVencimiento;
	}
	
	public void setFechaVencimiento(Calendar fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Titular getTitular() {
		return titular;
	}
	
	public void setTitular(Titular titular) {
		this.titular = titular;
	}

	
	
	
}
