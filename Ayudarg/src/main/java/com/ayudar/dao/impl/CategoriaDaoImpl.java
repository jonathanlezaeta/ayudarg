package com.ayudar.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import com.ayudarg.dao.CategoriaDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.RecursoSQL;
import com.ayudarg.model.UsuarioSQL;

public class CategoriaDaoImpl implements CategoriaDAO {
	private SessionFactory sessionFactory;
//	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listCategorias() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Categoria> categoriasList = session.createQuery("from Categoria").list();
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
	public Categoria getCategoriaById(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		Categoria c = (Categoria) session.createQuery("from Categoria WHERE idCategoria='"+id+"'").uniqueResult();
		return c;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void insertCategoria(String nombre, String subcategorias){
		Session session = this.sessionFactory.getCurrentSession();
		Categoria categoria = new Categoria();
		Categoria superior = getCategoriaById(subcategorias);
		categoria.setNombre(nombre);
        java.sql.Date fechaCreacion = new java.sql.Date(new java.util.Date().getTime());
        categoria.setFechaCreacion(fechaCreacion);
        categoria.setSubcategoria(superior);
        session.save(categoria);
        session.flush();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteCategoria(String idCategoria){
		Session session = this.sessionFactory.getCurrentSession();
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(Integer.valueOf(idCategoria));
		session.delete(categoria);
		session.flush();
	}
}
