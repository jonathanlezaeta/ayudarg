package com.ayudar.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ayudarg.dao.ProvinciasDAO;
import com.ayudarg.model.ProvinciasSQL;

public class ProvinciasDaoImpl implements ProvinciasDAO{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<ProvinciasSQL> getAllProvincias() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ProvinciasSQL> provinciasList = session.createQuery("from ProvinciasSQL").list();
		return provinciasList;
	}

}
