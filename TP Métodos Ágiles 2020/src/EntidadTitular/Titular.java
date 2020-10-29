package EntidadTitular;

import java.util.Calendar;

public class Titular {
	
	private Integer dni;
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
	
	/* !!!!!!!!!!
	 
	DESCOMENTAR CUANDO SE MERGEE Y ESTE LICENCIA
	
	private Licencia licencia;
	
	!!!!!!!!!!
	*/
	
	public Titular() {
		
	}
	
	public Titular(Integer dni, String apellido, String nombre, String direccion, String depto, String piso,
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
	
	public Titular(Integer dni, String apellido, String nombre, String direccion,
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
	
	public Integer getDni() {
		return dni;
	}
	
	public void setDni(Integer dni) {
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
	
	
	
}
