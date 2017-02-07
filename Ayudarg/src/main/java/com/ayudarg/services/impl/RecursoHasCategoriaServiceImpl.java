package com.ayudarg.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ayudarg.dao.RecursoHasCategoriaDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.RecursoHasCategoria;
import com.ayudarg.model.Usuario;
import com.ayudarg.service.RecursoHasCategoriaService;
import com.ayudarg.service.UsuarioService;

public class RecursoHasCategoriaServiceImpl implements RecursoHasCategoriaService{
	
	private RecursoHasCategoriaDAO recursoHasCategoriaDao;
	
	@Transactional
	@Override
	public List<RecursoHasCategoria> listRecursoHasCategoria() {
		return recursoHasCategoriaDao.listRecursoHasCategoria();
	}

	public RecursoHasCategoriaDAO getRecursoHasCategoriaDao() {
		return recursoHasCategoriaDao;
	}

	public void setRecursoHasCategoriaDao(RecursoHasCategoriaDAO recursoHasCategoriaDao) {
		this.recursoHasCategoriaDao = recursoHasCategoriaDao;
	}

}
