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
		this.sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
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
	
	
}
