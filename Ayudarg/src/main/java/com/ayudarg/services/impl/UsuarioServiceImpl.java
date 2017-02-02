package com.ayudarg.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.Usuario;
import com.ayudarg.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioDAO usuarioDao;
	
	@Transactional
	@Override
	public List<Usuario> listUsuarios() {
		return usuarioDao.listUsuarios();
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

}
