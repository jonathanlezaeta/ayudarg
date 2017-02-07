package com.ayudar.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import com.ayudarg.dao.CategoriaDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.Usuario;

public class CategoriaDaoImpl implements CategoriaDAO {
	private SessionFactory sessionFactory;
//	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listCategorias() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Categoria> categoriasList = session.createQuery("from Categorias").list();
		for(Categoria us : categoriasList){
//			logger.info("Usuario List::"+us);
		}
		return categoriasList;
	}
	
	public void setSessionFactory(SessionFactory sf){
		sessionFactory = sf;
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
