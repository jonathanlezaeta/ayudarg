package com.ayudar.dao.impl;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import com.ayudarg.dao.InstitucionDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.dao.CategoriaDAO;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.LocalidadesSQL;
import com.ayudarg.model.Rol;
import com.ayudarg.model.UsuarioSQL;

public class InstitucionDaoImpl implements InstitucionDAO {
	private SessionFactory sessionFactory;
//	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InstitucionSQL> listInstituciones() {
		Session session = this.sessionFactory.getCurrentSession();
		List<InstitucionSQL> institucionesList = session.createQuery("from InstitucionSQL WHERE activo=1").list();
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
	public InstitucionSQL getInstitucionById(String idIns) {
		Session session = this.sessionFactory.getCurrentSession();
		InstitucionSQL i = (InstitucionSQL) session.createQuery("from InstitucionSQL WHERE idInstitucion='"+idIns+"' AND activo=1").uniqueResult();
		return i;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public LocalidadesSQL getLocalidadesById(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		LocalidadesSQL l = (LocalidadesSQL) session.createQuery("from LocalidadesSQL WHERE localidadesId='"+id+"' AND activo=1").uniqueResult();
		return l;
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
	public void insertInstitucion(String director, String ciudad, String tipo, String nombre, String direccion,
			String telefono, String celular, String sitioWeb, String email, String localidadesId, String[] idCategoria) {
		Session session = this.sessionFactory.getCurrentSession();
		InstitucionSQL us = new InstitucionSQL();
		LocalidadesSQL lq = new LocalidadesSQL();
		HashSet<Categoria> categoriaSet = new HashSet<>();
		for (String cat : idCategoria) {
			Categoria catid = getCategoriaById(cat);
			categoriaSet.add(catid);
		}
		lq.setLocalidadesId(Integer.parseInt(localidadesId));
		us.setDirector(director);
		us.setTipo(tipo);
		us.setNombre(nombre);
		us.setDireccion(direccion);
		us.setTelefono(telefono);
		us.setCelular(celular);
		us.setSitioWeb(sitioWeb);
		us.setEmail(email);
		us.setActivo(true);
		us.setLocalidadesId(lq);
		us.setCategoria(categoriaSet);
        session.save(us);
        session.flush();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void updateInstitucion(String institucion, String director, String ciudad, String tipo, String nombre, String direccion,
			String telefono, String celular, String sitioWeb, String email, String localidadesId, String[] idCategoria) {
		Session session = this.sessionFactory.getCurrentSession();
		InstitucionSQL us = new InstitucionSQL ();
		us.setIdInstitucion(Integer.parseInt(institucion));
		LocalidadesSQL lq = new LocalidadesSQL();
		lq.setLocalidadesId(Integer.parseInt(localidadesId));
		HashSet<Categoria> categoriaSet = new HashSet<>();
		for (String cat : idCategoria) {
			Categoria catid = getCategoriaById(cat);
			categoriaSet.add(catid);
		}
		us.setDirector(director);
		us.setTipo(tipo);
		us.setNombre(nombre);
		us.setDireccion(direccion);
		us.setTelefono(telefono);
		us.setCelular(celular);
		us.setSitioWeb(sitioWeb);
		us.setEmail(email);
		us.setLocalidadesId(lq);
		us.setActivo(true);
		us.setCategoria(categoriaSet);
        session.update(us);
        session.flush();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteInstitucion(String institucion) {
		Session session = this.sessionFactory.getCurrentSession();
		InstitucionSQL insti = this.getInstitucionById(institucion);
		insti.setActivo(false);
		session.update(insti);
		session.flush();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InstitucionSQL> getInstitucionesByCategoriaByLocalidd(String idLocalidd, String[] categorias){
		Session session = this.sessionFactory.getCurrentSession();
		List<InstitucionSQL> institucionesList = session.createQuery("from InstitucionSQL WHERE activo=1 AND localidadesId="+idLocalidd).list();
		ArrayList<InstitucionSQL> result = new ArrayList<InstitucionSQL>();
		for(InstitucionSQL inst : institucionesList){
			Set<Categoria> categoriasByInstitucion = inst.getCategoria();
			Iterator<Categoria> it = categoriasByInstitucion.iterator();
			while(it.hasNext()){
				Categoria categoria = it.next();
				for(String id : categorias){
					if(categoria.getIdCategoria() == Integer.parseInt(id)){
						if(!result.contains(inst))
							result.add(inst);
					}
				}
			}
		}
		return result;
	}
}
