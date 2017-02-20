package com.ayudarg.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ayudarg.dao.LocalidadesDAO;
import com.ayudarg.dao.ProvinciasDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.UsuarioSQL;
import com.ayudarg.service.UsuarioService;
@Transactional
public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioDAO usuarioDao;
	
	@Override
	public List<UsuarioSQL> listUsuarios() {
		return usuarioDao.listUsuarios();
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	@Override
	public UsuarioSQL usuarioByUsernameAndPassword(String email, String password) {
		return usuarioDao.usuarioByUsernameAndPassword(email, password);
	}
	
	@Override
	public void insertUsuario(String usuario, String contrasenia, String nombre, String email, String telefono, String celular, Date fechaDeCreacion, String localidadesId){
		usuarioDao.insertUsuario(usuario, contrasenia, nombre, email, telefono, celular, fechaDeCreacion, localidadesId);
	}
	
}
