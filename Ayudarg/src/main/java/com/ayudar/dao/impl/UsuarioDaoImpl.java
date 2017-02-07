package com.ayudar.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.Usuario;

public class UsuarioDaoImpl implements UsuarioDAO {
	private SessionFactory sessionFactory;
//	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listUsuarios() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Usuario> usuarioList = session.createQuery("from Usuario").list();
		return usuarioList;
	}
	
	public void setSessionFactory(SessionFactory sf){
		sessionFactory = sf;
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}

	@Override
	public boolean usuarioByUsernameAndPassword(String email, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		Usuario usuario = (Usuario) session.createQuery("from Usuario as us WHERE us.email=" + email + "AND contrasenia =" + password).uniqueResult();
		if(usuario != null)
			return true;
		else 
			return false;
	}

}
