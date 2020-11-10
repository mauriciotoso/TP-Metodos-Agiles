package Entidades;

import java.util.Calendar;
import javax.persistence.*;

@Entity
@Table(name="titular")
public class Titular {
	@Id
	@Column(length=100)
	private String dni;
	private String apellido;
	private String nombre;
	private String direccion;
	private String depto;
	private String piso;
	private Calendar fechaNacimiento;
	private GrupoSanguineo grupoSanguineo;
	// Factor RH: POSITIVO = true ; NEGATIVO = false;
	private boolean factorRH;
	// Donante: ES = true ; NO ES = false;
	private boolean esDonante;
	@OneToOne
	@JoinColumn(name="idlicencia")
	private Licencia licencia;
	
	public Titular() {
		
	}
	
	public Titular(String dni, String apellido, String nombre, String direccion, String depto, String piso,
			Calendar fechaNacimiento, GrupoSanguineo grupoSanguineo, boolean factorRH, boolean esDonante) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.direccion = direccion;
		this.depto = depto;
		this.piso = piso;
		this.fechaNacimiento = fechaNacimiento;
		this.grupoSanguineo = grupoSanguineo;
		this.factorRH = factorRH;
		this.esDonante = esDonante;
	}
	
	public Titular(String dni, String apellido, String nombre, String direccion,
			Calendar fechaNacimiento, GrupoSanguineo grupoSanguineo, boolean factorRH, boolean esDonante) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.direccion = direccion;
		this.depto = "-";
		this.piso = "-";
		this.fechaNacimiento = fechaNacimiento;
		this.grupoSanguineo = grupoSanguineo;
		this.factorRH = factorRH;
		this.esDonante = esDonante;
	}
	

	public Licencia getLicencia() {
		return licencia;
	}

	public void setLicencia(Licencia licencia) {
		this.licencia = licencia;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDepto() {
		return depto;
	}
	public void setDepto(String depto) {
		this.depto = depto;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Calendar fecha_nacimiento) {
		this.fechaNacimiento = fecha_nacimiento;
	}
	public GrupoSanguineo getGrupoSanguineo() {
		return grupoSanguineo;
	}
	public void setGrupoSanguineo(GrupoSanguineo grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}
	public boolean isFactorRH() {
		return factorRH;
	}
	public void setFactorRH(boolean factorRH) {
		this.factorRH = factorRH;
	}
	public boolean isEsDonante() {
		return esDonante;
	}
	public void setEsDonante(boolean esDonante) {
		this.esDonante = esDonante;
	}

	@Override
	public String toString() {
		return "Titular [dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + "]";
	}

	
	
}
