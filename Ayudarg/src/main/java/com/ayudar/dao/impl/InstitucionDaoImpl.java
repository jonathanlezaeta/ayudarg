package com.ayudar.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import com.ayudarg.dao.InstitucionDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.Institucion;
import com.ayudarg.model.Usuario;

public class InstitucionDaoImpl implements InstitucionDAO {
	private SessionFactory sessionFactory;
//	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Institucion> listInstituciones() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Institucion> institucionesList = session.createQuery("from Institucion").list();
		for(Institucion us : institucionesList){
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

}
