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
	private String usuario;


public Usuario() {}

public Usuario(String user, String contra) {
	this.contrasenia=contra;
	this.usuario=user;
}

public String getContrasenia() {
	return contrasenia;
}


public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
}


public String getUsuario() {
	return usuario;
}


public void setUsuario(String usuario) {
	this.usuario = usuario;
}


@Override
public String toString() {
	return "Usuario [contrasenia=" + contrasenia + ", usuario=" + usuario + "]";
}
}
