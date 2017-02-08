package com.ayudarg.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ayudarg.dao.RecursoHasCategoriaDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.dao.UsuarioHasRolDAO;
import com.ayudarg.model.RecursoHasCategoria;
import com.ayudarg.model.Usuario;
import com.ayudarg.model.UsuarioHasRol;
import com.ayudarg.service.RecursoHasCategoriaService;
import com.ayudarg.service.UsuarioHasRolService;
import com.ayudarg.service.UsuarioService;

public class UsuarioHasRolServiceImpl implements UsuarioHasRolService{
	
	private UsuarioHasRolDAO usuarioHasRolDao;
	
	@Transactional
	@Override
	public List<UsuarioHasRol> listUsuarioHasRol() {
		return usuarioHasRolDao.listUsuarioHasRol();
	}

	public UsuarioHasRolDAO getUsuarioHasRolDao() {
		return usuarioHasRolDao;
	}

	public void setUsuarioHasRol(UsuarioHasRolDAO usuarioHasRolDao) {
		this.usuarioHasRolDao = usuarioHasRolDao;
	}

}
