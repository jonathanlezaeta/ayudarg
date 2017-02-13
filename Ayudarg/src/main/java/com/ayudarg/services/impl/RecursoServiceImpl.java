package com.ayudarg.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ayudarg.dao.RecursoDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.Recurso;
import com.ayudarg.model.Usuario;
import com.ayudarg.service.RecursoService;
import com.ayudarg.service.UsuarioService;

public class RecursoServiceImpl implements RecursoService{
	
	private RecursoDAO recursoDao;
	
	@Transactional
	@Override
	public List<Recurso> listRecursos() {
		return recursoDao.listRecursos();
	}

	public RecursoDAO getRecursoDao() {
		return recursoDao;
	}

	public void setRecursoDao(RecursoDAO recursoDao) {
		this.recursoDao = recursoDao;
	}

	@Override
	public void insertRecurso(int idRecurso, String nombre, java.sql.Date fechaCreacion, int usuarioIdUsuario,
			int usuarioRolIdRol, int institucionIdInstitucion, int cantidad) {
		recursoDao.insertRecurso(idRecurso, nombre, fechaCreacion, usuarioIdUsuario, usuarioRolIdRol, institucionIdInstitucion, cantidad);
		
	}

}
