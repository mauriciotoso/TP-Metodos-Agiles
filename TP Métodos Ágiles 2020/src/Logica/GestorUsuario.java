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
	
	public Boolean verificarUsuario(String nombreUsuario) {
		boolean noExiste=true;
		
		
		noExiste= GestorBDD.getInstance().verificarUsuario(nombreUsuario);
		
		return noExiste;
	}
	
	public void guardarUsuario(String user, String contrasenia) {
		Usuario usuario = new Usuario(user, contrasenia);
		GestorBDD.getInstance().guardarUsuario(usuario);
		
	}

	public void actualizarUsuario(Usuario usuario, String contraseniaNueva) {
		
		usuario.setContrasenia(contraseniaNueva);
		GestorBDD.getInstance().actualizarUsuario(usuario);
		
	}

	public Usuario getUsuario(String usuarioABuscar) {
		
		return GestorBDD.getInstance().getUsuario(usuarioABuscar);
	}

}
