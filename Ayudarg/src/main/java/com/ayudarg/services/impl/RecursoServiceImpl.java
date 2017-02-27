package com.ayudarg.services.impl;

import java.util.Date;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ayudarg.dao.RecursoDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.RecursoSQL;
import com.ayudarg.model.UsuarioSQL;
import com.ayudarg.service.RecursoService;
import com.ayudarg.service.UsuarioService;
@Transactional
public class RecursoServiceImpl implements RecursoService{
	
	private RecursoDAO recursoDao;

	@Override
	public List<RecursoSQL> listRecursos() {
		return recursoDao.listRecursos();
	}

	public RecursoDAO getRecursoDao() {
		return recursoDao;
	}

	public void setRecursoDao(RecursoDAO recursoDao) {
		this.recursoDao = recursoDao;
	}

	@Override
	public void insertRecurso(String nombre, String cantidad, String idCategoria) {
		recursoDao.insertRecurso(nombre, cantidad, idCategoria);
	}
	
	public void deleteRecurso(String nombre, String categoria) {
		recursoDao.deleteRecurso(nombre, categoria);
	}
}
		