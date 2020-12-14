package Logica;

import BDD.GestorBDD;
import Entidades.Usuario;

public class GestorUsuario {
	
	private static GestorUsuario gestorUsuario;
	
	private GestorUsuario() {}
	
	public static GestorUsuario getInstance() {
		if(gestorUsuario  == null) {
			gestorUsuario = new GestorUsuario();
		}
		return gestorUsuario;
	}
	

	
	public boolean verificarDNI(String dni) {
		boolean noExiste=true;
		noExiste= GestorBDD.getInstance().verificarDNIUsuario(dni);
		
		return noExiste;
	}
	
	public boolean verificarLegajo(String legajo) {
		boolean noExiste=true;
		noExiste= GestorBDD.getInstance().verificarLegajoUsuario(legajo);
		
		return noExiste;
	}
	public boolean verificarEmail(String email) {
		boolean noExiste=true;
		noExiste= GestorBDD.getInstance().verificarEmailUsuario(email);
		
		return noExiste;
	}
	
	
	
	public void guardarUsuario(String nombre, String apellido, String dni, String legajo, String email, String contrasenia) {
		Usuario usuario = new Usuario(nombre, apellido, dni, legajo, email, contrasenia);
		GestorBDD.getInstance().guardarUsuario(usuario);
		
	}

	public void actualizarUsuario(Usuario usuario, String nom, String ap, String mail) {
		
		usuario.setNombre(nom);
		usuario.setApellido(ap);
		usuario.setEmail(mail);
		GestorBDD.getInstance().actualizarUsuario(usuario);
		
	}

	public Usuario getUsuario(String usuarioLegajo) {
		
		return GestorBDD.getInstance().getUsuario(usuarioLegajo);
	}

}
