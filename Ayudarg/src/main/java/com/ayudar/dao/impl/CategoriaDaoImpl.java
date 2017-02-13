package com.ayudar.dao.impl;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import com.ayudarg.dao.CategoriaDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.Recurso;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public void insertCategoria(int idCategoria, String nombre, Date fechaCreacion, int categoriaIdCategoria) {
		Session session = this.sessionFactory.getCurrentSession();
		Categoria us = new Categoria();
		us.setIdCategoria(idCategoria);
		us.setNombre(nombre);
		us.setFechaCreacion(fechaCreacion);
		us.setCategoriaIdCategoria(categoriaIdCategoria);

        //Save the employee in database
        session.save(us);
        //Commit the transaction
        //session.getTransaction().commit(); 
        session.flush();
	}

}