package com.ayudar.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import com.ayudarg.dao.RecursoHasCategoriaDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.RecursoHasCategoria;
import com.ayudarg.model.Usuario;

public class RecursoHasCategoriaDaoImpl implements RecursoHasCategoriaDAO {
	private SessionFactory sessionFactory;
//	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RecursoHasCategoria> listRecursoHasCategoria() {
		Session session = this.sessionFactory.getCurrentSession();
		List<RecursoHasCategoria> recursoHasCategoriaList = session.createQuery("from RecursoHasCategoria").list();
		for(RecursoHasCategoria us : recursoHasCategoriaList){
//			logger.info("recursoHasCategoriaList List::"+us);
		}
		return recursoHasCategoriaList;
	}
	
	public void setSessionFactory(SessionFactory sf){
		sessionFactory = sf;
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
