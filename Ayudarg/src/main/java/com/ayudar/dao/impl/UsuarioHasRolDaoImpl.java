package com.ayudar.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import com.ayudarg.dao.RecursoHasCategoriaDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.dao.UsuarioHasRolDAO;
import com.ayudarg.model.RecursoHasCategoria;
import com.ayudarg.model.Usuario;
import com.ayudarg.model.UsuarioHasRol;

public class UsuarioHasRolDaoImpl implements UsuarioHasRolDAO {
	private SessionFactory sessionFactory;
//	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioHasRol> listUsuarioHasRol() {
		Session session = this.sessionFactory.getCurrentSession();
		List<UsuarioHasRol> usuarioHasRolList = session.createQuery("from UsuarioHasRol").list();
		for(UsuarioHasRol us : usuarioHasRolList){
//			logger.info("recursoHasCategoriaList List::"+us);
		}
		return usuarioHasRolList;
	}
	
	public void setSessionFactory(SessionFactory sf){
		sessionFactory = sf;
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
