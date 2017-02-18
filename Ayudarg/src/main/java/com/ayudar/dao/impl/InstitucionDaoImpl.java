package com.ayudar.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import com.ayudarg.dao.InstitucionDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.Rol;
import com.ayudarg.model.UsuarioSQL;

public class InstitucionDaoImpl implements InstitucionDAO {
	private SessionFactory sessionFactory;
//	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InstitucionSQL> listInstituciones() {
		Session session = this.sessionFactory.getCurrentSession();
		List<InstitucionSQL> institucionesList = session.createQuery("from Institucion").list();
		for(InstitucionSQL us : institucionesList){
//			logger.info("Usuario List::"+us);
		}
		return institucionesList;
	}
	
	public void setSessionFactory(SessionFactory sf){
		sessionFactory = sf;
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void insertInstitucion(String director, String ciudad, String tipo, String nombre, String direccion,
			String telefono, String celular, String sitioWeb, String email) {
		Session session = this.sessionFactory.getCurrentSession();
		InstitucionSQL us = new InstitucionSQL();
		us.setDirector(director);
		us.setCiudad(ciudad);
		us.setTipo(tipo);
		us.setNombre(nombre);
		us.setDireccion(direccion);
		us.setTelefono(telefono);
		us.setCelular(celular);
		us.setSitioWeb(sitioWeb);
		us.setEmail(email);
        //Save the employee in database
        session.save(us);
        //Commit the transaction
        //session.getTransaction().commit(); 
        session.flush();
	}
}
