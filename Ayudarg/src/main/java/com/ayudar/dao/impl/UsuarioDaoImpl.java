package com.ayudar.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.LocalidadesSQL;
import com.ayudarg.model.Rol;
import com.ayudarg.model.UsuarioSQL;

public class UsuarioDaoImpl implements UsuarioDAO {
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioSQL> listUsuarios() {
		Session session = this.sessionFactory.getCurrentSession();
		List<UsuarioSQL> usuarioList = session.createQuery("from UsuarioSQL").list();
		return usuarioList;
	}
	
	public void setSessionFactory(SessionFactory sf){
		sessionFactory = sf;
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public UsuarioSQL usuarioByUsernameAndPassword(String email, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		UsuarioSQL usuario = (UsuarioSQL) session.createQuery("from UsuarioSQL WHERE email='"+ email + "' AND contrasenia='" + password + "' AND activo=1").uniqueResult();
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public UsuarioSQL getUsuarioById(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		UsuarioSQL u = (UsuarioSQL) session.createQuery("from UsuarioSQL WHERE idUsuario='"+id+"' AND activo=1").uniqueResult();
		return u;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public UsuarioSQL getUsuarioByEmail(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		UsuarioSQL u = (UsuarioSQL) session.createQuery("from UsuarioSQL WHERE email='"+id+"'").uniqueResult();
		return u;
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
	public void insertUsuario(String usuario, String contrasenia, String nombre, String email,
			String telefono, String celular, Date fechaDeNacimiento, String localidadesId) {
		Session session = this.sessionFactory.getCurrentSession();
		Rol r = new Rol();
		r.setNombre("U");
		r.setIdRol(1);
		LocalidadesSQL lq = new LocalidadesSQL();
		lq.setLocalidadesId(Integer.parseInt(localidadesId));
		UsuarioSQL us = new UsuarioSQL();
		us.setUsuario(usuario);
		us.setContrasenia(contrasenia);
		us.setNombre(nombre);
		us.setEmail(email);
		us.setActivo(true);
		us.setTelefono(telefono);
		us.setCelular(celular);
		us.setFechaDeNacimiento(fechaDeNacimiento);
		us.setLocalidadesId(lq);
		us.getRol().add(r);
        session.save(us);
        session.flush();
	}
	

}
