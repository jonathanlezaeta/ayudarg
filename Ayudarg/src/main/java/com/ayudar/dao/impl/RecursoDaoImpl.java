package com.ayudar.dao.impl;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Set;
import org.slf4j.LoggerFactory;

import com.ayudarg.dao.RecursoDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.RecursoSQL;
import com.ayudarg.model.Rol;
import com.ayudarg.model.UsuarioSQL;

public class RecursoDaoImpl implements RecursoDAO {
	private SessionFactory sessionFactory;
//	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RecursoSQL> listRecursos() {
		Session session = this.sessionFactory.getCurrentSession();
		List<RecursoSQL> recursosList = session.createQuery("from Recurso").list();
		for(RecursoSQL us : recursosList){
//			logger.info("Recurso List::"+us);
		}
		return recursosList;
	}
	
	public void setSessionFactory(SessionFactory sf){
		sessionFactory = sf;
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Categoria getCategoriaById(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		Categoria c = (Categoria) session.createQuery("from Categoria WHERE idCategoria='"+id+"'").uniqueResult();
		return c;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public InstitucionSQL getInstitucionById(String idIns) {
		Session session = this.sessionFactory.getCurrentSession();
		InstitucionSQL i = (InstitucionSQL) session.createQuery("from InstitucionSQL WHERE idInstitucion='"+idIns+"'").uniqueResult();
		return i;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void insertRecurso(String nombre,  String cantidad, String categoria){
		Session session = this.sessionFactory.getCurrentSession();
	

//        session.save();
//        session.flush();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteRecurso(String nombre, String categoria){
		Session session = this.sessionFactory.getCurrentSession();
		
		RecursoSQL r = (RecursoSQL) session.createQuery("from RecursoHasCategoria WHERE categoriaIdCategoria='"+categoria+"'").uniqueResult();
	}	

}
