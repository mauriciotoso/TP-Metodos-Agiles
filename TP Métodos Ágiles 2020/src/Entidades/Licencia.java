package Entidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.*;

@Entity
@Table(name="licencia")
public class Licencia {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer idlicencia;
	private Clase licenciaMoto;
	private Clase licenciaOtro;
	private Calendar fechaVencimiento;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="dni")
	private Titular titular;
	private String observaciones;
	private Integer copia;

	public Licencia() {}
	
	public Licencia(Clase licenciaMoto, Clase licenciaOtro, Calendar fechaVencimiento,
			Titular titular, String observaciones) {
		super();
		this.licenciaMoto = licenciaMoto;
		this.licenciaOtro = licenciaOtro;
		this.fechaVencimiento = fechaVencimiento;
		this.titular = titular;
		this.observaciones = observaciones;
		this.copia=0;
	}

	public int getIdlicencia() {
		return idlicencia;
	}

	public void setIdlicencia(int idlicencia) {
		this.idlicencia = idlicencia;
	}

	public Clase getLicenciaMoto() {
		return licenciaMoto;
	}

	public void setLicenciaMoto(Clase licenciaMoto) {
		this.licenciaMoto = licenciaMoto;
	}

	public Clase getLicenciaOtro() {
		return licenciaOtro;
	}
	
	public Integer getCopia() {
		return this.copia;
	}
	
	public Integer setCopia(Integer nro) {
		return this.copia=nro;
	}

	public void setLicenciaOtro(Clase licenciaOtro) {
		this.licenciaOtro = licenciaOtro;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
	

	@Override
	public String toString() {
		return "Licencia [idlicencia=" + idlicencia + ", licenciaMoto=" + licenciaMoto + ", licenciaOtro="
				+ licenciaOtro + ", fechaVencimiento=" + new SimpleDateFormat("dd/MM/yyyy").format(fechaVencimiento.getTime())+ ", titular=" + titular + ", observaciones="
				+ observaciones + "]";
	}
	
	public void actualizarCopia() {
		this.copia = this.copia+1;
		
	}
	
}
