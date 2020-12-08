package BDD;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import Entidades.*;

public class GestorBDD {
	private static GestorBDD gestorBDD;
	SessionFactory sessionFactory;
	Session session;
	
	private GestorBDD() {
		this.sessionFactory = new Configuration().configure().buildSessionFactory();
		this.session = sessionFactory.openSession();
	}
	
	public static GestorBDD getInstance() {
		if(gestorBDD==null) {
			gestorBDD = new GestorBDD();
		}
		return gestorBDD;
	}

	public List<Licencia> getLicencias(){
		if(!session.isJoinedToTransaction()) session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Licencia> licencias = session.createQuery("from Licencia").getResultList();
		session.getTransaction().commit();
		
		return licencias;
	}

	public Licencia getLicencia(int idlicencia) {
		
		if(!session.isJoinedToTransaction()) session.beginTransaction();
		Licencia t = session.get(Licencia.class, idlicencia);
		session.getTransaction().commit();
		
		return t;
	}
	
	public void guardarLicencia(Licencia licencia) {
		if(!session.isJoinedToTransaction()) session.beginTransaction();
		session.save(licencia);	
		session.getTransaction().commit();
	}	

	
	public List<Titular> getTitulares(){
		if(!session.isJoinedToTransaction()) session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Titular> titulares= session.createQuery("from Titular").getResultList();
		session.getTransaction().commit();
		
		return titulares;
	}
	
	public Titular getTitular(String dni) {
		
		if(!session.isJoinedToTransaction()) session.beginTransaction();
		Titular t = session.get(Titular.class, dni);
		session.getTransaction().commit();
		
		return t;
	}
	
	public void guardarTitular(Titular titular) {
		if(!session.isJoinedToTransaction()) session.beginTransaction();
		session.save(titular);		
		session.getTransaction().commit();
	}
	
	public void actualizarLicenciaDeTitular(Titular titular) {
		if(!session.isJoinedToTransaction()) session.beginTransaction();
		session.update(titular);		
		session.getTransaction().commit();
	}
	
	public void actualizarLicencia(Licencia licencia) {
		if(!session.isJoinedToTransaction()) session.beginTransaction();
		session.update(licencia);		
		session.getTransaction().commit();
	}
	
	public boolean verificarDNITitular (String dni) {
		if(!session.isJoinedToTransaction()) session.beginTransaction();
		Titular t = session.get(Titular.class, dni);
		session.getTransaction().commit();
		if(t!=null) {
			return false;
		}
		
		return true;
	}

	public void actualizarTitular(Titular titularModificado) {
		if(!session.isJoinedToTransaction()) session.beginTransaction();
		session.update(titularModificado);		
		session.getTransaction().commit();
		
	}
}
