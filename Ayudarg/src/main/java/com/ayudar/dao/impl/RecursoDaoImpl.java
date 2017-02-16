package com.ayudar.dao.impl;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import com.ayudarg.dao.RecursoDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.Institucion;
import com.ayudarg.model.Recurso;
import com.ayudarg.model.Rol;
import com.ayudarg.model.Usuario;

public class RecursoDaoImpl implements RecursoDAO {
	private SessionFactory sessionFactory;
//	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Recurso> listRecursos() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Recurso> recursosList = session.createQuery("from Recurso").list();
		for(Recurso us : recursosList){
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
	public Institucion getInstitucionById(String idIns) {
		Session session = this.sessionFactory.getCurrentSession();
		Institucion i = (Institucion) session.createQuery("from Categoria WHERE idInstitucion='"+idIns+"'").uniqueResult();
		return i;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void insertRecurso(String categoriaIdCategoria, String nombre, Date fechaCreacion, String institucionIdInstitucion, int cantidad){
		Session session = this.sessionFactory.getCurrentSession();
		
		Categoria c = getCategoriaById(categoriaIdCategoria);

		Institucion i = getInstitucionById(institucionIdInstitucion);
		
		Recurso us = new Recurso();
//		us.setIdRecuso(idRecurso);
		us.setNombre(nombre);
		us.setFechaCreacion(fechaCreacion);
//		us.setUsuarioIdUsuario(usuarioIdUsuario);
//		us.setUsuarioRolIdRol(usuarioRolIdRol);
//		us.setInstitucionIdInstitucion(institucionIdInstitucion);
		us.setCantidad(cantidad);
//		us.setActivo(true);
        //Save the employee in database
        session.save(us);
        //Commit the transaction
        //session.getTransaction().commit(); 
        session.flush();
	}

}
