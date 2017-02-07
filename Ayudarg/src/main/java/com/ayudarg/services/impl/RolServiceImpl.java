package com.ayudarg.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ayudarg.dao.RolDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.Rol;
import com.ayudarg.model.Usuario;
import com.ayudarg.service.RolService;
import com.ayudarg.service.UsuarioService;

public class RolServiceImpl implements RolService{
	
	private RolDAO rolDao;
	
	@Transactional
	@Override
	public List<Rol> listRoles() {
		return rolDao.listRoles();
	}

	public RolDAO getRolDao() {
		return rolDao;
	}

	public void setRolDao(RolDAO rolDao) {
		this.rolDao = rolDao;
	}

}
