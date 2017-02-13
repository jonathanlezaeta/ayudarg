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
	public void insertRecurso(int idRecurso, String nombre, Date fechaCreacion, int usuarioIdUsuario, int usuarioRolIdRol, int institucionIdInstitucion, int cantidad) {
		Session session = this.sessionFactory.getCurrentSession();
		
		Categoria c = new Categoria();
		c.setIdCategoria();
		c.setNombre();
		c.setFechaCreacion(fechaCreacion);
		c.setCategoriaIdCategoria();
		
		Recurso us = new Recurso();
		us.setIdRecuso(idRecurso);
		us.setNombre(nombre);
		us.setFechaCreacion(fechaCreacion);
		us.setUsuarioIdUsuario(usuarioIdUsuario);
		us.setUsuarioRolIdRol(usuarioRolIdRol);
		us.setInstitucionIdInstitucion(institucionIdInstitucion);
		us.setCantidad(cantidad);
        //Save the employee in database
        session.save(us);
        //Commit the transaction
        //session.getTransaction().commit(); 
        session.flush();
	}

}
