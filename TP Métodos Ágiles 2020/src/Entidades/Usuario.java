package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer idUsuario;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private String dni;
	private String legajo;
	private String email;


public Usuario() {}

public Usuario(String nombre, String apellido, String dni, String legajo, String email, String contra) {
	this.nombre=nombre;
	this.apellido =apellido;
	this.email = email;
	this.dni = dni;
	this.legajo = legajo;
	this.contrasenia=contra;
	
}

public String getContrasenia() {
	return contrasenia;
}


public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
}


public Integer getIdUsuario() {
	return idUsuario;
}

public void setIdUsuario(Integer idUsuario) {
	this.idUsuario = idUsuario;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}

public String getLegajo() {
	return legajo;
}

public void setLegajo(String legajo) {
	this.legajo = legajo;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getnombre() {
	return nombre;
}


public void setnombre(String nombre) {
	this.nombre = nombre;
}


@Override
public String toString() {
	return "Usuario [contrasenia=" + contrasenia + ", nombre=" + nombre + "]";
}
}
