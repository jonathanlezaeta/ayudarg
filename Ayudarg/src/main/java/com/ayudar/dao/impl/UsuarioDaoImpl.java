package com.ayudar.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.Rol;
import com.ayudarg.model.UsuarioSQL;

public class UsuarioDaoImpl implements UsuarioDAO {
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioSQL> listUsuarios() {
		Session session = this.sessionFactory.getCurrentSession();
		List<UsuarioSQL> usuarioList = session.createQuery("from Usuario").list();
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
		UsuarioSQL usuario = (UsuarioSQL) session.createQuery("from UsuarioSQL WHERE email='"+ email + "' AND contrasenia='" + password + "'").uniqueResult();
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public UsuarioSQL getUsuarioById(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		UsuarioSQL u = (UsuarioSQL) session.createQuery("from UsuarioSQL WHERE idUsuario='"+id+"'").uniqueResult();
		return u;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void insertUsuario(int rolIdRol, String usuario, String contrasenia, String nombre, String email,
			String telefono, String celular, Date fechaDeNacimiento, String ciudadOrigen) {
		Session session = this.sessionFactory.getCurrentSession();
		Rol r = new Rol();
		r.setNombre("U");
		r.setIdRol(1);
		UsuarioSQL us = new UsuarioSQL();
		us.setUsuario(usuario);
		us.setContrasenia(contrasenia);
		us.setNombre(nombre);
		us.setEmail(email);
		us.setTelefono(telefono);
		us.setCelular(celular);
		us.setFechaDeNacimiento(fechaDeNacimiento);
		us.setCiudadOrigen(ciudadOrigen);
		us.getRol().add(r);
        //Save the employee in database
        session.save(us);
        //Commit the transaction
//        session.getTransaction().commit(); 
        session.flush();
	}

}
