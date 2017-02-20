package com.ayudar.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ayudarg.dao.LocalidadesDAO;
import com.ayudarg.model.LocalidadesSQL;
import com.ayudarg.model.ProvinciasSQL;

public class LocalidadesDaoImpl implements LocalidadesDAO{
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<LocalidadesSQL> getAllLocalidades() {
		Session session = this.sessionFactory.getCurrentSession();
		List<LocalidadesSQL> localidadesList = session.createQuery("from LocalidadesSQL").list();
		return localidadesList;
	}

	@Override
	public List<LocalidadesSQL> getLocalidadesByIdO(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<LocalidadesSQL> localidadesList = session.createQuery("from LocalidadesSQL WHERE idProvincia="+id).list();
		return localidadesList;
	}

}
