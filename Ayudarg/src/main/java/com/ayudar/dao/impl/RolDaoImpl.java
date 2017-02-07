package com.ayudar.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import com.ayudarg.dao.RolDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.Rol;
import com.ayudarg.model.Usuario;

public class RolDaoImpl implements RolDAO {
	private SessionFactory sessionFactory;
//	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> listRoles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Rol> rolesList = session.createQuery("from Rol").list();
		for(Rol us : rolesList){
//			logger.info("Rol List::"+us);
		}
		return rolesList;
	}
	
	public void setSessionFactory(SessionFactory sf){
		sessionFactory = sf;
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
